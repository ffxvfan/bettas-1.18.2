package com.dragn.bettas.fish.saltwater.seastar;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;

public enum Texture {
    A(new ResourceLocation(BettasMain.MODID, "textures/entity/seastar_1.png")),
    B(new ResourceLocation(BettasMain.MODID, "textures/entity/seastar_2.png")),
    C(new ResourceLocation(BettasMain.MODID, "textures/entity/seastar_3.png")),
    D(new ResourceLocation(BettasMain.MODID, "textures/entity/seastar_4.png")),
    AA(new ResourceLocation(BettasMain.MODID, "textures/entity/seastar_5.png")),
    BB(new ResourceLocation(BettasMain.MODID, "textures/entity/seastar_6.png")),
    CC(new ResourceLocation(BettasMain.MODID, "textures/entity/seastar_7.png")),
    DD(new ResourceLocation(BettasMain.MODID, "textures/entity/seastar_8.png")),
    AAA(new ResourceLocation(BettasMain.MODID, "textures/entity/seastar_9.png")),
    BBB(new ResourceLocation(BettasMain.MODID, "textures/entity/seastar_10.png")),
    CCC(new ResourceLocation(BettasMain.MODID, "textures/entity/seastar_11.png")),
    DDD(new ResourceLocation(BettasMain.MODID, "textures/entity/seastar_12.png")),
    AAAA(new ResourceLocation(BettasMain.MODID, "textures/entity/seastar_13.png")),
    BBBB(new ResourceLocation(BettasMain.MODID, "textures/entity/seastar_14.png")),
    CCCC(new ResourceLocation(BettasMain.MODID, "textures/entity/seastar_15.png")),
    DDDD(new ResourceLocation(BettasMain.MODID, "textures/entity/seastar_16.png")),
    AAAAA(new ResourceLocation(BettasMain.MODID, "textures/entity/seastar_17.png")),
    BBBBB(new ResourceLocation(BettasMain.MODID, "textures/entity/seastar_18.png")),
    CCCCC(new ResourceLocation(BettasMain.MODID, "textures/entity/seastar_19.png"));


    public final ResourceLocation resourceLocation;

    Texture(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static Texture patternFromOrdinal(int pattern) {
        return Texture.values()[pattern % Texture.values().length];
    }
}
