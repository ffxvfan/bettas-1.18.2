package com.dragn.bettas.fish.freshwater.ghostshrimp;

import com.dragn.bettas.fish.freshwater.isopod.IsopodEntity;
import com.dragn.bettas.fish.freshwater.isopod.IsopodModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GhostShrimpRender extends GeoEntityRenderer<GhostShrimpEntity> {

    public GhostShrimpRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GhostShrimpModel());
    }
}
