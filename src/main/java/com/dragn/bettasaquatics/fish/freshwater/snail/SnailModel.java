package com.dragn.bettasaquatics.fish.freshwater.snail;

import com.dragn.bettasaquatics.BettasAquaticsMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SnailModel extends AnimatedGeoModel<SnailEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasAquaticsMain.MODID, "geo/snailsizefix.geo.json");

    @Override
    public ResourceLocation getModelLocation(SnailEntity snailEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(SnailEntity snailEntity) {
        return Texture.patternFromOrdinal(snailEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(SnailEntity snailEntity) {
        return null;
    }
}
