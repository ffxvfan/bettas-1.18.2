package com.dragn.bettas.event;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.animal.Pufferfish;
import net.minecraft.world.entity.animal.TropicalFish;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.checkerframework.checker.units.qual.Temperature;

import static net.minecraft.world.level.biome.Biome.BiomeCategory.SWAMP;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEvent {

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void registerBiomes(BiomeLoadingEvent event) {
        switch (event.getCategory()) {
            case OCEAN -> {
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
                event.getSpawns().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(BettasMain.KOI_ENTITY.get(), 4, 2, 6));
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
