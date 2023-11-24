package com.dragn.bettasaquatics.fish.freshwater.tetra;

import com.dragn.bettasaquatics.BettasAquaticsMain;
import net.minecraft.resources.ResourceLocation;


public enum Gender {
    FEMALE(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/tetra_1.png")),
    MALE(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/tetra_2.png"));

    public final ResourceLocation resourceLocation;

    Gender(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static Gender patternFromOrdinal(int pattern) {
        return Gender.values()[pattern % Gender.values().length];
    }
}
