package com.dragn.bettas.fish.freshwater.snail;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SnailRender extends GeoEntityRenderer<SnailEntity> {

    public SnailRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SnailModel());
    }
}
