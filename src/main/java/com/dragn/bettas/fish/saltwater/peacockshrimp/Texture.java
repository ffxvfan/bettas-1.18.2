package com.dragn.bettas.fish.saltwater.peacockshrimp;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;

public enum Texture {
    A(new ResourceLocation(BettasMain.MODID, "textures/entity/peacockshrimp_1.png")),
    B(new ResourceLocation(BettasMain.MODID, "textures/entity/peacockshrimp_2.png")),
    AA(new ResourceLocation(BettasMain.MODID, "textures/entity/peacockshrimp_3.png")),
    BB(new ResourceLocation(BettasMain.MODID, "textures/entity/peacockshrimp_4.png")),
    AAA(new ResourceLocation(BettasMain.MODID, "textures/entity/peacockshrimp_5.png")),
    BBB(new ResourceLocation(BettasMain.MODID, "textures/entity/peacockshrimp_6.png")),
    AAAA(new ResourceLocation(BettasMain.MODID, "textures/entity/peacockshrimp_7.png")),
    BBBB(new ResourceLocation(BettasMain.MODID, "textures/entity/peacockshrimp_8.png")),
    AAAAA(new ResourceLocation(BettasMain.MODID, "textures/entity/peacockshrimp_9.png")),
    BBBBB(new ResourceLocation(BettasMain.MODID, "textures/entity/peacockshrimp_10.png"));

    public final ResourceLocation resourceLocation;

    Texture(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static Texture patternFromOrdinal(int pattern) {
        return Texture.values()[pattern % Texture.values().length];
    }
}
