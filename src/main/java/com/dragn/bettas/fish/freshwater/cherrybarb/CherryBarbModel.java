package com.dragn.bettas.fish.freshwater.cherrybarb;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CherryBarbModel extends AnimatedGeoModel<CherryBarbEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/cherrybarb.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/cherrybarb.animation.json");

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
