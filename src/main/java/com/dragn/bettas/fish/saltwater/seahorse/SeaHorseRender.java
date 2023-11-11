package com.dragn.bettas.fish.saltwater.seahorse;


import com.dragn.bettas.fish.freshwater.koi.KoiEntity;
import com.dragn.bettas.fish.freshwater.koi.KoiModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SeaHorseRender extends GeoEntityRenderer<KoiEntity> {
    public SeaHorseRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new KoiModel());
    }
}
