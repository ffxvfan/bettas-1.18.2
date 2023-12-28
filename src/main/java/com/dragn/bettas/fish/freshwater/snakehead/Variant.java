package com.dragn.bettas.fish.freshwater.snakehead;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;


public enum Variant {
    A(new ResourceLocation(BettasMain.MODID, "textures/entity/snakehead_1.png")),
    B(new ResourceLocation(BettasMain.MODID, "textures/entity/snakehead_2.png")),
    C(new ResourceLocation(BettasMain.MODID, "textures/entity/snakehead_3.png")),
    D(new ResourceLocation(BettasMain.MODID, "textures/entity/snakehead_4.png"));

    public final ResourceLocation resourceLocation;

    Variant(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static Variant patternFromOrdinal(int pattern) {
        return Variant.values()[pattern % Variant.values().length];
    }
}
