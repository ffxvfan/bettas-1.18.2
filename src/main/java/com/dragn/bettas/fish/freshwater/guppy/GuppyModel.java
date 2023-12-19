package com.dragn.bettas.fish.freshwater.guppy;

import com.dragn.bettas.BettasMain;
import com.dragn.bettas.fish.freshwater.cherrybarb.CherryBarbEntity;
import com.dragn.bettas.fish.freshwater.cherrybarb.Gender;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GuppyModel extends AnimatedGeoModel<GuppyEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/guppy.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/cherrybarb.animation.json");

    @Override
    public ResourceLocation getModelLocation(GuppyEntity GuppyEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(GuppyEntity GuppyEntity) {
        return Variant.patternFromOrdinal(GuppyEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(GuppyEntity GuppyEntity) {
        return animationResource;
    }
}
