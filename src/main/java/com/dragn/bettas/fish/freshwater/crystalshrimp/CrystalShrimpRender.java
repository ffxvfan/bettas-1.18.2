package com.dragn.bettas.fish.freshwater.crystalshrimp;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CrystalShrimpRender extends GeoEntityRenderer<CrystalShrimpEntity> {

    public CrystalShrimpRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CrystalShrimpModel());
    }
}
