package com.dragn.bettas.fish.freshwater.salamander;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;


public enum Variant {
    A(new ResourceLocation(BettasMain.MODID, "textures/entity/salamander_1.png")),
    B(new ResourceLocation(BettasMain.MODID, "textures/entity/salamander_2.png")),
    C(new ResourceLocation(BettasMain.MODID, "textures/entity/salamander_3.png")),
    D(new ResourceLocation(BettasMain.MODID, "textures/entity/salamander_4.png")),
    E(new ResourceLocation(BettasMain.MODID, "textures/entity/salamander_5.png")),
    F(new ResourceLocation(BettasMain.MODID, "textures/entity/salamander_6.png")),
    G(new ResourceLocation(BettasMain.MODID, "textures/entity/salamander_7.png")),
    H(new ResourceLocation(BettasMain.MODID, "textures/entity/salamander_8.png")),
    I(new ResourceLocation(BettasMain.MODID, "textures/entity/salamander_9.png")),
    J(new ResourceLocation(BettasMain.MODID, "textures/entity/salamander_10.png")),
    K(new ResourceLocation(BettasMain.MODID, "textures/entity/salamander_11.png")),
    L(new ResourceLocation(BettasMain.MODID, "textures/entity/salamander_12.png"));

    public final ResourceLocation resourceLocation;

    Variant(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static Variant patternFromOrdinal(int pattern) {
        return Variant.values()[pattern % Variant.values().length];
    }
}
