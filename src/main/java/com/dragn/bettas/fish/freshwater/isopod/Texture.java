package com.dragn.bettas.fish.freshwater.isopod;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;

public enum Texture {
    A(new ResourceLocation(BettasMain.MODID, "textures/entity/isopod_1.png")),
    B(new ResourceLocation(BettasMain.MODID, "textures/entity/isopod_2.png")),
    C(new ResourceLocation(BettasMain.MODID, "textures/entity/isopod_3.png")),
    D(new ResourceLocation(BettasMain.MODID, "textures/entity/isopod_4.png"));

    public final ResourceLocation resourceLocation;

    Texture(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static Texture patternFromOrdinal(int pattern) {
        return Texture.values()[pattern % Texture.values().length];
    }
}
