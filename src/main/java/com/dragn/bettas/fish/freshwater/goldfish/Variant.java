package com.dragn.bettas.fish.freshwater.goldfish;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;


public enum Variant {
    A(new ResourceLocation(BettasMain.MODID, "textures/entity/goldfish_1.png")),
    B(new ResourceLocation(BettasMain.MODID, "textures/entity/goldfish_2.png")),
    C(new ResourceLocation(BettasMain.MODID, "textures/entity/goldfish_3.png")),
    D(new ResourceLocation(BettasMain.MODID, "textures/entity/goldfish_4.png"));

    public final ResourceLocation resourceLocation;

    Variant(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static Variant patternFromOrdinal(int pattern) {
        return Variant.values()[pattern % Variant.values().length];
    }
}
