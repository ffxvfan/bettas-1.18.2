package com.dragn.bettas.fish.saltwater.seaslug;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SeaSlugModel extends AnimatedGeoModel<SeaSlugEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/seaslug.geo.json");

    @Override
    public ResourceLocation getModelLocation(SeaSlugEntity SeaSlugEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(SeaSlugEntity SeaSlugEntity) {
        return Texture.patternFromOrdinal(SeaSlugEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(SeaSlugEntity SeaSlugEntity) {
        return null;
    }
}
