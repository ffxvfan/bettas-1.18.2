package com.dragn.bettasaquatics.fish.saltwater.filefish;

import com.dragn.bettasaquatics.BettasAquaticsMain;
import net.minecraft.resources.ResourceLocation;


public enum Variant {
    A(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/filefish_1.png")),
    B(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/filefish_2.png")),
    C(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/filefish_3.png")),
    D(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/filefish_4.png")),
    E(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/filefish_5.png")),
    F(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/filefish_6.png")),
    G(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/filefish_7.png")),
    H(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/filefish_8.png"));

    public final ResourceLocation resourceLocation;

    Variant(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static Variant patternFromOrdinal(int pattern) {
        return Variant.values()[pattern % Variant.values().length];
    }
}
