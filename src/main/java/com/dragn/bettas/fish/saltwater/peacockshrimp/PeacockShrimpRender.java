package com.dragn.bettas.fish.saltwater.peacockshrimp;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class PeacockShrimpRender extends GeoEntityRenderer<PeacockShrimpEntity> {

    public PeacockShrimpRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new PeacockShrimpModel());
    }
}
