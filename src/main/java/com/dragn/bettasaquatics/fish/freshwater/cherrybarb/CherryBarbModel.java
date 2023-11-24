package com.dragn.bettasaquatics.fish.freshwater.cherrybarb;

import com.dragn.bettasaquatics.BettasAquaticsMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CherryBarbModel extends AnimatedGeoModel<CherryBarbEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasAquaticsMain.MODID, "geo/cherrybarb.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasAquaticsMain.MODID, "animations/cherrybarb.animation.json");

    @Override
    public ResourceLocation getModelLocation(CherryBarbEntity koiEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(CherryBarbEntity koiEntity) {
        return Gender.patternFromOrdinal(koiEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(CherryBarbEntity koiEntity) {
        return animationResource;
    }
}
