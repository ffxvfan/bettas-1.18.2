package com.dragn.bettas.fish.saltwater.seaslug;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;

public enum Texture {
    A(new ResourceLocation(BettasMain.MODID, "textures/entity/seaslug_1.png")),
    B(new ResourceLocation(BettasMain.MODID, "textures/entity/seaslug_2.png")),
    C(new ResourceLocation(BettasMain.MODID, "textures/entity/seaslug_3.png")),
    D(new ResourceLocation(BettasMain.MODID, "textures/entity/seaslug_4.png")),
    E(new ResourceLocation(BettasMain.MODID, "textures/entity/seaslug_5.png")),
    F(new ResourceLocation(BettasMain.MODID, "textures/entity/seaslug_6.png")),
    G(new ResourceLocation(BettasMain.MODID, "textures/entity/seaslug_7.png"));

    public final ResourceLocation resourceLocation;

    Texture(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static Texture patternFromOrdinal(int pattern) {
        return Texture.values()[pattern % Texture.values().length];
    }
}
