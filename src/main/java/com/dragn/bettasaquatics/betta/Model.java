package com.dragn.bettasaquatics.betta;

import com.dragn.bettasaquatics.BettasAquaticsMain;
import net.minecraft.resources.ResourceLocation;

public enum Model {
    DOUBLETAIL(new ResourceLocation(BettasAquaticsMain.MODID, "geo/doubletail.geo.json")),
    DUMBO(new ResourceLocation(BettasAquaticsMain.MODID, "geo/dumbo.geo.json")),
    HALFMOON(new ResourceLocation(BettasAquaticsMain.MODID, "geo/halfmoon.geo.json")),
    PLAKAT(new ResourceLocation(BettasAquaticsMain.MODID, "geo/plakat.geo.json")),
    VEIL(new ResourceLocation(BettasAquaticsMain.MODID, "geo/veil.geo.json"));

    public final ResourceLocation resourceLocation;

    Model(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static Model modelFromOrdinal(int ordinal) {
        return Model.values()[ordinal % Model.values().length];
    }
}