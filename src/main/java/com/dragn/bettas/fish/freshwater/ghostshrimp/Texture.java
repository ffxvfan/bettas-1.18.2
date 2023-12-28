package com.dragn.bettas.fish.freshwater.ghostshrimp;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;

public enum Texture {
    A(new ResourceLocation(BettasMain.MODID, "textures/entity/ghostshrimp_1.png")),
    B(new ResourceLocation(BettasMain.MODID, "textures/entity/ghostshrimp_2.png"));

    public final ResourceLocation resourceLocation;

    Texture(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static Texture patternFromOrdinal(int pattern) {
        return Texture.values()[pattern % Texture.values().length];
    }
}
