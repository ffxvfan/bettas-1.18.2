package com.dragn.bettas.fish.saltwater.angelfish;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;


public enum Variant {
    A(new ResourceLocation(BettasMain.MODID, "textures/entity/angelfish_1.png")),
    B(new ResourceLocation(BettasMain.MODID, "textures/entity/angelfish_2.png")),
    C(new ResourceLocation(BettasMain.MODID, "textures/entity/angelfish_3.png")),
    D(new ResourceLocation(BettasMain.MODID, "textures/entity/angelfish_4.png")),
    E(new ResourceLocation(BettasMain.MODID, "textures/entity/angelfish_5.png")),
    F(new ResourceLocation(BettasMain.MODID, "textures/entity/angelfish_6.png")),
    G(new ResourceLocation(BettasMain.MODID, "textures/entity/angelfish_7.png")),
    H(new ResourceLocation(BettasMain.MODID, "textures/entity/angelfish_8.png"));

    public final ResourceLocation resourceLocation;

    Variant(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static Variant patternFromOrdinal(int pattern) {
        return Variant.values()[pattern % Variant.values().length];
    }
}
