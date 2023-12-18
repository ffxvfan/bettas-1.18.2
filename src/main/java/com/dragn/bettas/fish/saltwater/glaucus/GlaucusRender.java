package com.dragn.bettas.fish.saltwater.glaucus;


import com.dragn.bettas.fish.saltwater.clownfish.ClownfishEntity;
import com.dragn.bettas.fish.saltwater.clownfish.ClownfishModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GlaucusRender extends GeoEntityRenderer<GlaucusEntity> {
    public GlaucusRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GlaucusModel());
    }
}
