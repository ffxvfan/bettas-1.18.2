package com.dragn.bettas.tank;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraftforge.client.model.data.EmptyModelData;
import org.jetbrains.annotations.NotNull;

public class TankTileRenderer implements BlockEntityRenderer<TankTile> {

    private static final BlockRenderDispatcher renderer = Minecraft.getInstance().getBlockRenderer();

    public TankTileRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(TankTile tankTile, float partialTicks, PoseStack poseStack, @NotNull MultiBufferSource buffer, int lightVal, int overlay) {
        poseStack.pushPose();
        tankTile.allDecor().forEach(state -> renderer.renderSingleBlock(state, poseStack, buffer, lightVal, overlay, EmptyModelData.INSTANCE));
        poseStack.popPose();
    }
}
