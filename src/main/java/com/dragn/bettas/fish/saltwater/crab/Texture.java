package com.dragn.bettas.fish.saltwater.crab;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;

public enum Texture {
    A(new ResourceLocation(BettasMain.MODID, "textures/entity/crab_1.png")),
    B(new ResourceLocation(BettasMain.MODID, "textures/entity/crab_2.png")),
    C(new ResourceLocation(BettasMain.MODID, "textures/entity/crab_3.png")),
    D(new ResourceLocation(BettasMain.MODID, "textures/entity/crab_4.png"));

    public final ResourceLocation resourceLocation;

    Texture(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static Texture patternFromOrdinal(int pattern) {
        return Texture.values()[pattern % Texture.values().length];
    }
}
