package com.dragn.bettas.fish.saltwater.jelly;


import com.dragn.bettas.fish.saltwater.glaucus.GlaucusEntity;
import com.dragn.bettas.fish.saltwater.glaucus.GlaucusModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class JellyRender extends GeoEntityRenderer<JellyEntity> {
    public JellyRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new JellyModel());
    }
}
