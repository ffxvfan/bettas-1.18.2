package com.dragn.bettas.event;


import com.dragn.bettas.BettasMain;
import com.dragn.bettas.betta.BettaEntity;
import com.dragn.bettas.betta.BettaRender;
import com.dragn.bettas.biome.BettaBiome;
import com.dragn.bettas.decor.Decor;
import com.dragn.bettas.fish.freshwater.cherrybarb.CherryBarbEntity;
import com.dragn.bettas.fish.freshwater.cherrybarb.CherryBarbRender;
import com.dragn.bettas.fish.freshwater.ghostshrimp.GhostShrimpEntity;
import com.dragn.bettas.fish.freshwater.ghostshrimp.GhostShrimpRender;
import com.dragn.bettas.fish.freshwater.glowfish.GlowFishEntity;
import com.dragn.bettas.fish.freshwater.glowfish.GlowFishRender;
import com.dragn.bettas.fish.freshwater.goldfish.GoldfishEntity;
import com.dragn.bettas.fish.freshwater.goldfish.GoldfishRender;
import com.dragn.bettas.fish.freshwater.guppy.GuppyEntity;
import com.dragn.bettas.fish.freshwater.guppy.GuppyRender;
import com.dragn.bettas.fish.freshwater.isopod.IsopodEntity;
import com.dragn.bettas.fish.freshwater.isopod.IsopodRender;
import com.dragn.bettas.fish.freshwater.koi.KoiEntity;
import com.dragn.bettas.fish.freshwater.koi.KoiRender;
import com.dragn.bettas.fish.freshwater.silvershark.SilverSharkEntity;
import com.dragn.bettas.fish.freshwater.silvershark.SilverSharkRender;
import com.dragn.bettas.fish.freshwater.snail.SnailEntity;
import com.dragn.bettas.fish.freshwater.snail.SnailRender;
import com.dragn.bettas.fish.freshwater.snakehead.SnakeheadEntity;
import com.dragn.bettas.fish.freshwater.snakehead.SnakeheadRender;
import com.dragn.bettas.fish.freshwater.tetra.TetraEntity;
import com.dragn.bettas.fish.freshwater.tetra.TetraRender;
import com.dragn.bettas.fish.saltwater.angelfish.AngelfishEntity;
import com.dragn.bettas.fish.saltwater.angelfish.AngelfishRender;
import com.dragn.bettas.fish.saltwater.clownfish.ClownfishEntity;
import com.dragn.bettas.fish.saltwater.clownfish.ClownfishRender;
import com.dragn.bettas.fish.saltwater.crab.CrabEntity;
import com.dragn.bettas.fish.saltwater.crab.CrabRender;
import com.dragn.bettas.fish.saltwater.filefish.FilefishEntity;
import com.dragn.bettas.fish.saltwater.filefish.FilefishRender;
import com.dragn.bettas.fish.saltwater.glaucus.GlaucusEntity;
import com.dragn.bettas.fish.saltwater.glaucus.GlaucusRender;
import com.dragn.bettas.fish.saltwater.jelly.JellyEntity;
import com.dragn.bettas.fish.saltwater.jelly.JellyRender;
import com.dragn.bettas.fish.saltwater.seahorse.SeaHorseEntity;
import com.dragn.bettas.fish.saltwater.seahorse.SeaHorseRender;
import com.dragn.bettas.fish.saltwater.seaslug.SeaSlugEntity;
import com.dragn.bettas.fish.saltwater.seaslug.SeaSlugRender;
import com.dragn.bettas.fish.saltwater.seastar.SeaStarEntity;
import com.dragn.bettas.fish.saltwater.seastar.SeaStarRender;
import com.dragn.bettas.tank.TankLoader;
import com.dragn.bettas.tank.TankTileRenderer;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = BettasMain.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BettaEvent {

    @SubscribeEvent
    public static void entityAttrbiuteCreationEvent(EntityAttributeCreationEvent event) {
        event.put(BettasMain.BETTA_ENTITY.get(), BettaEntity.createAttributes().build());
        event.put(BettasMain.SNAIL_ENTITY.get(), SnailEntity.createAttributes().build());
        event.put(BettasMain.KOI_ENTITY.get(), KoiEntity.createAttributes().build());
        event.put(BettasMain.TETRA_ENTITY.get(), TetraEntity.createAttributes().build());
        event.put(BettasMain.CHERRYBARB_ENTITY.get(), CherryBarbEntity.createAttributes().build());
        event.put(BettasMain.GOLDFISH_ENTITY.get(), GoldfishEntity.createAttributes().build());
        event.put(BettasMain.GUPPY_ENTITY.get(), GuppyEntity.createAttributes().build());
        event.put(BettasMain.SILVERSHARK_ENTITY.get(), SilverSharkEntity.createAttributes().build());
        event.put(BettasMain.GHOSTSHRIMP_ENTITY.get(), GhostShrimpEntity.createAttributes().build());
        event.put(BettasMain.ISOPOD_ENTITY.get(), IsopodEntity.createAttributes().build());
        event.put(BettasMain.SNAKEHEAD_ENTITY.get(), SnakeheadEntity.createAttributes().build());
        event.put(BettasMain.GLOWFISH_ENTITY.get(), GlowFishEntity.createAttributes().build());

        event.put(BettasMain.SEAHORSE_ENTITY.get(), SeaHorseEntity.createAttributes().build());
        event.put(BettasMain.CLOWNFISH_ENTITY.get(), ClownfishEntity.createAttributes().build());
        event.put(BettasMain.SEASTAR_ENTITY.get(), SeaStarEntity.createAttributes().build());
        event.put(BettasMain.ANGELFISH_ENTITY.get(), SeaStarEntity.createAttributes().build());
        event.put(BettasMain.FILEFISH_ENTITY.get(), FilefishEntity.createAttributes().build());
        event.put(BettasMain.SEASLUG_ENTITY.get(), SeaSlugEntity.createAttributes().build());
        event.put(BettasMain.GLAUCUS_ENTITY.get(), GlaucusEntity.createAttributes().build());
        event.put(BettasMain.JELLY_ENTITY.get(), JellyEntity.createAttributes().build());
        event.put(BettasMain.CRAB_ENTITY.get(), CrabEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void clientSetupEvent(FMLClientSetupEvent event) {

        /* REGISTER RENDERERS */
        EntityRenderers.register(BettasMain.BETTA_ENTITY.get(), BettaRender::new);
        EntityRenderers.register(BettasMain.SNAIL_ENTITY.get(), SnailRender::new);
        EntityRenderers.register(BettasMain.KOI_ENTITY.get(), KoiRender::new);
        EntityRenderers.register(BettasMain.TETRA_ENTITY.get(), TetraRender::new);
        EntityRenderers.register(BettasMain.CHERRYBARB_ENTITY.get(), CherryBarbRender::new);
        EntityRenderers.register(BettasMain.GOLDFISH_ENTITY.get(), GoldfishRender::new);
        EntityRenderers.register(BettasMain.GUPPY_ENTITY.get(), GuppyRender::new);
        EntityRenderers.register(BettasMain.SILVERSHARK_ENTITY.get(), SilverSharkRender::new);
        EntityRenderers.register(BettasMain.GHOSTSHRIMP_ENTITY.get(), GhostShrimpRender::new);
        EntityRenderers.register(BettasMain.ISOPOD_ENTITY.get(), IsopodRender::new);
        EntityRenderers.register(BettasMain.SNAKEHEAD_ENTITY.get(), SnakeheadRender::new);
        EntityRenderers.register(BettasMain.GLOWFISH_ENTITY.get(), GlowFishRender::new);


        EntityRenderers.register(BettasMain.SEAHORSE_ENTITY.get(), SeaHorseRender::new);
        EntityRenderers.register(BettasMain.CLOWNFISH_ENTITY.get(), ClownfishRender::new);
        EntityRenderers.register(BettasMain.SEASTAR_ENTITY.get(), SeaStarRender::new);
        EntityRenderers.register(BettasMain.ANGELFISH_ENTITY.get(), AngelfishRender::new);
        EntityRenderers.register(BettasMain.FILEFISH_ENTITY.get(), FilefishRender::new);
        EntityRenderers.register(BettasMain.SEASLUG_ENTITY.get(), SeaSlugRender::new);
        EntityRenderers.register(BettasMain.GLAUCUS_ENTITY.get(), GlaucusRender::new);
        EntityRenderers.register(BettasMain.JELLY_ENTITY.get(), JellyRender::new);
        EntityRenderers.register(BettasMain.CRAB_ENTITY.get(), CrabRender::new);


        /* REGISTER BETTA SPAWNING */
        SpawnPlacements.register(BettasMain.BETTA_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BettaEntity::checkBettaSpawnRules);
        SpawnPlacements.register(BettasMain.SNAIL_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SnailEntity::checkSnailSpawnRules);
        SpawnPlacements.register(BettasMain.KOI_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, KoiEntity::checkGenericFreshwaterSpawnRules);
        SpawnPlacements.register(BettasMain.TETRA_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, TetraEntity::checkTinyFishSpawnRules);
        SpawnPlacements.register(BettasMain.CHERRYBARB_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CherryBarbEntity::checkTinyFishSpawnRules);
        SpawnPlacements.register(BettasMain.GOLDFISH_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, GoldfishEntity::checkBettasTropicalFishSpawnRules);
        SpawnPlacements.register(BettasMain.GUPPY_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, GuppyEntity::checkTinyFishSpawnRules);
        SpawnPlacements.register(BettasMain.SILVERSHARK_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SilverSharkEntity::checkBettasTropicalFishSpawnRules);
        SpawnPlacements.register(BettasMain.GHOSTSHRIMP_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, GhostShrimpEntity::checkFloorDwellerSpawnRules);
        SpawnPlacements.register(BettasMain.ISOPOD_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, IsopodEntity::checkFloorDwellerSpawnRules);
        SpawnPlacements.register(BettasMain.SNAKEHEAD_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SnakeheadEntity::checkBettasTropicalFishSpawnRules);

        SpawnPlacements.register(BettasMain.SEAHORSE_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SeaHorseEntity::checkBettasTropicalFishSpawnRules);
        SpawnPlacements.register(BettasMain.CLOWNFISH_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ClownfishEntity::checkBettasTropicalFishSpawnRules);
        SpawnPlacements.register(BettasMain.SEASTAR_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SeaStarEntity::checkBettasTinyTropicalFishSpawnRules);
        SpawnPlacements.register(BettasMain.ANGELFISH_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AngelfishEntity::checkAngelfishSpawnRules);
        SpawnPlacements.register(BettasMain.FILEFISH_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, FilefishEntity::checkBettasTropicalFishSpawnRules);
        SpawnPlacements.register(BettasMain.SEASLUG_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SeaSlugEntity::checkSnailSpawnRules);
        SpawnPlacements.register(BettasMain.GLAUCUS_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, GlaucusEntity::checkBettasTropicalFishSpawnRules);
        SpawnPlacements.register(BettasMain.JELLY_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, JellyEntity::checkBettasTropicalFishSpawnRules);
        SpawnPlacements.register(BettasMain.CRAB_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CrabEntity::checkFloorDwellerSpawnRules);


        /* SET BLOCK RENDER LAYERS */
        ItemBlockRenderTypes.setRenderLayer(BettasMain.TANK.get(), RenderType.translucent());
    }

    @SubscribeEvent
    public static void entityRenderersEvent(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(BettasMain.TANK_TILE.get(), TankTileRenderer::new);
    }

    @SubscribeEvent
    public static void modelRegistryEvent(ModelRegistryEvent event) {
        ModelLoaderRegistry.registerLoader(TankLoader.LOCATION, TankLoader.INSTANCE);
    }

    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event) {
        IForgeRegistry<Biome> registry = event.getRegistry();
        registry.register(BettaBiome.BETTA_SWAMP);
    }

    @SubscribeEvent
    public static void registerDecor(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();

        BettasMain.BLOCKS.getEntries().forEach(registryObject -> {
            if (registryObject != null) {
                if (registryObject.get() instanceof Decor.Vanilla decor) {
                    decor.init();
                } else if (registryObject.get() instanceof Decor decor) {
                    String name = decor.getRegistryName().getPath();

                    Item item = (new Item(new Item.Properties().tab(BettasMain.TANK_TAB))).setRegistryName(name);
                    registry.register(item);
                    Decor.addMappings(decor, item);
                }
            }
        });
    }
}
