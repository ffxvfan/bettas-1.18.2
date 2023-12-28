package com.dragn.bettas.fish.freshwater.goldfish;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GoldfishModel extends AnimatedGeoModel<GoldfishEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/goldfish.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/clownfish.animation.json");

    @Override
    public ResourceLocation getModelLocation(GoldfishEntity GoldfishEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(GoldfishEntity GoldfishEntity) {
        return Variant.patternFromOrdinal(GoldfishEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(GoldfishEntity GoldfishEntity) {
        return animationResource;
    }
}
