package com.dragn.bettas.fish.freshwater.cherrybarb;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;


public enum Gender {
    FEMALE(new ResourceLocation(BettasMain.MODID, "textures/entity/cherrybarb_1.png")),
    MALE(new ResourceLocation(BettasMain.MODID, "textures/entity/cherrybarb_2.png"));

    public final ResourceLocation resourceLocation;

    public static final ResourceLocation BABY_TEXTURE = new ResourceLocation(BettasMain.MODID, "textures/entities/fry.png");


    Gender(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static Gender patternFromOrdinal(int pattern) {
        return Gender.values()[pattern % Gender.values().length];
    }
}
