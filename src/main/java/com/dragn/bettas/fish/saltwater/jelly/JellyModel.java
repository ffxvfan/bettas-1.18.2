package com.dragn.bettas.fish.saltwater.jelly;

import com.dragn.bettas.BettasMain;
import com.dragn.bettas.fish.saltwater.glaucus.GlaucusEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class JellyModel extends AnimatedGeoModel<JellyEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/jelly.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/jelly.animation.json");

    @Override
    public ResourceLocation getModelLocation(JellyEntity JellyEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(JellyEntity JellyEntity) {
        return Variant.patternFromOrdinal(JellyEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(JellyEntity JellyEntity) {
        return animationResource;
    }
}
