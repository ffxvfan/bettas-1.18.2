package com.dragn.bettas.fish.saltwater.filefish;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;


public enum Variant {
    A(new ResourceLocation(BettasMain.MODID, "textures/entity/filefish_1.png")),
    B(new ResourceLocation(BettasMain.MODID, "textures/entity/filefish_2.png")),
    C(new ResourceLocation(BettasMain.MODID, "textures/entity/filefish_3.png")),
    D(new ResourceLocation(BettasMain.MODID, "textures/entity/filefish_4.png")),
    E(new ResourceLocation(BettasMain.MODID, "textures/entity/filefish_5.png")),
    F(new ResourceLocation(BettasMain.MODID, "textures/entity/filefish_6.png")),
    G(new ResourceLocation(BettasMain.MODID, "textures/entity/filefish_7.png")),
    H(new ResourceLocation(BettasMain.MODID, "textures/entity/filefish_8.png"));

    public final ResourceLocation resourceLocation;

    Variant(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static Variant patternFromOrdinal(int pattern) {
        return Variant.values()[pattern % Variant.values().length];
    }
}
