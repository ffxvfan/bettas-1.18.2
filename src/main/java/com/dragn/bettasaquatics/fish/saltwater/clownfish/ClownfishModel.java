package com.dragn.bettasaquatics.fish.saltwater.clownfish;

import com.dragn.bettasaquatics.BettasAquaticsMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ClownfishModel extends AnimatedGeoModel<ClownfishEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasAquaticsMain.MODID, "geo/clownfish.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasAquaticsMain.MODID, "animations/clownfish.animation.json");

    @Override
    public ResourceLocation getModelLocation(ClownfishEntity ClownfishEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(ClownfishEntity ClownfishEntity) {
        return Variant.patternFromOrdinal(ClownfishEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(ClownfishEntity SeaHorseEntity) {
        return animationResource;
    }
}
