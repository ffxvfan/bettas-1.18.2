package com.dragn.bettas.fish.freshwater.pleco;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PlecoModel extends AnimatedGeoModel<PlecoEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/pleco.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/silvershark.animation.json");

    @Override
    public ResourceLocation getModelLocation(PlecoEntity SilverSharkEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(PlecoEntity SilverSharkEntity) {
        return Variant.patternFromOrdinal(SilverSharkEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(PlecoEntity SilverSharkEntity) {
        return animationResource;
    }
}
