package com.dragn.bettas.fish.freshwater.glowfish;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;


public enum Variant {
    A(new ResourceLocation(BettasMain.MODID, "textures/entity/glowfish_1.png")),
    B(new ResourceLocation(BettasMain.MODID, "textures/entity/glowfish_2.png")),
    C(new ResourceLocation(BettasMain.MODID, "textures/entity/glowfish_3.png")),
    D(new ResourceLocation(BettasMain.MODID, "textures/entity/glowfish_4.png")),
    E(new ResourceLocation(BettasMain.MODID, "textures/entity/glowfish_5.png")),
    F(new ResourceLocation(BettasMain.MODID, "textures/entity/glowfish_6.png")),
    G(new ResourceLocation(BettasMain.MODID, "textures/entity/glowfish_7.png")),
    H(new ResourceLocation(BettasMain.MODID, "textures/entity/glowfish_8.png")),
    I(new ResourceLocation(BettasMain.MODID, "textures/entity/glowfish_9.png")),
    J(new ResourceLocation(BettasMain.MODID, "textures/entity/glowfish_10.png")),
    K(new ResourceLocation(BettasMain.MODID, "textures/entity/glowfish_11.png")),
    L(new ResourceLocation(BettasMain.MODID, "textures/entity/glowfish_12.png")),
    M(new ResourceLocation(BettasMain.MODID, "textures/entity/glowfish_13.png")),
    N(new ResourceLocation(BettasMain.MODID, "textures/entity/glowfish_14.png")),
    O(new ResourceLocation(BettasMain.MODID, "textures/entity/glowfish_15.png")),
    P(new ResourceLocation(BettasMain.MODID, "textures/entity/glowfish_16.png")),
    Q(new ResourceLocation(BettasMain.MODID, "textures/entity/glowfish_17.png"));

    public final ResourceLocation resourceLocation;

    Variant(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static Variant patternFromOrdinal(int pattern) {
        return Variant.values()[pattern % Variant.values().length];
    }
}
