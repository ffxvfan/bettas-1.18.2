package com.dragn.bettas.event;

import com.dragn.bettas.BettasMain;
import com.dragn.bettas.util.config.BettasCommonConfig;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEvent {

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void registerBiomes(BiomeLoadingEvent event) {
        switch (event.getCategory()) {
            case OCEAN -> {
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.ISOPOD_ENTITY.get(), BettasCommonConfig.ISOPOD_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.CRAB_ENTITY.get(), BettasCommonConfig.CRAB_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.JELLY_ENTITY.get(), BettasCommonConfig.JELLY_WEIGHT.get(), 5, 10));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.GLAUCUS_ENTITY.get(), BettasCommonConfig.GLAUCUS_WEIGHT.get(), 1, 2));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.SEASLUG_ENTITY.get(), BettasCommonConfig.SEASLUG_WEIGHT.get(), 1, 2));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.FILEFISH_ENTITY.get(), BettasCommonConfig.FILEFISH_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.ANGELFISH_ENTITY.get(), BettasCommonConfig.ANGELFISH_WEIGHT.get(), 3, 5));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.SEAHORSE_ENTITY.get(), BettasCommonConfig.SEAHORSE_WEIGHT.get(), 1, 2));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.CLOWNFISH_ENTITY.get(), BettasCommonConfig.CLOWNFISH_WEIGHT.get(), 1, 4));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.SEASTAR_ENTITY.get(), BettasCommonConfig.SEASTAR_WEIGHT.get(), 1, 2));
            }
            case SWAMP -> {
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.GHOSTSHRIMP_ENTITY.get(), BettasCommonConfig.GHOSTSHRIMP_WEIGHT.get(), 1, 3));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.ISOPOD_ENTITY.get(), BettasCommonConfig.ISOPOD_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.SNAKEHEAD_ENTITY.get(), BettasCommonConfig.SNAKEHEAD_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.SILVERSHARK_ENTITY.get(), BettasCommonConfig.SILVERSHARK_WEIGHT.get(), 1, 4));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.GUPPY_ENTITY.get(), BettasCommonConfig.GUPPY_WEIGHT.get(), 2, 4));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.GOLDFISH_ENTITY.get(), BettasCommonConfig.GOLDFISH_WEIGHT.get(), 1, 4));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.TETRA_ENTITY.get(), BettasCommonConfig.TETRA_WEIGHT.get(), 2, 6));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.KOI_ENTITY.get(), BettasCommonConfig.KOI_WEIGHT.get(), 2, 6));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.BETTA_ENTITY.get(), BettasCommonConfig.BETTA_WEIGHT.get(), 3, 15));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.SNAIL_ENTITY.get(), BettasCommonConfig.SNAIL_WEIGHT.get(), 1, 5));
            }
            case RIVER -> {
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.GHOSTSHRIMP_ENTITY.get(), BettasCommonConfig.GHOSTSHRIMP_WEIGHT.get(), 1, 3));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.ISOPOD_ENTITY.get(), BettasCommonConfig.ISOPOD_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.SNAKEHEAD_ENTITY.get(), BettasCommonConfig.SNAKEHEAD_WEIGHT.get(), 1, 1));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.SILVERSHARK_ENTITY.get(), BettasCommonConfig.SILVERSHARK_WEIGHT.get(), 1, 4));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.GUPPY_ENTITY.get(), BettasCommonConfig.GUPPY_WEIGHT.get(), 2, 4));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.GOLDFISH_ENTITY.get(), BettasCommonConfig.GOLDFISH_WEIGHT.get(), 1, 4));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.CHERRYBARB_ENTITY.get(), BettasCommonConfig.CHERRYBARB_WEIGHT.get(), 2, 6));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.KOI_ENTITY.get(), BettasCommonConfig.KOI_WEIGHT.get(), 2, 6));
            }
            case DESERT -> {
            }
            case MUSHROOM -> {
            }
            case NETHER -> {
            }
            case UNDERGROUND -> {
            }
            case MOUNTAIN -> {
            }
            case TAIGA -> {
            }
            case EXTREME_HILLS -> {
            }
            case JUNGLE -> {
            }
            case MESA -> {
            }
            case PLAINS -> {
            }
            case SAVANNA -> {
            }
            case ICY -> {
            }
            case THEEND -> {
            }
            case BEACH -> {
            }
            case FOREST -> {
            }
        }
    }
}
