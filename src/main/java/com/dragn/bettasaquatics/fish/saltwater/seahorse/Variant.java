package com.dragn.bettasaquatics.fish.saltwater.seahorse;

import com.dragn.bettasaquatics.BettasAquaticsMain;
import net.minecraft.resources.ResourceLocation;


public enum Variant {
    A(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/seahorse_1.png")),
    B(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/seahorse_2.png")),
    C(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/seahorse_3.png")),
    D(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/seahorse_4.png")),
    E(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/seahorse_5.png")),
    F(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/seahorse_6.png")),
    G(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/seahorse_7.png")),
    H(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/seahorse_8.png")),
    I(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/seahorse_9.png")),
    J(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/seahorse_10.png")),
    K(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/seahorse_11.png")),
    L(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/seahorse_12.png")),
    M(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/seahorse_13.png"));

    public final ResourceLocation resourceLocation;

    Variant(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static Variant patternFromOrdinal(int pattern) {
        return Variant.values()[pattern % Variant.values().length];
    }
}
