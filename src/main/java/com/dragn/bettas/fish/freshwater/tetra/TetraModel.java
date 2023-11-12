package com.dragn.bettas.fish.freshwater.tetra;

import com.dragn.bettas.BettasMain;
import com.dragn.bettas.fish.freshwater.koi.KoiEntity;
import com.dragn.bettas.fish.freshwater.koi.Variant;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class TetraModel extends AnimatedGeoModel<TetraEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/tetra.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/tetra.animation.json");

    @Override
    public ResourceLocation getModelLocation(TetraEntity koiEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(TetraEntity koiEntity) {
        return Gender.patternFromOrdinal(koiEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(TetraEntity koiEntity) {
        return animationResource;
    }
}
