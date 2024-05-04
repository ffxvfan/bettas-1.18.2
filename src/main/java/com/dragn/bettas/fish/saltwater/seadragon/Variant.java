package com.dragn.bettas.fish.saltwater.seadragon;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;


public enum Variant {
    A(new ResourceLocation(BettasMain.MODID, "textures/entity/seadragon_1.png")),
    B(new ResourceLocation(BettasMain.MODID, "textures/entity/seadragon_2.png")),
    C(new ResourceLocation(BettasMain.MODID, "textures/entity/seadragon_3.png")),
    D(new ResourceLocation(BettasMain.MODID, "textures/entity/seadragon_4.png")),
    E(new ResourceLocation(BettasMain.MODID, "textures/entity/seadragon_5.png")),
    F(new ResourceLocation(BettasMain.MODID, "textures/entity/seadragon_6.png")),
    G(new ResourceLocation(BettasMain.MODID, "textures/entity/seadragon_7.png")),
    H(new ResourceLocation(BettasMain.MODID, "textures/entity/seadragon_8.png")),
    I(new ResourceLocation(BettasMain.MODID, "textures/entity/seadragon_9.png")),
    J(new ResourceLocation(BettasMain.MODID, "textures/entity/seadragon_10.png"));

    public final ResourceLocation resourceLocation;

    Variant(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static Variant patternFromOrdinal(int pattern) {
        return Variant.values()[pattern % Variant.values().length];
    }
}
