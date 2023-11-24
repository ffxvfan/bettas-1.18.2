package com.dragn.bettasaquatics.fish.saltwater.angelfish;

import com.dragn.bettasaquatics.BettasAquaticsMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AngelfishModel extends AnimatedGeoModel<AngelfishEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasAquaticsMain.MODID, "geo/angelfish.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasAquaticsMain.MODID, "animations/angelfish.animation.json");

    @Override
    public ResourceLocation getModelLocation(AngelfishEntity ClownfishEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(AngelfishEntity ClownfishEntity) {
        return Variant.patternFromOrdinal(ClownfishEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(AngelfishEntity SeaHorseEntity) {
        return animationResource;
    }
}
