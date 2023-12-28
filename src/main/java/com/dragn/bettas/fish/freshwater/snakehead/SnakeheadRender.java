package com.dragn.bettas.fish.freshwater.snakehead;


import com.dragn.bettas.fish.freshwater.silvershark.SilverSharkEntity;
import com.dragn.bettas.fish.freshwater.silvershark.SilverSharkModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SnakeheadRender extends GeoEntityRenderer<SnakeheadEntity> {
    public SnakeheadRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SnakeheadModel());
    }
}
