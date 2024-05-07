package com.dragn.bettas.fish.saltwater.peacockshrimp;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PeacockShrimpModel extends AnimatedGeoModel<PeacockShrimpEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/peacockshrimp.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/ghostshrimp.animation.json");

    @Override
    public ResourceLocation getModelLocation(PeacockShrimpEntity GhostShrimp) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(PeacockShrimpEntity GhostShrimp) {
        return Texture.patternFromOrdinal(GhostShrimp.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(PeacockShrimpEntity GhostShrimp) {
        return animationResource;
    }
}
