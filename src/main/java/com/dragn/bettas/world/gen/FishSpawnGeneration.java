package com.dragn.bettas.world.gen;

import com.dragn.bettas.BettasMain;
import com.dragn.bettas.util.config.BettasCommonConfig;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Arrays;
import java.util.List;

public class FishSpawnGeneration {
    public static void onEntitySpawn(final BiomeLoadingEvent event) {

        addEntityToSpecificBiomes(event, BettasMain.CHERRYBARB_ENTITY.get(),
                BettasCommonConfig.CHERRYBARB_WEIGHT.get(), 2, 6, Biomes.PLAINS, Biomes.RIVER);

        addEntityToSpecificBiomes(event, BettasMain.CRYSTALSHRIMP_ENTITY.get(),
                BettasCommonConfig.CRYSTALSHRIMP_WEIGHT.get(), 1, 3, Biomes.SWAMP, Biomes.RIVER);

        addEntityToSpecificBiomes(event, BettasMain.GHOSTSHRIMP_ENTITY.get(),
                BettasCommonConfig.GHOSTSHRIMP_WEIGHT.get(), 1, 3, Biomes.SWAMP, Biomes.RIVER, Biomes.LUSH_CAVES);

        addEntityToSpecificBiomes(event, BettasMain.GOLDFISH_ENTITY.get(),
                BettasCommonConfig.GOLDFISH_WEIGHT.get(), 1, 4, Biomes.SWAMP, Biomes.RIVER, Biomes.PLAINS, Biomes.JUNGLE);

        addEntityToSpecificBiomes(event, BettasMain.GUPPY_ENTITY.get(),
                BettasCommonConfig.GUPPY_WEIGHT.get(), 2, 4, Biomes.SWAMP, Biomes.RIVER);

        addEntityToSpecificBiomes(event, BettasMain.ISOPOD_ENTITY.get(),
                BettasCommonConfig.ISOPOD_WEIGHT.get(), 1, 1, Biomes.RIVER, Biomes.LUSH_CAVES);

        addEntityToSpecificBiomes(event, BettasMain.KOI_ENTITY.get(),
                BettasCommonConfig.KOI_WEIGHT.get(), 3, 8, Biomes.RIVER, Biomes.SWAMP);

        addEntityToSpecificBiomes(event, BettasMain.PLECO_ENTITY.get(),
                BettasCommonConfig.PLECO_WEIGHT.get(), 1, 1, Biomes.RIVER, Biomes.SWAMP);

        addEntityToSpecificBiomes(event, BettasMain.SALAMANDER_ENTITY.get(),
                BettasCommonConfig.SALAMANDER_WEIGHT.get(), 1, 1, Biomes.SWAMP, Biomes.RIVER, Biomes.JUNGLE, Biomes.LUSH_CAVES);

        addEntityToSpecificBiomes(event, BettasMain.SILVERSHARK_ENTITY.get(),
                BettasCommonConfig.SILVERSHARK_WEIGHT.get(), 1, 4, Biomes.SWAMP, Biomes.RIVER);

        addEntityToSpecificBiomes(event, BettasMain.SNAIL_ENTITY.get(),
                BettasCommonConfig.SNAIL_WEIGHT.get(), 1, 4, Biomes.SWAMP, Biomes.RIVER, Biomes.JUNGLE, Biomes.PLAINS, Biomes.LUSH_CAVES);

        addEntityToSpecificBiomes(event, BettasMain.SNAKEHEAD_ENTITY.get(),
                BettasCommonConfig.SNAKEHEAD_WEIGHT.get(), 1, 1, Biomes.RIVER, Biomes.LUSH_CAVES);

        addEntityToSpecificBiomes(event, BettasMain.TETRA_ENTITY.get(),
                BettasCommonConfig.TETRA_WEIGHT.get(), 2, 4, Biomes.SWAMP, Biomes.RIVER, Biomes.PLAINS);


        addEntityToSpecificBiomes(event, BettasMain.ANGELFISH_ENTITY.get(),
                BettasCommonConfig.ANGELFISH_WEIGHT.get(), 2, 4, Biomes.LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.WARM_OCEAN);

        addEntityToSpecificBiomes(event, BettasMain.CLOWNFISH_ENTITY.get(),
                BettasCommonConfig.CLOWNFISH_WEIGHT.get(), 2, 5, Biomes.LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.WARM_OCEAN);

        addEntityToSpecificBiomes(event, BettasMain.CRAB_ENTITY.get(),
                BettasCommonConfig.CRAB_WEIGHT.get(), 1, 2, Biomes.LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.WARM_OCEAN, Biomes.OCEAN, Biomes.DEEP_OCEAN, Biomes.COLD_OCEAN, Biomes.DEEP_COLD_OCEAN);

        addEntityToSpecificBiomes(event, BettasMain.FILEFISH_ENTITY.get(),
                BettasCommonConfig.FILEFISH_WEIGHT.get(), 1, 1, Biomes.LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.WARM_OCEAN);

        addEntityToSpecificBiomes(event, BettasMain.GLAUCUS_ENTITY.get(),
                BettasCommonConfig.GLAUCUS_WEIGHT.get(), 1, 1, Biomes.LUKEWARM_OCEAN, Biomes.WARM_OCEAN, Biomes.BEACH);

        addEntityToSpecificBiomes(event, BettasMain.JELLY_ENTITY.get(),
                BettasCommonConfig.JELLY_WEIGHT.get(), 4, 8, Biomes.LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.WARM_OCEAN, Biomes.OCEAN, Biomes.DEEP_OCEAN, Biomes.COLD_OCEAN, Biomes.DEEP_COLD_OCEAN);

        addEntityToSpecificBiomes(event, BettasMain.PEACOCKSHRIMP_ENTITY.get(),
                BettasCommonConfig.PEACOCKSHRIMP_WEIGHT.get(), 1, 1, Biomes.LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.WARM_OCEAN, Biomes.OCEAN, Biomes.DEEP_OCEAN);

        addEntityToSpecificBiomes(event, BettasMain.SEADRAGON_ENTITY.get(),
                BettasCommonConfig.SEADRAGON_WEIGHT.get(), 1, 2, Biomes.LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.WARM_OCEAN, Biomes.OCEAN, Biomes.DEEP_OCEAN);

        addEntityToSpecificBiomes(event, BettasMain.SEAHORSE_ENTITY.get(),
                BettasCommonConfig.SEAHORSE_WEIGHT.get(), 1, 2, Biomes.LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.WARM_OCEAN);

        addEntityToSpecificBiomes(event, BettasMain.SEASLUG_ENTITY.get(),
                BettasCommonConfig.SEASLUG_WEIGHT.get(), 1, 2, Biomes.LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.WARM_OCEAN, Biomes.OCEAN, Biomes.DEEP_OCEAN);

        addEntityToSpecificBiomes(event, BettasMain.SEASTAR_ENTITY.get(),
                BettasCommonConfig.SEASTAR_WEIGHT.get(), 1, 3, Biomes.LUKEWARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.WARM_OCEAN, Biomes.OCEAN, Biomes.DEEP_OCEAN, Biomes.BEACH);
    }





    private static void addEntityToAllBiomesExceptThese(BiomeLoadingEvent event, EntityType<?> type,
                                                        int weight, int minCount, int maxCount, ResourceKey<Biome>... biomes) {
        boolean isBiomeSelected = Arrays.stream(biomes).map(ResourceKey::location)
                .map(Object::toString).anyMatch(s -> s.equals(event.getName().toString()));

        if(!isBiomeSelected) {
            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
        }
    }
    @SafeVarargs
    private static void addEntityToSpecificBiomes(BiomeLoadingEvent event, EntityType<?> type,
                                                  int weight, int minCount, int maxCount, ResourceKey<Biome>... biomes) {
        boolean isBiomeSelected = Arrays.stream(biomes).map(ResourceKey::location)
                .map(Object::toString).anyMatch(s -> s.equals(event.getName().toString()));

        if(isBiomeSelected) {
            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
        }
    }
    private static void addEntityToAllOverworldBiomes(BiomeLoadingEvent event, EntityType<?> type,
                                                      int weight, int minCount, int maxCount) {
        if(!event.getCategory().equals(Biome.BiomeCategory.THEEND) && !event.getCategory().equals(Biome.BiomeCategory.NETHER)) {
            addEntityToAllBiomes(event, type, weight, minCount, maxCount);
        }
    }
    private static void addEntityToAllBiomesNoNether(BiomeLoadingEvent event, EntityType<?> type,
                                                     int weight, int minCount, int maxCount) {
        if(!event.getCategory().equals(Biome.BiomeCategory.NETHER)) {
            List<MobSpawnSettings.SpawnerData> base = event.getSpawns().getSpawner(type.getCategory());
            base.add(new MobSpawnSettings.SpawnerData(type,weight, minCount, maxCount));
        }
    }
    private static void addEntityToAllBiomesNoEnd(BiomeLoadingEvent event, EntityType<?> type,
                                                  int weight, int minCount, int maxCount) {
        if(!event.getCategory().equals(Biome.BiomeCategory.THEEND)) {
            List<MobSpawnSettings.SpawnerData> base = event.getSpawns().getSpawner(type.getCategory());
            base.add(new MobSpawnSettings.SpawnerData(type,weight, minCount, maxCount));
        }
    }
    private static void addEntityToAllBiomes(BiomeLoadingEvent event, EntityType<?> type,
                                             int weight, int minCount, int maxCount) {
        List<MobSpawnSettings.SpawnerData> base = event.getSpawns().getSpawner(type.getCategory());
        base.add(new MobSpawnSettings.SpawnerData(type,weight, minCount, maxCount));
    }
}
