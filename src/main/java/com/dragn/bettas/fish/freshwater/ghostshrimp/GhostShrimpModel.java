package com.dragn.bettas.fish.freshwater.ghostshrimp;

import com.dragn.bettas.BettasMain;
import com.dragn.bettas.fish.freshwater.isopod.IsopodEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GhostShrimpModel extends AnimatedGeoModel<GhostShrimpEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/ghostshrimp.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/ghostshrimp.animation.json");

    @Override
    public ResourceLocation getModelLocation(GhostShrimpEntity GhostShrimp) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(GhostShrimpEntity GhostShrimp) {
        return Texture.patternFromOrdinal(GhostShrimp.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(GhostShrimpEntity GhostShrimp) {
        return animationResource;
    }
}
