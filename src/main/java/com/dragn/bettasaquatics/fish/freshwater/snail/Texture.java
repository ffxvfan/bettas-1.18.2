package com.dragn.bettasaquatics.fish.freshwater.snail;

import com.dragn.bettasaquatics.BettasAquaticsMain;
import net.minecraft.resources.ResourceLocation;

public enum Texture {
    BROWN(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/brownmysterysnail.png")),
    CREAM(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/creammysterysnail.png")),
    GOLD(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/goldmysterysnail.png")),
    PURPLE(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/purplemysterysnail.png"));

    public final ResourceLocation resourceLocation;

    Texture(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static Texture patternFromOrdinal(int pattern) {
        return Texture.values()[pattern % Texture.values().length];
    }
}
