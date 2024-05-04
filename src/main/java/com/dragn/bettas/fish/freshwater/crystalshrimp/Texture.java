package com.dragn.bettas.fish.freshwater.crystalshrimp;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;

public enum Texture {
    A(new ResourceLocation(BettasMain.MODID, "textures/entity/crystalshrimp_1.png")),
    B(new ResourceLocation(BettasMain.MODID, "textures/entity/crystalshrimp_2.png")),
    C(new ResourceLocation(BettasMain.MODID, "textures/entity/crystalshrimp_3.png")),
    D(new ResourceLocation(BettasMain.MODID, "textures/entity/crystalshrimp_4.png")),
    E(new ResourceLocation(BettasMain.MODID, "textures/entity/crystalshrimp_5.png")),
    F(new ResourceLocation(BettasMain.MODID, "textures/entity/crystalshrimp_6.png")),
    G(new ResourceLocation(BettasMain.MODID, "textures/entity/crystalshrimp_7.png"));

    public final ResourceLocation resourceLocation;

    Texture(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static Texture patternFromOrdinal(int pattern) {
        return Texture.values()[pattern % Texture.values().length];
    }
}
