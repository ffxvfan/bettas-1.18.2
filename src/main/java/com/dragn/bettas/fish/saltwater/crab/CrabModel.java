package com.dragn.bettas.fish.saltwater.crab;

import com.dragn.bettas.BettasMain;
import com.dragn.bettas.fish.freshwater.isopod.IsopodEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CrabModel extends AnimatedGeoModel<CrabEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/crab.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/crab.animation.json");

    @Override
    public ResourceLocation getModelLocation(CrabEntity CrabEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(CrabEntity CrabEntity) {
        return Texture.patternFromOrdinal(CrabEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(CrabEntity CrabEntity) {
        return animationResource;
    }
}
