package com.dragn.bettas.fish.freshwater.isopod;

import com.dragn.bettas.BettasMain;
import com.dragn.bettas.fish.freshwater.snail.SnailEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class IsopodModel extends AnimatedGeoModel<IsopodEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/isopod.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/isopod.animation.json");

    @Override
    public ResourceLocation getModelLocation(IsopodEntity IsopodEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(IsopodEntity IsopodEntity) {
        return Texture.patternFromOrdinal(IsopodEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(IsopodEntity IsopodEntity) {
        return animationResource;
    }
}
