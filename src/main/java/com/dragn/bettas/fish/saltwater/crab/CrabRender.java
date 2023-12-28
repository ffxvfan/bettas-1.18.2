package com.dragn.bettas.fish.saltwater.crab;

import com.dragn.bettas.fish.freshwater.isopod.IsopodEntity;
import com.dragn.bettas.fish.freshwater.isopod.IsopodModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CrabRender extends GeoEntityRenderer<CrabEntity> {

    public CrabRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CrabModel());
    }
}
