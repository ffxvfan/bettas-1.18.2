package com.dragn.bettasaquatics.betta;

import com.dragn.bettasaquatics.BettasAquaticsMain;
import net.minecraft.resources.ResourceLocation;

public enum BasePattern {
    CLASSIC(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/classic.png")),
    FADE(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/fade.png")),
    GALAXY_KOI(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/galaxykoi.png")),
    KOI(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi.png")),
    SAMURAI(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/samurai.png")),
    WHITE_PASTEL(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/whitepastel.png"));

    public final ResourceLocation resourceLocation;

    BasePattern(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static BasePattern patternFromOrdinal(int pattern) {
        return BasePattern.values()[pattern % BasePattern.values().length];
    }
}