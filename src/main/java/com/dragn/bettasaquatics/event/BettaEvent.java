package com.dragn.bettasaquatics.event;


import com.dragn.bettasaquatics.BettasAquaticsMain;
import com.dragn.bettasaquatics.betta.BettaEntity;
import com.dragn.bettasaquatics.betta.BettaRender;
import com.dragn.bettasaquatics.biome.BettaBiome;
import com.dragn.bettasaquatics.decor.Decor;
import com.dragn.bettasaquatics.fish.freshwater.cherrybarb.CherryBarbEntity;
import com.dragn.bettasaquatics.fish.freshwater.cherrybarb.CherryBarbRender;
import com.dragn.bettasaquatics.fish.freshwater.koi.KoiEntity;
import com.dragn.bettasaquatics.fish.freshwater.koi.KoiRender;
import com.dragn.bettasaquatics.fish.freshwater.snail.SnailEntity;
import com.dragn.bettasaquatics.fish.freshwater.snail.SnailRender;
import com.dragn.bettasaquatics.fish.freshwater.tetra.TetraEntity;
import com.dragn.bettasaquatics.fish.freshwater.tetra.TetraRender;
import com.dragn.bettasaquatics.fish.saltwater.angelfish.AngelfishEntity;
import com.dragn.bettasaquatics.fish.saltwater.angelfish.AngelfishRender;
import com.dragn.bettasaquatics.fish.saltwater.clownfish.ClownfishEntity;
import com.dragn.bettasaquatics.fish.saltwater.clownfish.ClownfishRender;
import com.dragn.bettasaquatics.fish.saltwater.filefish.FilefishEntity;
import com.dragn.bettasaquatics.fish.saltwater.filefish.FilefishRender;
import com.dragn.bettasaquatics.fish.saltwater.seahorse.SeaHorseEntity;
import com.dragn.bettasaquatics.fish.saltwater.seahorse.SeaHorseRender;
import com.dragn.bettasaquatics.fish.saltwater.seastar.SeaStarEntity;
import com.dragn.bettasaquatics.fish.saltwater.seastar.SeaStarRender;
import com.dragn.bettasaquatics.tank.TankLoader;
import com.dragn.bettasaquatics.tank.TankTileRenderer;
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

@Mod.EventBusSubscriber(modid = BettasAquaticsMain.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BettaEvent {

    @SubscribeEvent
    public static void entityAttrbiuteCreationEvent(EntityAttributeCreationEvent event) {
        event.put(BettasAquaticsMain.BETTA_ENTITY.get(), BettaEntity.createAttributes().build());
        event.put(BettasAquaticsMain.SNAIL_ENTITY.get(), SnailEntity.createAttributes().build());
        event.put(BettasAquaticsMain.KOI_ENTITY.get(), KoiEntity.createAttributes().build());
        event.put(BettasAquaticsMain.TETRA_ENTITY.get(), TetraEntity.createAttributes().build());
        event.put(BettasAquaticsMain.CHERRYBARB_ENTITY.get(), CherryBarbEntity.createAttributes().build());

        event.put(BettasAquaticsMain.SEAHORSE_ENTITY.get(), SeaHorseEntity.createAttributes().build());
        event.put(BettasAquaticsMain.CLOWNFISH_ENTITY.get(), ClownfishEntity.createAttributes().build());
        event.put(BettasAquaticsMain.SEASTAR_ENTITY.get(), SeaStarEntity.createAttributes().build());
        event.put(BettasAquaticsMain.ANGELFISH_ENTITY.get(), SeaStarEntity.createAttributes().build());
        event.put(BettasAquaticsMain.FILEFISH_ENTITY.get(), FilefishEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void clientSetupEvent(FMLClientSetupEvent event) {

        /* REGISTER RENDERERS */
        EntityRenderers.register(BettasAquaticsMain.BETTA_ENTITY.get(), BettaRender::new);
        EntityRenderers.register(BettasAquaticsMain.SNAIL_ENTITY.get(), SnailRender::new);
        EntityRenderers.register(BettasAquaticsMain.KOI_ENTITY.get(), KoiRender::new);
        EntityRenderers.register(BettasAquaticsMain.TETRA_ENTITY.get(), TetraRender::new);
        EntityRenderers.register(BettasAquaticsMain.CHERRYBARB_ENTITY.get(), CherryBarbRender::new);

        EntityRenderers.register(BettasAquaticsMain.SEAHORSE_ENTITY.get(), SeaHorseRender::new);
        EntityRenderers.register(BettasAquaticsMain.CLOWNFISH_ENTITY.get(), ClownfishRender::new);
        EntityRenderers.register(BettasAquaticsMain.SEASTAR_ENTITY.get(), SeaStarRender::new);
        EntityRenderers.register(BettasAquaticsMain.ANGELFISH_ENTITY.get(), AngelfishRender::new);
        EntityRenderers.register(BettasAquaticsMain.FILEFISH_ENTITY.get(), FilefishRender::new);

        /* REGISTER BETTA SPAWNING */
        SpawnPlacements.register(BettasAquaticsMain.BETTA_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BettaEntity::checkBettaSpawnRules);
        SpawnPlacements.register(BettasAquaticsMain.SNAIL_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SnailEntity::checkSnailSpawnRules);
        SpawnPlacements.register(BettasAquaticsMain.KOI_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, KoiEntity::checkGenericFreshwaterSpawnRules);
        SpawnPlacements.register(BettasAquaticsMain.TETRA_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, TetraEntity::checkTinyFishSpawnRules);
        SpawnPlacements.register(BettasAquaticsMain.CHERRYBARB_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CherryBarbEntity::checkTinyFishSpawnRules);

        SpawnPlacements.register(BettasAquaticsMain.SEAHORSE_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SeaHorseEntity::checkBettasAquaticsTropicalFishSpawnRules);
        SpawnPlacements.register(BettasAquaticsMain.CLOWNFISH_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ClownfishEntity::checkBettasAquaticsTropicalFishSpawnRules);
        SpawnPlacements.register(BettasAquaticsMain.SEASTAR_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SeaStarEntity::checkBettasAquaticsTinyTropicalFishSpawnRules);
        SpawnPlacements.register(BettasAquaticsMain.ANGELFISH_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, AngelfishEntity::checkAngelfishSpawnRules);
        SpawnPlacements.register(BettasAquaticsMain.FILEFISH_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, FilefishEntity::checkBettasAquaticsTropicalFishSpawnRules);


        /* SET BLOCK RENDER LAYERS */
        ItemBlockRenderTypes.setRenderLayer(BettasAquaticsMain.TANK.get(), RenderType.translucent());
    }

    @SubscribeEvent
    public static void entityRenderersEvent(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(BettasAquaticsMain.TANK_TILE.get(), TankTileRenderer::new);
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

        BettasAquaticsMain.BLOCKS.getEntries().forEach(registryObject -> {
            if (registryObject != null) {
                if (registryObject.get() instanceof Decor.Vanilla decor) {
                    decor.init();
                } else if (registryObject.get() instanceof Decor decor) {
                    String name = decor.getRegistryName().getPath();

                    Item item = (new Item(new Item.Properties().tab(BettasAquaticsMain.TANK_TAB))).setRegistryName(name);
                    registry.register(item);
                    Decor.addMappings(decor, item);
                }
            }
        });
    }
}
