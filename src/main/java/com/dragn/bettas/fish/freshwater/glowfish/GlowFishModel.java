package com.dragn.bettas.fish.freshwater.glowfish;

import com.dragn.bettas.BettasMain;
import com.dragn.bettas.fish.freshwater.tetra.Gender;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GlowFishModel extends AnimatedGeoModel<GlowFishEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/glowfish.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/tetra.animation.json");

    @Override
    public ResourceLocation getModelLocation(GlowFishEntity glow) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(GlowFishEntity glow) {
        return Variant.patternFromOrdinal(glow.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(GlowFishEntity glow) {
        return animationResource;
    }
}
