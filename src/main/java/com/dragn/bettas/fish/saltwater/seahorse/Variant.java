package com.dragn.bettas.fish.saltwater.seahorse;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;


public enum Variant {
    A(new ResourceLocation(BettasMain.MODID, "textures/entity/koi1.png")),
    B(new ResourceLocation(BettasMain.MODID, "textures/entity/koi2.png")),
    C(new ResourceLocation(BettasMain.MODID, "textures/entity/koi3.png")),
    D(new ResourceLocation(BettasMain.MODID, "textures/entity/koi4.png")),
    E(new ResourceLocation(BettasMain.MODID, "textures/entity/koi5.png")),
    F(new ResourceLocation(BettasMain.MODID, "textures/entity/koi6.png")),
    G(new ResourceLocation(BettasMain.MODID, "textures/entity/koi7.png")),
    H(new ResourceLocation(BettasMain.MODID, "textures/entity/koi8.png")),
    I(new ResourceLocation(BettasMain.MODID, "textures/entity/koi9.png")),
    J(new ResourceLocation(BettasMain.MODID, "textures/entity/koi10.png"));

    public final ResourceLocation resourceLocation;

    Variant(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static Variant patternFromOrdinal(int pattern) {
        return Variant.values()[pattern % Variant.values().length];
    }
}
