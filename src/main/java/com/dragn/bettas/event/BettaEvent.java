package com.dragn.bettas.event;


import com.dragn.bettas.BettasMain;
import com.dragn.bettas.betta.BettaEntity;
import com.dragn.bettas.betta.BettaRender;
import com.dragn.bettas.biome.BettaBiome;
import com.dragn.bettas.decor.Decor;
import com.dragn.bettas.fish.freshwater.koi.KoiEntity;
import com.dragn.bettas.fish.freshwater.koi.KoiRender;
import com.dragn.bettas.fish.freshwater.snail.SnailEntity;
import com.dragn.bettas.fish.freshwater.snail.SnailRender;
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
    }

    @SubscribeEvent
    public static void clientSetupEvent(FMLClientSetupEvent event) {

        /* REGISTER RENDERERS */
        EntityRenderers.register(BettasMain.BETTA_ENTITY.get(), BettaRender::new);
        EntityRenderers.register(BettasMain.SNAIL_ENTITY.get(), SnailRender::new);
        EntityRenderers.register(BettasMain.KOI_ENTITY.get(), KoiRender::new);

        /* REGISTER BETTA SPAWNING */
        SpawnPlacements.register(BettasMain.BETTA_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BettaEntity::checkBettaSpawnRules);
        SpawnPlacements.register(BettasMain.SNAIL_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SnailEntity::checkSnailSpawnRules);
        SpawnPlacements.register(BettasMain.KOI_ENTITY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, KoiEntity::checkSurfaceWaterAnimalSpawnRules);

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

                    Item item = (new Item(new Item.Properties().tab(BettasMain.BETTAS_TAB))).setRegistryName(name);
                    registry.register(item);
                    Decor.addMappings(decor, item);
                }
            }
        });
    }
}
