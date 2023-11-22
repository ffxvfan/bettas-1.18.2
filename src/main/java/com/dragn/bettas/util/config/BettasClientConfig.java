package com.dragn.bettas.util.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class BettasClientConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    static {
        BUILDER.push("Configs for Bettas & Aquatics!");

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
