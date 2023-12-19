package com.dragn.bettas.fish.freshwater.guppy;


import com.dragn.bettas.fish.freshwater.cherrybarb.CherryBarbEntity;
import com.dragn.bettas.fish.freshwater.cherrybarb.CherryBarbModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GuppyRender extends GeoEntityRenderer<GuppyEntity> {
    public GuppyRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GuppyModel());
    }
}
