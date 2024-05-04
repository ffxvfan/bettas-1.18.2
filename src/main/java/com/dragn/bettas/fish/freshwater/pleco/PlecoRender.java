package com.dragn.bettas.fish.freshwater.pleco;


import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class PlecoRender extends GeoEntityRenderer<PlecoEntity> {
    public PlecoRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new PlecoModel());
    }
}
