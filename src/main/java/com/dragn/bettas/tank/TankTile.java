package com.dragn.bettas.tank;

import com.dragn.bettas.BettasMain;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.LinkedHashMap;

public class TankTile extends BlockEntity {

    public LinkedHashMap<String, Direction> decor = new LinkedHashMap<>();

    public TankTile(BlockPos pos, BlockState state) {
        super(BettasMain.TANK_TILE.get(), pos, state);
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag compoundTag) {
        super.saveAdditional(compoundTag);
        CompoundTag decorTag = new CompoundTag();
        decor.forEach((name, direction) -> decorTag.putInt(name, direction.ordinal()));
        compoundTag.put("decor", decorTag);
    }

    @Override
    public void load(@NotNull CompoundTag compoundTag) {
        super.load(compoundTag);
        CompoundTag decorTag = compoundTag.getCompound("decor");
        for(String decorName : decorTag.getAllKeys()) {
            decor.put(decorName, Direction.values()[decorTag.getInt(decorName)]);
        }
    }

    @Nullable
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }


    public CompoundTag getUpdateTag() {
        return this.saveWithoutMetadata();
    }
}
