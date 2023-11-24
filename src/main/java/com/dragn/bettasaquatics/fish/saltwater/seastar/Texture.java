package com.dragn.bettasaquatics.fish.saltwater.seastar;

import com.dragn.bettasaquatics.BettasAquaticsMain;
import net.minecraft.resources.ResourceLocation;

public enum Texture {
    A(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/seastar_1.png")),
    B(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/seastar_2.png")),
    C(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/seastar_3.png")),
    D(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/seastar_4.png")),
    AA(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/seastar_5.png")),
    BB(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/seastar_6.png")),
    CC(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/seastar_7.png")),
    DD(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/seastar_8.png")),
    AAA(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/seastar_9.png")),
    BBB(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/seastar_10.png")),
    CCC(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/seastar_11.png")),
    DDD(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/seastar_12.png")),
    AAAA(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/seastar_13.png")),
    BBBB(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/seastar_14.png")),
    CCCC(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/seastar_15.png")),
    DDDD(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/seastar_16.png")),
    AAAAA(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/seastar_17.png")),
    BBBBB(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/seastar_18.png")),
    CCCCC(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/seastar_19.png"));


    public final ResourceLocation resourceLocation;

    Texture(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static Texture patternFromOrdinal(int pattern) {
        return Texture.values()[pattern % Texture.values().length];
    }
}
