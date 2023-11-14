package com.dragn.bettas.fish.saltwater.angelfish;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class AngelfishModel extends AnimatedGeoModel<AngelfishEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/angelfish.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/angelfish.animation.json");

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
