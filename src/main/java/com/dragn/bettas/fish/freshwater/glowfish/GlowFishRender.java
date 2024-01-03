package com.dragn.bettas.fish.freshwater.glowfish;


import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.GlowSquid;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GlowFishRender extends GeoEntityRenderer<GlowFishEntity> {
    public GlowFishRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GlowFishModel());
    }
    protected int getBlockLightLevel(GlowFishEntity p_174146_, BlockPos p_174147_) {
        int i = (int)Mth.clampedLerp(0.0F, 15.0F, 1.0F - (float)p_174146_.getDarkTicksRemaining() / 10.0F);
        return i == 15 ? 15 : Math.max(i, super.getBlockLightLevel(p_174146_, p_174147_));
    }
}
