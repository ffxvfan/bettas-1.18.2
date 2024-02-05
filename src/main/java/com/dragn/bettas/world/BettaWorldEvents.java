package com.dragn.bettas.world;

import com.dragn.bettas.BettasMain;
import com.dragn.bettas.world.gen.FishSpawnGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber (modid = BettasMain.MODID)
public class BettaWorldEvents {



    @SubscribeEvent
            public static void biomeLoadingEvent(final BiomeLoadingEvent event) {

    FishSpawnGeneration.onEntitySpawn(event);
    }
}
