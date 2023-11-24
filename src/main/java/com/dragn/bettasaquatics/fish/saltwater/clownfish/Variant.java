package com.dragn.bettasaquatics.fish.saltwater.clownfish;

import com.dragn.bettasaquatics.BettasAquaticsMain;
import net.minecraft.resources.ResourceLocation;


public enum Variant {
    A(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/clownfish_1.png")),
    B(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/clownfish_2.png")),
    C(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/clownfish_3.png")),
    D(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/clownfish_4.png")),
    E(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/clownfish_5.png")),
    F(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/clownfish_6.png")),
    G(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/clownfish_7.png")),
    H(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/clownfish_8.png")),
    I(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/clownfish_9.png")),
    J(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/clownfish_10.png")),
    K(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/clownfish_11.png")),
    L(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/clownfish_12.png")),
    M(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/clownfish_13.png")),
    N(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/clownfish_14.png")),
    O(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/clownfish_15.png")),
    P(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/clownfish_16.png")),
    Q(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/clownfish_17.png")),
    R(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/clownfish_18.png"));

    public final ResourceLocation resourceLocation;

    Variant(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static Variant patternFromOrdinal(int pattern) {
        return Variant.values()[pattern % Variant.values().length];
    }
}
