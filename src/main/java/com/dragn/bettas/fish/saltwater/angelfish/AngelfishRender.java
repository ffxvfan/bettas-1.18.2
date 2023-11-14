package com.dragn.bettas.fish.saltwater.angelfish;


import com.dragn.bettas.fish.saltwater.clownfish.ClownfishEntity;
import com.dragn.bettas.fish.saltwater.clownfish.ClownfishModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class AngelfishRender extends GeoEntityRenderer<AngelfishEntity> {
    public AngelfishRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AngelfishModel());
    }
}
