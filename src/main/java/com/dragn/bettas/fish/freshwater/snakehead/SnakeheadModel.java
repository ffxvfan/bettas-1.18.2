package com.dragn.bettas.fish.freshwater.snakehead;

import com.dragn.bettas.BettasMain;
import com.dragn.bettas.fish.freshwater.silvershark.SilverSharkEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SnakeheadModel extends AnimatedGeoModel<SnakeheadEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/snakehead.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/silvershark.animation.json");

    @Override
    public ResourceLocation getModelLocation(SnakeheadEntity SilverSharkEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(SnakeheadEntity SnakeheadEntity) {
        return Variant.patternFromOrdinal(SnakeheadEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(SnakeheadEntity SilverSharkEntity) {
        return animationResource;
    }
}
