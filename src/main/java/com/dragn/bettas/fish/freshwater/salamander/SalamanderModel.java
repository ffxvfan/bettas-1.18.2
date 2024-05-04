package com.dragn.bettas.fish.freshwater.salamander;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SalamanderModel extends AnimatedGeoModel<SalamanderEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/salamander.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/salamander.animation.json");

    @Override
    public ResourceLocation getModelLocation(SalamanderEntity object) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(SalamanderEntity object) {
        return Variant.patternFromOrdinal(object.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(SalamanderEntity object) {
        return animationResource;
    }
}
