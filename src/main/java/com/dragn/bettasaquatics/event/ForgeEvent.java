package com.dragn.bettasaquatics.event;

import com.dragn.bettasaquatics.BettasAquaticsMain;
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
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasAquaticsMain.FILEFISH_ENTITY.get(), 5, 1, 1));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasAquaticsMain.ANGELFISH_ENTITY.get(), 6, 3, 5));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasAquaticsMain.SEAHORSE_ENTITY.get(), 8, 1, 2));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasAquaticsMain.CLOWNFISH_ENTITY.get(), 10, 1, 4));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasAquaticsMain.SEASTAR_ENTITY.get(), 8, 1, 2));
            }
            case SWAMP -> {
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasAquaticsMain.TETRA_ENTITY.get(), 4, 2, 6));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasAquaticsMain.KOI_ENTITY.get(), 4, 2, 6));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasAquaticsMain.BETTA_ENTITY.get(), 3, 3, 15));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasAquaticsMain.SNAIL_ENTITY.get(), 1, 1, 5));
            }
            case RIVER -> {
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasAquaticsMain.CHERRYBARB_ENTITY.get(), 4, 2, 6));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasAquaticsMain.KOI_ENTITY.get(), 4, 2, 6));
            }
            case DESERT -> {
            }
            case MUSHROOM -> {
            }
            case NETHER -> {
            }
            case UNDERGROUND -> {
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasAquaticsMain.SNAIL_ENTITY.get(), 1, 1, 5));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasAquaticsMain.BETTA_ENTITY.get(), 3, 3, 15));
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
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasAquaticsMain.CHERRYBARB_ENTITY.get(), 4, 2, 6));
            }
            case SAVANNA -> {
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasAquaticsMain.CHERRYBARB_ENTITY.get(), 4, 2, 6));
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
