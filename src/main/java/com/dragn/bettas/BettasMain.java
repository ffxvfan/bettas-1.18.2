package com.dragn.bettas;

import com.dragn.bettas.betta.BettaEntity;
import com.dragn.bettas.biome.BettaBiome;
import com.dragn.bettas.decor.Decor;
import com.dragn.bettas.koi.KoiEntity;
import com.dragn.bettas.network.NetworkManager;
import com.dragn.bettas.snail.SnailEntity;
import com.dragn.bettas.tank.Tank;
import com.dragn.bettas.tank.TankTile;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.datafix.fixes.BiomeFix;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.*;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DataSerializerEntry;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

import java.util.Objects;
import java.util.Random;

import static net.minecraftforge.common.BiomeDictionary.Type.*;

@Mod(BettasMain.MODID)
public class BettasMain {

    public static Random RANDOM = new Random();
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "bettas";


    /* BETTA INVENTORY TAB */
    public static final CreativeModeTab BETTAS_TAB = new CreativeModeTab("betta_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(BETTA_BUCKET.get());
        }
    };


    /* ENTITIES */
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, MODID);
    public static final RegistryObject<EntityType<BettaEntity>> BETTA_ENTITY = ENTITY_TYPES.register("betta", () -> EntityType.Builder.of(BettaEntity::new, MobCategory.WATER_AMBIENT).sized(0.3f, 0.1f).build(new ResourceLocation(MODID, "betta").toString()));
    public static final RegistryObject<EntityType<SnailEntity>> SNAIL_ENTITY = ENTITY_TYPES.register("snail", () -> EntityType.Builder.of(SnailEntity::new, MobCategory.WATER_AMBIENT).sized(0.09f, 0.09f).build(new ResourceLocation(MODID, "snail").toString()));
    public static final RegistryObject<EntityType<KoiEntity>> KOI_ENTITY = ENTITY_TYPES.register("koi", () -> EntityType.Builder.of(KoiEntity::new, MobCategory.WATER_AMBIENT).sized(0.7f, 0.4f).build(new ResourceLocation(MODID, "koi").toString()));


    /* BETTA BLOCKS */
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final RegistryObject<Tank> TANK = BLOCKS.register("tank", Tank::new);
    public static final RegistryObject<Decor> BIG_LOG = BLOCKS.register("big_log", () -> new Decor(Block.Properties.of(Material.WOOD).noOcclusion()));
    public static final RegistryObject<Decor> FILTER = BLOCKS.register("filter", () -> new Decor(Block.Properties.of(Material.METAL).noOcclusion()));
    public static final RegistryObject<Decor> HEATER = BLOCKS.register("heater", () -> new Decor(Block.Properties.of(Material.METAL).noOcclusion()));
    public static final RegistryObject<Decor> LARGE_ROCK = BLOCKS.register("large_rock", () -> new Decor(Block.Properties.of(Material.STONE).noOcclusion()));
    public static final RegistryObject<Decor> MEDIUM_ROCK = BLOCKS.register("medium_rock", () -> new Decor(Block.Properties.of(Material.STONE).noOcclusion()));
    public static final RegistryObject<Decor> SMALL_LOG = BLOCKS.register("small_log", () -> new Decor(Block.Properties.of(Material.WOOD).noOcclusion()));
    public static final RegistryObject<Decor> SMALL_ROCK = BLOCKS.register("small_rock", () -> new Decor(Block.Properties.of(Material.STONE).noOcclusion()));
    public static final RegistryObject<Decor> KELP = BLOCKS.register("kelp", () -> new Decor(Block.Properties.copy(Blocks.KELP)));
    public static final RegistryObject<Decor> SEAGRASS = BLOCKS.register("seagrass", () -> new Decor(Block.Properties.copy(Blocks.SEAGRASS)));
    public static final RegistryObject<Decor> SUBSTRATE = BLOCKS.register("substrate", () -> new Decor(Block.Properties.of(Material.SAND).noOcclusion()));


    /* ITEMS */
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final RegistryObject<ForgeSpawnEggItem> BETTA_SPAWN_EGG = ITEMS.register("betta_spawn_egg", () -> new ForgeSpawnEggItem(BETTA_ENTITY, 0xC37FCC, 0xEFE9F0, new Item.Properties().stacksTo(64).tab(BETTAS_TAB)));
    public static final RegistryObject<ForgeSpawnEggItem> SNAIL_SPAWN_EGG = ITEMS.register("snail_spawn_egg", () -> new ForgeSpawnEggItem(SNAIL_ENTITY, 0xf5cb71, 0xad5a0c, new Item.Properties().stacksTo(64).tab(BETTAS_TAB)));
    public static final RegistryObject<ForgeSpawnEggItem> KOI_SPAWN_EGG = ITEMS.register("koi_spawn_egg", () -> new ForgeSpawnEggItem(KOI_ENTITY, 0xEDEDED, 0xFF9922, new Item.Properties().stacksTo(64).tab(BETTAS_TAB)));
    public static final RegistryObject<BucketItem> BETTA_BUCKET = ITEMS.register("betta_bucket", () -> new MobBucketItem(BETTA_ENTITY, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).tab(BETTAS_TAB)));
    public static final RegistryObject<BucketItem> SNAIL_BUCKET = ITEMS.register("snail_bucket", () -> new MobBucketItem(SNAIL_ENTITY, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).tab(BETTAS_TAB)));
    public static final RegistryObject<BucketItem> KOI_BUCKET = ITEMS.register("koi_bucket", () -> new MobBucketItem(KOI_ENTITY, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).tab(BETTAS_TAB)));
    public static final RegistryObject<BlockItem> TANK_ITEM = ITEMS.register("tank", () -> new BlockItem(TANK.get(), new Item.Properties().tab(BETTAS_TAB)));
    public static final RegistryObject<Item> BIG_LOG_ITEM = ITEMS.register("big_log_item", () -> new Item(new Item.Properties().tab(BETTAS_TAB)));
    public static final RegistryObject<Item> FILTER_ITEM = ITEMS.register("filter_item", () -> new Item(new Item.Properties().tab(BETTAS_TAB)));
    public static final RegistryObject<Item> HEATER_ITEM = ITEMS.register("heater_item", () -> new Item(new Item.Properties().tab(BETTAS_TAB)));
    public static final RegistryObject<Item> LARGE_ROCK_ITEM = ITEMS.register("large_rock_item", () -> new Item(new Item.Properties().tab(BETTAS_TAB)));
    public static final RegistryObject<Item> MEDIUM_ROCK_ITEM = ITEMS.register("medium_rock_item", () -> new Item(new Item.Properties().tab(BETTAS_TAB)));
    public static final RegistryObject<Item> SMALL_LOG_ITEM = ITEMS.register("small_log_item", () -> new Item(new Item.Properties().tab(BETTAS_TAB)));
    public static final RegistryObject<Item> SMALL_ROCK_ITEM = ITEMS.register("small_rock_item", () -> new Item(new Item.Properties().tab(BETTAS_TAB)));


    /* BETTA TILE ENTITIES */
    public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MODID);
    public static final RegistryObject<BlockEntityType<TankTile>> TANK_TILE = TILE_ENTITIES.register("tank_tile", () -> BlockEntityType.Builder.of(TankTile::new, TANK.get()).build(null));


    /* BETTA COLOR MAP SERIALIZATION */
    public static final DeferredRegister<DataSerializerEntry> SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.DATA_SERIALIZERS, MODID);
    public static final RegistryObject<DataSerializerEntry> COLOR_SERIALIZER = SERIALIZERS.register("color_serializer",
            () -> new DataSerializerEntry(new EntityDataSerializer<int[]>() {
                @Override
                public void write(FriendlyByteBuf buffer, int[] list) {
                    buffer.writeVarIntArray(list);
                }

                @Override
                public int[] read(FriendlyByteBuf buffer) {
                    return buffer.readVarIntArray();
                }

                @Override
                public int[] copy(int[] list) {
                    return list;
                }
            }));


    public BettasMain() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::setup);

        ENTITY_TYPES.register(modEventBus);
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        TILE_ENTITIES.register(modEventBus);
        SERIALIZERS.register(modEventBus);

        BettaBiome.BIOMES.register(modEventBus);

        GeckoLib.initialize();

        MinecraftForge.EVENT_BUS.register(this);
    }

    public void setup(final FMLCommonSetupEvent event) {
        NetworkManager.init();

        /* REGISTER BETTA BIOME */
        ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(
                BettaBiome.BETTA_SWAMP.get()
        )));
        BiomeDictionary.addTypes(key, WET, SWAMP, OVERWORLD);
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(key, 10));
    }
}
