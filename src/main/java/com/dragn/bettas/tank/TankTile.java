package com.dragn.bettas.tank;

import com.dragn.bettas.BettasMain;
import com.dragn.bettas.decor.Decor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.client.model.data.IModelData;
import net.minecraftforge.client.model.data.ModelDataMap;
import net.minecraftforge.client.model.data.ModelProperty;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.WATERLOGGED;

public class TankTile extends BlockEntity {

    public static final ModelProperty<Integer> CONNECTED = new ModelProperty<>();
    public static final ModelProperty<Integer> ALGAE = new ModelProperty<>();

    public static final VoxelShape NORTH = Shapes.box(0, 0, 0, 1, 1, 0.03125f);
    public static final VoxelShape EAST = Shapes.box(0.96875f, 0, 0, 1, 1, 1);
    public static final VoxelShape SOUTH = Shapes.box(0, 0, 0.96875f, 1, 1, 1);
    public static final VoxelShape WEST = Shapes.box(0, 0, 0, 0.03125f, 1, 1);
    public static final VoxelShape UP = Shapes.box(0, 0, 0, 0, 0, 0);
    public static final VoxelShape DOWN = Shapes.box(0, 0, 0, 1, 0.03125f, 1);

    // this needs to be the same order as the direction enum
    private static final VoxelShape[] SHAPES = {DOWN, UP, NORTH, SOUTH, WEST, EAST};

    // don't ask
    private static final class OrderedSet {
        private final Map<BlockState, BlockState> map = new HashMap<>();
        private BlockState last;

        public boolean add(BlockState state) {
            if(!map.containsKey(state)) {
                map.putIfAbsent(state, last);
                last = state;
                return true;
            }
            return false;
        }

        public BlockState remove() {
            BlockState ret = last;
            last = map.remove(ret);
            return ret;
        }

        public CompoundTag asNBT() {
            CompoundTag nbt = new CompoundTag();
            map.keySet().forEach(k -> {
                String name = k.toString();
                Direction direction = k.getValue(Decor.FACING);
                nbt.putInt(name, direction.ordinal());
            });
            return nbt;
        }

        public void fromNBT(CompoundTag nbt) {
            map.clear();
            last = null;

            nbt.getAllKeys().forEach(k -> {
                Decor block = Decor.NAME_TO_DECOR.get(k);
                Direction direction = Direction.values()[nbt.getInt(k)];

                BlockState state = block.facing(direction);
                map.put(state, last);
                last = state;
            });
        }

        public Stream<BlockState> asStream() {
            return map.keySet().stream();
        }
    }

    private final OrderedSet decor = new OrderedSet();

    private VoxelShape shape = Shapes.or(NORTH, EAST, SOUTH, WEST, UP, DOWN);

    public int connected = 0;
    public int algae = 0;

    public TankTile(BlockPos pos, BlockState state) {
        super(BettasMain.TANK_TILE.get(), pos, state);
    }

    // 24000 ticks in a minecraft day, algae increments every 3 days
    private final long threshold = 24000 * 3;
    private long age = 0;

    public static <T extends BlockEntity> void tick(Level level, BlockPos pos, BlockState state, T blockEntity) {
        TankTile tankTile = (TankTile)blockEntity;
        if(tankTile.getBlockState().getValue(WATERLOGGED)) {
            tankTile.age++;
            if (tankTile.threshold - tankTile.age == 0) {
                tankTile.incrementAlgae();
                tankTile.age = 0;
            }
        }
    }

    public VoxelShape getShape() {
        for(int i = 0; i < SHAPES.length; i++) {
            if(((this.connected >> i) & 1) == 1) {
                this.shape = Shapes.join(this.shape, SHAPES[i], BooleanOp.ONLY_FIRST);
            }
        }
        return this.shape;
    }

    private void handleModelUpdate() {
        this.setChanged();
        this.level.sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
        requestModelDataUpdate();
    }

    public void incrementAlgae() {
        this.algae = Math.min(4, this.algae + 1);
        handleModelUpdate();
    }


    public boolean decrementAlgae() {
        int prev = this.algae;
        this.algae = Math.max(0, this.algae - 1);
        boolean decremented = prev != this.algae;

        handleModelUpdate();
        return decremented;
    }

    public void addConnected(Direction direction) {
        this.connected |= 1 << direction.get3DDataValue();
        this.shape = Shapes.join(this.shape, SHAPES[direction.get3DDataValue()], BooleanOp.ONLY_FIRST);

        handleModelUpdate();
    }

    public void removeConnected(Direction direction) {
        this.connected &= ~(1 << direction.get3DDataValue());
        this.shape = Shapes.join(this.shape, SHAPES[direction.get3DDataValue()], BooleanOp.OR);

        handleModelUpdate();
    }

    public ItemStack removeDecor() {
        BlockState state = this.decor.remove();
        if(state != null) {
            this.setChanged();
            this.level.sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
            return new ItemStack(Decor.DECOR_TO_ITEM.get(state.getBlock()));
        }
        return null;
    }

    public boolean addDecor(Item item, Direction direction) {
        Decor block = Decor.ITEM_TO_DECOR.get(item);
        boolean added = this.decor.add(block.facing(direction));
        this.setChanged();
        this.level.sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), 3);
        return added;
    }

    public Stream<BlockState> allDecor() {
        return this.decor.asStream();
    }

    public void slowGrowth() {
        this.age = -threshold;
    }


    @Override
    protected void saveAdditional(@NotNull CompoundTag compoundTag) {
        super.saveAdditional(compoundTag);
        compoundTag.putInt("Algae", this.algae);
        compoundTag.putInt("Connected", this.connected);
        compoundTag.putLong("Age", this.age);
        compoundTag.put("Decor", this.decor.asNBT());
    }

    @Override
    public void load(@NotNull CompoundTag compoundTag) {
        super.load(compoundTag);
        this.algae = compoundTag.getInt("Algae");
        this.connected = compoundTag.getInt("Connected");
        this.age = compoundTag.getLong("Age");
        this.decor.fromNBT(compoundTag.getCompound("Decor"));
    }

    @Nullable
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public CompoundTag getUpdateTag() {
        return this.saveWithoutMetadata();
    }

    @NotNull
    @Override
    public IModelData getModelData() {
        return new ModelDataMap.Builder()
                .withInitial(CONNECTED, this.connected)
                .withInitial(ALGAE, this.algae)
                .build();
    }
}
