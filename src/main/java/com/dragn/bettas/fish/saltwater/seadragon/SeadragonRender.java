package com.dragn.bettas.fish.saltwater.seadragon;


import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SeadragonRender extends GeoEntityRenderer<SeadragonEntity> {
    public SeadragonRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SeadragonModel());
    }
}
