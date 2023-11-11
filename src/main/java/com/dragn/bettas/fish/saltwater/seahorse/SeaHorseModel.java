package com.dragn.bettas.fish.saltwater.seahorse;

import com.dragn.bettas.BettasMain;
import com.dragn.bettas.fish.freshwater.koi.KoiEntity;
import com.dragn.bettas.fish.freshwater.koi.Variant;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SeaHorseModel extends AnimatedGeoModel<KoiEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/koi.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/koi.animation.json");

    @Override
    public ResourceLocation getModelLocation(KoiEntity koiEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(KoiEntity koiEntity) {
        return Variant.patternFromOrdinal(koiEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(KoiEntity koiEntity) {
        return animationResource;
    }
}
