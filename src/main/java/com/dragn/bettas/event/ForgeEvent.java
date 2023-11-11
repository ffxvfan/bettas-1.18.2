package com.dragn.bettas.event;

import com.dragn.bettas.BettasMain;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.animal.Pufferfish;
import net.minecraft.world.entity.animal.TropicalFish;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.minecraft.world.level.biome.Biome.BiomeCategory.SWAMP;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEvent {

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void registerBiomes(BiomeLoadingEvent event) {
        switch (event.getCategory()) {

            case OCEAN -> {
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.SEAHORSE_ENTITY.get(), 10, 1, 2));
            }

            case SWAMP -> {
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.KOI_ENTITY.get(), 4, 2, 6));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.BETTA_ENTITY.get(), 3, 3, 15));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.SNAIL_ENTITY.get(), 1, 1, 5));
            }

            case RIVER -> {
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.KOI_ENTITY.get(), 4, 2, 6));

            }
        }
    }
}
