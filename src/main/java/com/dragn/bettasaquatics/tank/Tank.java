package com.dragn.bettasaquatics.tank;

import com.dragn.bettasaquatics.BettasAquaticsMain;
import com.dragn.bettasaquatics.decor.Decor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.WATERLOGGED;

public class Tank extends Block implements EntityBlock, SimpleWaterloggedBlock {

    public Tank() {
        super(Block.Properties.of(Material.GLASS).strength(0.7f).sound(SoundType.GLASS).noOcclusion());
        this.registerDefaultState(this.getStateDefinition().any().setValue(WATERLOGGED, false));
    }

    @Override
    public VoxelShape getInteractionShape(BlockState blockState, BlockGetter blockGetter, BlockPos pos) {
        return Shapes.block();
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
        BlockEntity tile = blockGetter.getBlockEntity(pos);
        if(tile instanceof TankTile) {
            return ((TankTile) tile).getShape();
        }
        return Shapes.empty();
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return (state.getValue(WATERLOGGED) ? Fluids.WATER : Fluids.EMPTY).defaultFluidState();
    }

    @Override
    public boolean placeLiquid(LevelAccessor level, BlockPos pos, BlockState blockState, FluidState fluidState) {
        if(!blockState.getValue(WATERLOGGED) && fluidState.is(Fluids.WATER)) {
            level.setBlock(pos, blockState.setValue(WATERLOGGED, true), 3);
        }
        return false;
    }

    @Override
    public BlockState updateShape(BlockState state1, Direction direction, BlockState state2, LevelAccessor level, BlockPos pos1, BlockPos pos2) {
        Block block = level.getBlockState(pos2).getBlock();
        if (block instanceof Tank) {
            ((TankTile) level.getBlockEntity(pos1)).addConnected(direction);
            ((TankTile) level.getBlockEntity(pos2)).addConnected(direction.getOpposite());
        } else if (block instanceof AirBlock) {
            ((TankTile) level.getBlockEntity(pos1)).removeConnected(direction);
        }
        return state1;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TankTile(pos, state);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult blockHitResult) {
        if(!level.isClientSide && hand == InteractionHand.MAIN_HAND) {
            TankTile tankTile = (TankTile) level.getBlockEntity(pos);
            Item item = player.getItemInHand(hand).getItem();
            if(item == Items.AIR) {
                ItemStack itemStack = tankTile.removeDecor();
                if(itemStack != null) {
                    level.addFreshEntity(new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, itemStack));
                }
            } else if(Decor.ITEM_TO_DECOR.containsKey(item)) {
                if(tankTile.addDecor(item, player.getDirection().getCounterClockWise())) {
                    player.getItemInHand(hand).shrink(1);
                }
            }
        }
        return super.use(state, level, pos, player, hand, blockHitResult);
    }

    @Override
    public void onRemove(BlockState state1, Level level, BlockPos pos, BlockState state2, boolean bool) {
        if(!state1.is(state2.getBlock())) {
            BlockPos offset = pos.offset(0.5, 0.5, 0.5);
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if(blockEntity instanceof TankTile) {
                ((TankTile) blockEntity).allDecor().forEach(k -> {
                    ItemStack itemStack = new ItemStack(Decor.DECOR_TO_ITEM.get((Decor)(k.getBlock())));
                    level.addFreshEntity(new ItemEntity(level, offset.getX(), offset.getY(), offset.getZ(), itemStack));
                    level.updateNeighbourForOutputSignal(pos, this);
                });
            }
        }
        super.onRemove(state1, level, pos, state2, bool);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return type == BettasAquaticsMain.TANK_TILE.get() ? TankTile::tick : null;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
    }
}
