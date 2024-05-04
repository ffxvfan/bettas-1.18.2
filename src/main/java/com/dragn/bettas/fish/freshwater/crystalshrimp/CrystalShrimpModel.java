package com.dragn.bettas.fish.freshwater.crystalshrimp;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CrystalShrimpModel extends AnimatedGeoModel<CrystalShrimpEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/crystalshrimp.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/ghostshrimp.animation.json");

    @Override
    public ResourceLocation getModelLocation(CrystalShrimpEntity object) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(CrystalShrimpEntity object) {
        return Texture.patternFromOrdinal(object.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(CrystalShrimpEntity object) {
        return animationResource;
    }
}
