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

public class AlgaeScraper extends Item {
    public AlgaeScraper() {
        super(new Properties().tab(BettasMain.TANK_TAB).durability(64));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockEntity tile = level.getBlockEntity(context.getClickedPos());

        if(tile instanceof TankTile) {
            Player player = context.getPlayer();
            player.getItemInHand(context.getHand()).hurtAndBreak(1, player, e -> e.broadcastBreakEvent(context.getHand()));
            boolean decremented = ((TankTile) tile).decrementAlgae();
            if(decremented) {
                BlockPos pos = tile.getBlockPos();
                for(int i = 0; i < 6; i++) {
                    double x = pos.getX() + (Math.random() * 2 - 1) + 0.5;
                    double y = pos.getY() + (Math.random() * 2 - 1) + 0.5;
                    double z = pos.getZ() + (Math.random() * 2 - 1) + 0.5;

                    double dx = (Math.random() * 2 - 1);
                    double dy = (Math.random() * 2 - 1);
                    double dz = (Math.random() * 2 - 1);
                    level.addParticle(ParticleTypes.HAPPY_VILLAGER, x, y, z, dx, dy, dz);
                }
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
