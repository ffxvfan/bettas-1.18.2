package com.dragn.bettas.fish.freshwater.cherrybarb;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CherryBarbModel extends AnimatedGeoModel<CherryBarbEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/cherrybarb.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/cherrybarb.animation.json");

    public static final ResourceLocation babyAnimationResource = new ResourceLocation(BettasMain.MODID, "animations/betta.animations.json");
    public static final ResourceLocation BABY_MODEL = new ResourceLocation (BettasMain.MODID, "geo/small_fry.geo.json");

    @Override
    public ResourceLocation getModelLocation(CherryBarbEntity object) {
        if(object.isBaby()) {
            return BABY_MODEL;
        }

        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(CherryBarbEntity object) {
        if(object.isBaby()) {
            return Gender.BABY_TEXTURE;
        }

        return Gender.patternFromOrdinal(object.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(CherryBarbEntity object) {
        if(object.isBaby()) {
            return babyAnimationResource;
        }

        return animationResource;
    }
}
