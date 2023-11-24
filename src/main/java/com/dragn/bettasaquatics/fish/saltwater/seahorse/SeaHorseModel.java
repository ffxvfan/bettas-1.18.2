package com.dragn.bettasaquatics.fish.saltwater.seahorse;

import com.dragn.bettasaquatics.BettasAquaticsMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SeaHorseModel extends AnimatedGeoModel<SeaHorseEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasAquaticsMain.MODID, "geo/seahorse.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasAquaticsMain.MODID, "animations/seahorse.animation.json");

    @Override
    public ResourceLocation getModelLocation(SeaHorseEntity SeaHorseEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(SeaHorseEntity SeaHorseEntity) {
        return Variant.patternFromOrdinal(SeaHorseEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(SeaHorseEntity SeaHorseEntity) {
        return animationResource;
    }
}
