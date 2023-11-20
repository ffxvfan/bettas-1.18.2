package com.dragn.bettas.event;

import com.dragn.bettas.BettasMain;
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
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.FILEFISH_ENTITY.get(), 5, 1, 1));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.ANGELFISH_ENTITY.get(), 6, 3, 5));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.SEAHORSE_ENTITY.get(), 8, 1, 2));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.CLOWNFISH_ENTITY.get(), 10, 1, 4));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.SEASTAR_ENTITY.get(), 8, 1, 2));
            }
            case SWAMP -> {
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.TETRA_ENTITY.get(), 4, 2, 6));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.KOI_ENTITY.get(), 4, 2, 6));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.BETTA_ENTITY.get(), 3, 3, 15));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.SNAIL_ENTITY.get(), 1, 1, 5));
            }
            case RIVER -> {
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.CHERRYBARB_ENTITY.get(), 4, 2, 6));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.KOI_ENTITY.get(), 4, 2, 6));
            }
            case DESERT -> {
            }
            case MUSHROOM -> {
            }
            case NETHER -> {
            }
            case UNDERGROUND -> {
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.SNAIL_ENTITY.get(), 1, 1, 5));
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.BETTA_ENTITY.get(), 3, 3, 15));
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
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.CHERRYBARB_ENTITY.get(), 4, 2, 6));
            }
            case SAVANNA -> {
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.CHERRYBARB_ENTITY.get(), 4, 2, 6));
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
