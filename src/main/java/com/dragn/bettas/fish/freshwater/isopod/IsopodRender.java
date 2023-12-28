package com.dragn.bettas.fish.freshwater.isopod;

import com.dragn.bettas.fish.freshwater.snail.SnailEntity;
import com.dragn.bettas.fish.freshwater.snail.SnailModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class IsopodRender extends GeoEntityRenderer<IsopodEntity> {

    public IsopodRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new IsopodModel());
    }
}
