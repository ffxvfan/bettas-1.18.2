package com.dragn.bettas.fish.saltwater.filefish;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FilefishModel extends AnimatedGeoModel<FilefishEntity> {

    public static final ResourceLocation MODEL_RESOURCE_LOCATION = new ResourceLocation(BettasMain.MODID, "geo/filefish.geo.json");
    public static final ResourceLocation animationResource = new ResourceLocation(BettasMain.MODID, "animations/filefish.animation.json");

    @Override
    public ResourceLocation getModelLocation(FilefishEntity FilefishEntity) {
        return MODEL_RESOURCE_LOCATION;
    }

    @Override
    public ResourceLocation getTextureLocation(FilefishEntity FilefishEntity) {
        return Variant.patternFromOrdinal(FilefishEntity.getTexture()).resourceLocation;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(FilefishEntity FilefishEntity) {
        return animationResource;
    }
}
