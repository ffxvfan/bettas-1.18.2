package com.dragn.bettas.tank;

import com.dragn.bettas.BettasMain;
import com.dragn.bettas.network.NetworkManager;
import com.dragn.bettas.network.RemoveDecorRequest;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.PacketDistributor;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class Tank extends Block implements EntityBlock, SimpleWaterloggedBlock {

    private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    private static final BooleanProperty DOWN = BlockStateProperties.DOWN;
    private static final BooleanProperty NORTH_UP = BooleanProperty.create("north_up");
    private static final BooleanProperty EAST_UP = BooleanProperty.create("east_up");
    private static final BooleanProperty SOUTH_UP = BooleanProperty.create("south_up");
    private static final BooleanProperty WEST_UP = BooleanProperty.create("west_up");
    private static final BooleanProperty NORTH_EAST = BooleanProperty.create("north_east");
    private static final BooleanProperty NORTH_WEST = BooleanProperty.create("north_west");
    private static final BooleanProperty SOUTH_EAST = BooleanProperty.create("south_east");
    private static final BooleanProperty SOUTH_WEST = BooleanProperty.create("south_west");

    private static final VoxelShape NORTH_VOXEL = Shapes.or(Block.box(0, 0, 0, 16, 16, 0.5), Block.box(0.5, 15.5, 0, 15.5, 16, 0.5));
    private static final VoxelShape EAST_VOXEL = Shapes.or(Block.box(15.5, 0, 0, 16, 16, 16), Block.box(15.5, 15.5, 0.5, 16, 16, 15.5));
    private static final VoxelShape SOUTH_VOXEL = Shapes.or(Block.box(0, 0, 15.5, 16, 16, 16), Block.box(0.5, 15.5, 15.5, 15.5, 16, 16));
    private static final VoxelShape WEST_VOXEL = Shapes.or(Block.box(0, 0, 0, 0.5, 16, 16), Block.box(0, 15.5, 0.5, 0.5, 16, 15.5));
    private static final VoxelShape DOWN_VOXEL = Block.box(-0.05, -0.05, -0.05, 16.1, 0.5, 16.1);

    private static final ArrayList<String> DECOR_ITEMS = new ArrayList<>(Arrays.asList("big_log_item", "filter_item", "heater_item", "large_rock_item", "medium_rock_item", "small_log_item", "small_rock_item", "kelp", "seagrass", "sand"));



    public Tank() {
        super(Block.Properties.of(Material.GLASS).noOcclusion().strength(0.7F));
        registerDefaultState(getStateDefinition().any()
                .setValue(WATERLOGGED, false)
                .setValue(NORTH_UP, false)
                .setValue(EAST_UP, false)
                .setValue(SOUTH_UP, false)
                .setValue(WEST_UP, false)
                .setValue(NORTH_EAST, false)
                .setValue(NORTH_WEST, false)
                .setValue(SOUTH_EAST, false)
                .setValue(SOUTH_WEST, false)
                .setValue(DOWN, false)
        );
    }

    @Override
    public BlockState updateShape(BlockState state1, Direction direction, BlockState state2, LevelAccessor levelAccessor, BlockPos pos1, BlockPos pos2) {
        boolean adjacent = state2.is(this);
        boolean up = adjacent || (state1.getValue(NORTH_UP) && state1.getValue(EAST_UP) && state1.getValue(SOUTH_UP) && state1.getValue(WEST_UP));
        switch (direction) {
            case UP -> {
                boolean north = adjacent || (state1.getValue(NORTH_EAST) && state1.getValue(NORTH_WEST));
                boolean east = adjacent || (state1.getValue(NORTH_EAST) && state1.getValue(SOUTH_EAST));
                boolean south = adjacent || (state1.getValue(SOUTH_EAST) && state1.getValue(SOUTH_WEST));
                boolean west = adjacent || (state1.getValue(NORTH_WEST) && state1.getValue(SOUTH_WEST));
                return state1.setValue(NORTH_UP, north).setValue(EAST_UP, east).setValue(SOUTH_UP, south).setValue(WEST_UP, west);
            }
            case NORTH -> {
                return state1.setValue(NORTH_UP, up).setValue(NORTH_EAST, adjacent).setValue(NORTH_WEST, adjacent);
            }
            case EAST -> {
                return state1.setValue(EAST_UP, up).setValue(NORTH_EAST, adjacent).setValue(SOUTH_EAST, adjacent);
            }
            case SOUTH -> {
                return state1.setValue(SOUTH_UP, up).setValue(SOUTH_EAST, adjacent).setValue(SOUTH_WEST, adjacent);
            }
            case WEST -> {
                return state1.setValue(WEST_UP, up).setValue(NORTH_WEST, adjacent).setValue(SOUTH_WEST, adjacent);
            }
            case DOWN -> {
                return state1.setValue(DOWN, adjacent);
            }
        }
        return super.updateShape(state1, direction, state2, levelAccessor, pos1, pos2);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
        VoxelShape shape = Shapes.empty();
        if(!(blockGetter.getBlockState(pos.north()).getBlock() == this)) {
            shape = Shapes.join(shape, NORTH_VOXEL, BooleanOp.OR);
        }
        if(!(blockGetter.getBlockState(pos.east()).getBlock() == this)) {
            shape = Shapes.join(shape, EAST_VOXEL, BooleanOp.OR);
        }
        if(!(blockGetter.getBlockState(pos.south()).getBlock() == this)) {
            shape = Shapes.join(shape, SOUTH_VOXEL, BooleanOp.OR);
        }
        if(!(blockGetter.getBlockState(pos.west()).getBlock() == this)) {
            shape = Shapes.join(shape, WEST_VOXEL, BooleanOp.OR);
        }
        if(!(blockGetter.getBlockState(pos.below()).getBlock() == this)) {
            shape = Shapes.join(shape, DOWN_VOXEL, BooleanOp.OR);
        }
        return shape;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        boolean up = context.getLevel().getBlockState(pos.above()).getBlock() == this;
        boolean north = context.getLevel().getBlockState(pos.north()).getBlock() == this;
        boolean east = context.getLevel().getBlockState(pos.east()).getBlock() == this;
        boolean south = context.getLevel().getBlockState(pos.south()).getBlock() == this;
        boolean west = context.getLevel().getBlockState(pos.west()).getBlock() == this;
        boolean down = context.getLevel().getBlockState(pos.below()).getBlock() == this;

        return this.defaultBlockState()
                .setValue(WATERLOGGED, context.getLevel().getFluidState(pos).getType() == Fluids.WATER)
                .setValue(NORTH_UP, up).setValue(EAST_UP, up).setValue(SOUTH_UP, up).setValue(WEST_UP, up)
                .setValue(NORTH_UP, up).setValue(NORTH_EAST, north).setValue(NORTH_WEST, north)
                .setValue(EAST_UP, up).setValue(NORTH_EAST, east).setValue(SOUTH_EAST, east)
                .setValue(SOUTH_UP, up).setValue(SOUTH_EAST, south).setValue(SOUTH_WEST, south)
                .setValue(WEST_UP, up).setValue(NORTH_WEST, west).setValue(SOUTH_WEST, west)
                .setValue(DOWN, down);
    }


    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        return Collections.singletonList(this.asItem().getDefaultInstance());
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, Random random) {
        super.animateTick(state, level, pos, random);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult blockRayTraceResult) {
        if(!world.isClientSide) {
            String name = player.getItemInHand(hand).getItem().getRegistryName().getPath();
            TankTile tankTile = (TankTile) world.getBlockEntity(pos);

            if(DECOR_ITEMS.contains(name)) {
                if(tankTile.decor.put(name, player.getDirection().getCounterClockWise()) == null) {
                    player.getItemInHand(hand).shrink(1);
                }
                world.sendBlockUpdated(pos, state, state, 3);
                return InteractionResult.CONSUME;
            } else if(hand == InteractionHand.MAIN_HAND && name.equals("air") && tankTile.decor.size() > 0) {
                Map.Entry<String, Direction> decor = (Map.Entry<String, Direction>) tankTile.decor.entrySet().toArray()[tankTile.decor.size() - 1];
                tankTile.decor.remove(decor.getKey());
                NetworkManager.INSTANCE.send(PacketDistributor.TRACKING_CHUNK.with(() -> (LevelChunk) world.getChunk(pos)), new RemoveDecorRequest(decor.getKey(), pos));
                world.addFreshEntity(new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, decorMap(decor.getKey())));

                world.sendBlockUpdated(pos, state, state, 3);
                return InteractionResult.SUCCESS;
            }
        }
        return super.use(state, world, pos, player, hand, blockRayTraceResult);
    }

    public static ItemStack decorMap(String decor) {
        return switch (decor) {
            case "big_log_item" -> BettasMain.BIG_LOG_ITEM.get().getDefaultInstance();
            case "filter_item" -> BettasMain.FILTER_ITEM.get().getDefaultInstance();
            case "heater_item" -> BettasMain.HEATER_ITEM.get().getDefaultInstance();
            case "large_rock_item" -> BettasMain.LARGE_ROCK_ITEM.get().getDefaultInstance();
            case "medium_rock_item" -> BettasMain.MEDIUM_ROCK_ITEM.get().getDefaultInstance();
            case "small_log_item" -> BettasMain.SMALL_LOG_ITEM.get().getDefaultInstance();
            case "small_rock_item" -> BettasMain.SMALL_ROCK_ITEM.get().getDefaultInstance();
            case "seagrass" -> Items.SEAGRASS.getDefaultInstance();
            case "kelp" -> Items.KELP.getDefaultInstance();
            case "sand" -> Items.SAND.getDefaultInstance();
            default -> Items.AIR.getDefaultInstance();
        };
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, DOWN, NORTH_UP, EAST_UP, SOUTH_UP, WEST_UP, NORTH_EAST, NORTH_WEST, SOUTH_EAST, SOUTH_WEST);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return BettasMain.TANK_TILE.get().create(pos, state);
    }
}
