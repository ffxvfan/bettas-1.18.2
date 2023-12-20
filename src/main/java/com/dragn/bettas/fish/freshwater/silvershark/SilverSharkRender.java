package com.dragn.bettas.fish.freshwater.silvershark;


import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SilverSharkRender extends GeoEntityRenderer<SilverSharkEntity> {
    public SilverSharkRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SilverSharkModel());
    }
}
