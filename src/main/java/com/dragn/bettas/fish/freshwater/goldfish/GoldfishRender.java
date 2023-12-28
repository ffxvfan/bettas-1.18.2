package com.dragn.bettas.fish.freshwater.goldfish;


import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GoldfishRender extends GeoEntityRenderer<GoldfishEntity> {
    public GoldfishRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GoldfishModel());
    }
}
