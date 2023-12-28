package com.dragn.bettas.fish.saltwater.glaucus;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GlaucusModel extends AnimatedGeoModel<GlaucusEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/glaucus.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/glaucus.animation.json");

    @Override
    public ResourceLocation getModelLocation(GlaucusEntity GlaucusEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(GlaucusEntity GlaucusEntity) {
        return Variant.patternFromOrdinal(GlaucusEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(GlaucusEntity GlaucusEntity) {
        return animationResource;
    }
}
