package com.dragn.bettas.item;

import com.dragn.bettas.BettasMain;
import com.dragn.bettas.tank.TankTile;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

public class AllRound extends Item {
    public AllRound() {
        super(new Properties().tab(BettasMain.TANK_TAB));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockEntity tile = world.getBlockEntity(context.getClickedPos());

        if(tile instanceof TankTile) {
            Player player = context.getPlayer();
            player.getItemInHand(context.getHand()).shrink(1);

            ((TankTile) tile).slowGrowth();

            BlockPos pos = tile.getBlockPos();
            for(int i = 0; i < 7; i++) {
                double x = pos.getX() + (Math.random() * 2 - 1) + 0.5;
                double y = pos.getY() + (Math.random() * 2 - 1) + 0.5;
                double z = pos.getZ() + (Math.random() * 2 - 1) + 0.5;

                double dx = (Math.random() * 2 - 1);
                double dy = (Math.random() * 2 - 1);
                double dz = (Math.random() * 2 - 1);
                world.addParticle(ParticleTypes.HAPPY_VILLAGER, x, y, z, dx, dy, dz);
            }
        }
        return InteractionResult.sidedSuccess(world.isClientSide);
    }
}
