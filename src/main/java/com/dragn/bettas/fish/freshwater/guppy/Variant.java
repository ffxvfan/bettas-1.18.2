package com.dragn.bettas.fish.freshwater.guppy;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;


public enum Variant {
    A(new ResourceLocation(BettasMain.MODID, "textures/entity/guppy_1.png")),
    B(new ResourceLocation(BettasMain.MODID, "textures/entity/guppy_2.png")),
    C(new ResourceLocation(BettasMain.MODID, "textures/entity/guppy_3.png")),
    D(new ResourceLocation(BettasMain.MODID, "textures/entity/guppy_4.png")),
    E(new ResourceLocation(BettasMain.MODID, "textures/entity/guppy_5.png")),
    F(new ResourceLocation(BettasMain.MODID, "textures/entity/guppy_6.png"));

    public final ResourceLocation resourceLocation;

    Variant(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static Variant patternFromOrdinal(int pattern) {
        return Variant.values()[pattern % Variant.values().length];
    }
}
