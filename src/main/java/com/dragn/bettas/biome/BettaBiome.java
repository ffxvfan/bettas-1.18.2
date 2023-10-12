package com.dragn.bettas.biome;

import com.dragn.bettas.BettasMain;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BettaBiome {

    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, BettasMain.MODID);

    public static final RegistryObject<Biome> BETTA_SWAMP = BIOMES.register("betta_swamp", BettaBiome::makeBettaBiome);

    private static Biome makeBettaBiome() {
        MobSpawnSettings.Builder mobSpawnSettings$builder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.farmAnimals(mobSpawnSettings$builder);
        BiomeDefaultFeatures.commonSpawns(mobSpawnSettings$builder);
        mobSpawnSettings$builder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(BettasMain.BETTA_ENTITY.get(), 20, 1, 30));
        mobSpawnSettings$builder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(BettasMain.SNAIL_ENTITY.get(), 10, 1, 20));
        mobSpawnSettings$builder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(BettasMain.KOI_ENTITY.get(), 10, 1, 20));
        mobSpawnSettings$builder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 1, 1, 1));

        BiomeGenerationSettings.Builder biomeGenerationSettings$builder = new BiomeGenerationSettings.Builder();
        BiomeDefaultFeatures.addFossilDecoration(biomeGenerationSettings$builder);
        BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeGenerationSettings$builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(biomeGenerationSettings$builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(biomeGenerationSettings$builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(biomeGenerationSettings$builder);
        BiomeDefaultFeatures.addDefaultSprings(biomeGenerationSettings$builder);
        BiomeDefaultFeatures.addSurfaceFreezing(biomeGenerationSettings$builder);
        BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings$builder);
        BiomeDefaultFeatures.addSwampClayDisk(biomeGenerationSettings$builder);
        BiomeDefaultFeatures.addSwampVegetation(biomeGenerationSettings$builder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeGenerationSettings$builder);
        BiomeDefaultFeatures.addSwampExtraVegetation(biomeGenerationSettings$builder);
        biomeGenerationSettings$builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_SWAMP);

        BiomeSpecialEffects.Builder biomeSpecialEffects$builder = new BiomeSpecialEffects.Builder()
                .waterColor(8709850)
                .waterFogColor(6198935)
                .fogColor(12638463)
                .skyColor(7907327)
                .foliageColorOverride(5755462)
                .grassColorModifier(BiomeSpecialEffects.GrassColorModifier.SWAMP)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS);

        return new Biome.BiomeBuilder()
                .precipitation(Biome.Precipitation.RAIN)
                .biomeCategory(Biome.BiomeCategory.SWAMP)
                .temperature(0.8F)
                .downfall(0.9F)
                .specialEffects(biomeSpecialEffects$builder.build())
                .mobSpawnSettings(mobSpawnSettings$builder.build())
                .generationSettings(biomeGenerationSettings$builder.build())
                .build();
    }
}
