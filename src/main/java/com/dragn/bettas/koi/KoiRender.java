package com.dragn.bettas.koi;


import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class KoiRender extends GeoEntityRenderer<KoiEntity> {
    public KoiRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new KoiModel());
    }
}
