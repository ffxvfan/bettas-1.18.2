package com.dragn.bettasaquatics.fish.saltwater.seastar;

import com.dragn.bettasaquatics.BettasAquaticsMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SeaStarModel extends AnimatedGeoModel<SeaStarEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasAquaticsMain.MODID, "geo/seastar.geo.json");

    @Override
    public ResourceLocation getModelLocation(SeaStarEntity SeaStarEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(SeaStarEntity SeaStarEntity) {
        return Texture.patternFromOrdinal(SeaStarEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(SeaStarEntity SeaStarEntity) {
        return null;
    }
}
