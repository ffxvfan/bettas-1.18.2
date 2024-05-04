package com.dragn.bettas.fish.freshwater.pleco;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;


public enum Variant {
    A(new ResourceLocation(BettasMain.MODID, "textures/entity/pleco_1.png")),
    B(new ResourceLocation(BettasMain.MODID, "textures/entity/pleco_2.png")),
    C(new ResourceLocation(BettasMain.MODID, "textures/entity/pleco_3.png")),
    D(new ResourceLocation(BettasMain.MODID, "textures/entity/pleco_4.png")),
    E(new ResourceLocation(BettasMain.MODID, "textures/entity/pleco_5.png")),
    F(new ResourceLocation(BettasMain.MODID, "textures/entity/pleco_6.png"));

    public final ResourceLocation resourceLocation;

    Variant(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static Variant patternFromOrdinal(int pattern) {
        return Variant.values()[pattern % Variant.values().length];
    }
}
