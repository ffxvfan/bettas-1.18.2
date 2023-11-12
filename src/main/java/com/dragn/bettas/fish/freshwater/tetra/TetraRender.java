package com.dragn.bettas.fish.freshwater.tetra;


import com.dragn.bettas.fish.freshwater.koi.KoiEntity;
import com.dragn.bettas.fish.freshwater.koi.KoiModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class TetraRender extends GeoEntityRenderer<TetraEntity> {
    public TetraRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TetraModel());
    }
}
