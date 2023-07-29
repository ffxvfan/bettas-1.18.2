package com.dragn.bettas.event;


import com.dragn.bettas.BettasMain;
import com.dragn.bettas.betta.BettaEntity;
import com.dragn.bettas.betta.BettaRender;
import com.dragn.bettas.snail.SnailEntity;
import com.dragn.bettas.snail.SnailRender;
import com.dragn.bettas.tank.TankTileRenderer;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Mod.EventBusSubscriber(modid = BettasMain.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BettaEvent {

    @SubscribeEvent
    public static void entityAttrbiuteCreationEvent(EntityAttributeCreationEvent event) {
        event.put(BettasMain.BETTA_ENTITY.get(), BettaEntity.createAttributes().build());
        event.put(BettasMain.SNAIL_ENTITY.get(), SnailEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void clientSetupEvent(FMLClientSetupEvent event) {

        /* REGISTER RENDERERS */
        EntityRenderers.register(BettasMain.BETTA_ENTITY.get(), BettaRender::new);
        EntityRenderers.register(BettasMain.SNAIL_ENTITY.get(), SnailRender::new);

        /* REGISTER TANK RENDERER */
        ItemBlockRenderTypes.setRenderLayer(BettasMain.TANK.get(), RenderType.cutout());

        /* REGISTER BETTA SPAWNING */
        SpawnPlacements.register(BettasMain.BETTA_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BettaEntity::checkBettaSpawnRules);
        SpawnPlacements.register(BettasMain.SNAIL_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SnailEntity::checkSnailSpawnRules);
    }

    @SubscribeEvent
    public static void entityRenderersEven(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(BettasMain.TANK_TILE.get(), TankTileRenderer::new);
    }
}
