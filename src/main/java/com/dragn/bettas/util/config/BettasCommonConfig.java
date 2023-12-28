package com.dragn.bettas.util.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class BettasCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> ALGAE_GROWTH_RATE;
    public static final ForgeConfigSpec.ConfigValue<Integer> BETTA_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> SNAIL_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> KOI_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> TETRA_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> CHERRYBARB_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> GOLDFISH_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> SEAHORSE_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> CLOWNFISH_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> SEASTAR_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> ANGELFISH_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> FILEFISH_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> SEASLUG_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> GLAUCUS_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> GUPPY_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> SILVERSHARK_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> JELLY_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> GHOSTSHRIMP_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> ISOPOD_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> SNAKEHEAD_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> CRAB_WEIGHT;



    static {
        BUILDER.push("Configs for Bettas & Aquatics!");

        ALGAE_GROWTH_RATE = BUILDER.comment("How long should algae stages take to grow? Default is 3 days.")
                .define("Algae Growth Rate", 3);


        BETTA_WEIGHT = BUILDER.comment("How often should this fish spawn? Default is 3.")
                .define("Betta Spawn Weight", 3);

        SNAIL_WEIGHT = BUILDER.comment("How often should this fish spawn? Default is 1.")
                .define("Snail Spawn Weight", 1);

        KOI_WEIGHT = BUILDER.comment("How often should this fish spawn? Default is 4.")
                .define("Koi Spawn Weight", 4);

        TETRA_WEIGHT = BUILDER.comment("How often should this fish spawn? Default is 4.")
                .define("Tetra Spawn Weight", 4);

        CHERRYBARB_WEIGHT = BUILDER.comment("How often should this fish spawn? Default is 4.")
                .define("Cherry Barb Spawn Weight", 4);

        GOLDFISH_WEIGHT = BUILDER.comment("How often should this fish spawn? Default is 4.")
                .define("Goldfish Spawn Weight", 4);

        GUPPY_WEIGHT = BUILDER.comment("How often should this fish spawn? Default is 4.")
                .define("Guppy Spawn Weight", 4);

        SEAHORSE_WEIGHT = BUILDER.comment("How often should this fish spawn? Default is 8.")
                .define("Seahorse Spawn Weight", 8);

        CLOWNFISH_WEIGHT = BUILDER.comment("How often should this fish spawn? Default is 10.")
                .define("Clownfish Spawn Weight", 10);

        SEASTAR_WEIGHT = BUILDER.comment("How often should this fish spawn? Default is 8.")
                .define("Starfish Spawn Weight", 8);

        ANGELFISH_WEIGHT = BUILDER.comment("How often should this fish spawn? Default is 6.")
                .define("Angelfish Spawn Weight", 6);

        FILEFISH_WEIGHT = BUILDER.comment("How often should this fish spawn? Default is 5.")
                .define("Filefish Spawn Weight", 5);

        SEASLUG_WEIGHT = BUILDER.comment("How often should this fish spawn? Default is 2.")
                .define("Sea Slug Spawn Weight", 2);

        GLAUCUS_WEIGHT = BUILDER.comment("How often should this fish spawn? Default is 2.")
                .define("Blue Glaucus Spawn Weight", 2);

        SILVERSHARK_WEIGHT = BUILDER.comment("How often should this fish spawn? Default is 3.")
                .define("Silver Shark Spawn Weight", 3);

        JELLY_WEIGHT = BUILDER.comment("How often should this fish spawn? Default is 1.")
                .define("Jellyfish Spawn Weight", 1);

        GHOSTSHRIMP_WEIGHT = BUILDER.comment("How often should this fish spawn? Default is 2.")
                .define("Ghost Shrimp Spawn Weight", 2);

        ISOPOD_WEIGHT = BUILDER.comment("How often should this fish spawn? Default is 1.")
                .define("Isopod Spawn Weight", 1);

        SNAKEHEAD_WEIGHT = BUILDER.comment("How often should this fish spawn? Default is 1.")
                .define("Rainbow Snakehead Spawn Weight", 1);

        CRAB_WEIGHT = BUILDER.comment("How often should this fish spawn? Default is 3.")
                .define("Dwarf Crab Spawn Weight", 3);



        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
