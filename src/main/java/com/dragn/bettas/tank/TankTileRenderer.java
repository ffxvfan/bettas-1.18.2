package com.dragn.bettas.tank;

import com.dragn.bettas.BettasMain;
import com.dragn.bettas.decor.Decor;
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
        tankTile.decor.forEach((name, direction) -> {
            switch (name) {
                case "big_log_item" ->
                        renderer.renderSingleBlock(BettasMain.BIG_LOG.get().defaultBlockState().setValue(Decor.FACING, direction), poseStack, buffer, lightVal, overlay, EmptyModelData.INSTANCE);
                case "filter_item" ->
                        renderer.renderSingleBlock(BettasMain.FILTER.get().defaultBlockState().setValue(Decor.FACING, direction), poseStack, buffer, lightVal, overlay, EmptyModelData.INSTANCE);
                case "heater_item" ->
                        renderer.renderSingleBlock(BettasMain.HEATER.get().defaultBlockState().setValue(Decor.FACING, direction), poseStack, buffer, lightVal, overlay, EmptyModelData.INSTANCE);
                case "kelp" ->
                        renderer.renderSingleBlock(BettasMain.KELP.get().defaultBlockState().setValue(Decor.FACING, direction), poseStack, buffer, lightVal, overlay, EmptyModelData.INSTANCE);
                case "large_rock_item" ->
                        renderer.renderSingleBlock(BettasMain.LARGE_ROCK.get().defaultBlockState().setValue(Decor.FACING, direction), poseStack, buffer, lightVal, overlay, EmptyModelData.INSTANCE);
                case "medium_rock_item" ->
                        renderer.renderSingleBlock(BettasMain.MEDIUM_ROCK.get().defaultBlockState().setValue(Decor.FACING, direction), poseStack, buffer, lightVal, overlay, EmptyModelData.INSTANCE);
                case "seagrass" ->
                        renderer.renderSingleBlock(BettasMain.SEAGRASS.get().defaultBlockState().setValue(Decor.FACING, direction), poseStack, buffer, lightVal, overlay, EmptyModelData.INSTANCE);
                case "small_log_item" ->
                        renderer.renderSingleBlock(BettasMain.SMALL_LOG.get().defaultBlockState().setValue(Decor.FACING, direction), poseStack, buffer, lightVal, overlay, EmptyModelData.INSTANCE);
                case "small_rock_item" ->
                        renderer.renderSingleBlock(BettasMain.SMALL_ROCK.get().defaultBlockState().setValue(Decor.FACING, direction), poseStack, buffer, lightVal, overlay, EmptyModelData.INSTANCE);
                case "sand" ->
                        renderer.renderSingleBlock(BettasMain.SUBSTRATE.get().defaultBlockState().setValue(Decor.FACING, direction), poseStack, buffer, lightVal, overlay, EmptyModelData.INSTANCE);
            }
        });
        poseStack.popPose();
    }
}
