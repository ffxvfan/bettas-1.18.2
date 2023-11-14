package com.dragn.bettas.fish.freshwater.cherrybarb;


import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CherryBarbRender extends GeoEntityRenderer<CherryBarbEntity> {
    public CherryBarbRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CherryBarbModel());
    }
}
