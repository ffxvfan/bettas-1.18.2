package com.dragn.bettas.fish.saltwater.jelly;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;


public enum Variant {
    A(new ResourceLocation(BettasMain.MODID, "textures/entity/jelly_1.png")),
    AA(new ResourceLocation(BettasMain.MODID, "textures/entity/jelly_2.png")),
    AAA(new ResourceLocation(BettasMain.MODID, "textures/entity/jelly_3.png")),
    AAAA(new ResourceLocation(BettasMain.MODID, "textures/entity/jelly_4.png")),
    AAAAA(new ResourceLocation(BettasMain.MODID, "textures/entity/jelly_5.png"));

    public final ResourceLocation resourceLocation;

    Variant(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static Variant patternFromOrdinal(int pattern) {
        return Variant.values()[pattern % Variant.values().length];
    }
}
