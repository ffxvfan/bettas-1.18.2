package com.dragn.bettasaquatics.fish.saltwater.filefish;


import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class FilefishRender extends GeoEntityRenderer<FilefishEntity> {
    public FilefishRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FilefishModel());
    }
}
