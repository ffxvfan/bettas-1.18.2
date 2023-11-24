package com.dragn.bettasaquatics.betta;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BettaRender extends GeoEntityRenderer<BettaEntity> {
    public BettaRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BettaModel());
    }
}
