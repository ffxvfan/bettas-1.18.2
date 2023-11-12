package com.dragn.bettas.fish.freshwater.tetra;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;


public enum Gender {
    FEMALE(new ResourceLocation(BettasMain.MODID, "textures/entity/tetra_1.png")),
    MALE(new ResourceLocation(BettasMain.MODID, "textures/entity/tetra_2.png"));

    public final ResourceLocation resourceLocation;

    Gender(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static Gender patternFromOrdinal(int pattern) {
        return Gender.values()[pattern % Gender.values().length];
    }
}
