package com.dragn.bettas;

import com.dragn.bettas.betta.BettaEntity;
import com.dragn.bettas.biome.BettaBiome;
import com.dragn.bettas.decor.Decor;
import com.dragn.bettas.fish.saltwater.clownfish.ClownfishEntity;
import com.dragn.bettas.fish.saltwater.seahorse.SeaHorseEntity;
import com.dragn.bettas.fish.saltwater.seastar.SeaStarEntity;
import com.dragn.bettas.item.AlgaeScraper;
import com.dragn.bettas.item.AllRound;
import com.dragn.bettas.fish.freshwater.koi.KoiEntity;
import com.dragn.bettas.fish.freshwater.snail.SnailEntity;
import com.dragn.bettas.tank.Tank;
import com.dragn.bettas.tank.TankTile;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DataSerializerEntry;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import software.bernie.geckolib3.GeckoLib;
import terrablender.api.Regions;

import java.util.Random;

@Mod(BettasMain.MODID)
public class BettasMain {

    public static Random RANDOM = new Random();
    public static final String MODID = "bettas";

    public static final CreativeModeTab BETTAS_TAB = new CreativeModeTab("betta_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(BETTA_BUCKET.get());
        }
    };

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, MODID);
    public static final DeferredRegister<DataSerializerEntry> SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.DATA_SERIALIZERS, MODID);


    //FRESHWATER
    public static final RegistryObject<EntityType<BettaEntity>> BETTA_ENTITY = ENTITY_TYPES.register("betta", () -> EntityType.Builder.of(BettaEntity::new, MobCategory.WATER_AMBIENT).sized(0.3f, 0.1f).build(new ResourceLocation(MODID, "betta").toString()));
    public static final RegistryObject<EntityType<SnailEntity>> SNAIL_ENTITY = ENTITY_TYPES.register("snail", () -> EntityType.Builder.of(SnailEntity::new, MobCategory.WATER_AMBIENT).sized(0.09f, 0.09f).build(new ResourceLocation(MODID, "snail").toString()));
    public static final RegistryObject<EntityType<KoiEntity>> KOI_ENTITY = ENTITY_TYPES.register("koi", () -> EntityType.Builder.of(KoiEntity::new, MobCategory.WATER_AMBIENT).sized(0.7f, 0.4f).build(new ResourceLocation(MODID, "koi").toString()));

    //SALTWATER
    public static final RegistryObject<EntityType<SeaHorseEntity>> SEAHORSE_ENTITY = ENTITY_TYPES.register("seahorse", () -> EntityType.Builder.of(SeaHorseEntity::new, MobCategory.WATER_AMBIENT).sized(0.3f, 0.3f).build(new ResourceLocation(MODID, "seahorse").toString()));
    public static final RegistryObject<EntityType<ClownfishEntity>> CLOWNFISH_ENTITY = ENTITY_TYPES.register("clownfish", () -> EntityType.Builder.of(ClownfishEntity::new, MobCategory.WATER_AMBIENT).sized(0.3f, 0.1f).build(new ResourceLocation(MODID, "clownfish").toString()));
    public static final RegistryObject<EntityType<SeaStarEntity>> SEASTAR_ENTITY = ENTITY_TYPES.register("seastar", () -> EntityType.Builder.of(SeaStarEntity::new, MobCategory.WATER_AMBIENT).sized(0.45f, 0.05f).build(new ResourceLocation(MODID, "seastar").toString()));


    public static final RegistryObject<Tank> TANK = BLOCKS.register("tank", Tank::new);
    static {
        final String[] plainDecor = {"big_log", "filter", "heater", "large_rock", "medium_rock", "small_log", "small_rock"};
        for(String name : plainDecor) {
            BLOCKS.register(name, Decor::new);
        }
        BLOCKS.register("kelp", () -> new Decor.Vanilla(Items.KELP));
        BLOCKS.register("seagrass", () -> new Decor.Vanilla(Items.SEAGRASS));
        BLOCKS.register("substrate", () -> new Decor.Vanilla(Items.SAND));
        BLOCKS.register("red_substrate", () -> new Decor.Vanilla(Items.RED_SAND));
        BLOCKS.register("gravel_substrate", () -> new Decor.Vanilla(Items.GRAVEL));
        BLOCKS.register("dirt_substrate", () -> new Decor.Vanilla(Items.DIRT));
        BLOCKS.register("brain_coral_fan", () -> new Decor.Vanilla(Items.BRAIN_CORAL_FAN));
        BLOCKS.register("tube_coral_fan", () -> new Decor.Vanilla(Items.TUBE_CORAL_FAN));
        BLOCKS.register("fire_coral_fan", () -> new Decor.Vanilla(Items.FIRE_CORAL_FAN));
        BLOCKS.register("sea_pickle", () -> new Decor.Vanilla(Items.SEA_PICKLE));
    }
    public static final RegistryObject<ForgeSpawnEggItem> BETTA_SPAWN_EGG = ITEMS.register("betta_spawn_egg", () -> new ForgeSpawnEggItem(BETTA_ENTITY, 0xC37FCC, 0xEFE9F0, new Item.Properties().stacksTo(64).tab(BETTAS_TAB)));
    public static final RegistryObject<ForgeSpawnEggItem> SNAIL_SPAWN_EGG = ITEMS.register("snail_spawn_egg", () -> new ForgeSpawnEggItem(SNAIL_ENTITY, 0xf5cb71, 0xad5a0c, new Item.Properties().stacksTo(64).tab(BETTAS_TAB)));
    public static final RegistryObject<ForgeSpawnEggItem> KOI_SPAWN_EGG = ITEMS.register("koi_spawn_egg", () -> new ForgeSpawnEggItem(KOI_ENTITY, 0xEDEDED, 0xFF9922, new Item.Properties().stacksTo(64).tab(BETTAS_TAB)));
    public static final RegistryObject<ForgeSpawnEggItem> SEAHORSE_SPAWN_EGG = ITEMS.register("seahorse_spawn_egg", () -> new ForgeSpawnEggItem(SEAHORSE_ENTITY, 0xffcba6, 0xb9b6d6, new Item.Properties().stacksTo(64).tab(BETTAS_TAB)));
    public static final RegistryObject<ForgeSpawnEggItem> CLOWNFISH_SPAWN_EGG = ITEMS.register("clownfish_spawn_egg", () -> new ForgeSpawnEggItem(CLOWNFISH_ENTITY, 0xff4d00, 0xf1f1f1, new Item.Properties().stacksTo(64).tab(BETTAS_TAB)));
    public static final RegistryObject<ForgeSpawnEggItem> SEASTAR_ITEM = ITEMS.register("seastar_item", () -> new ForgeSpawnEggItem(SEASTAR_ENTITY, 0xc88d8d, 0xb4b778, new Item.Properties().stacksTo(64).tab(BETTAS_TAB)));


    public static final RegistryObject<BucketItem> BETTA_BUCKET = ITEMS.register("betta_bucket", () -> new MobBucketItem(BETTA_ENTITY, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).tab(BETTAS_TAB)));
    public static final RegistryObject<BucketItem> SNAIL_BUCKET = ITEMS.register("snail_bucket", () -> new MobBucketItem(SNAIL_ENTITY, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).tab(BETTAS_TAB)));
    public static final RegistryObject<BucketItem> KOI_BUCKET = ITEMS.register("koi_bucket", () -> new MobBucketItem(KOI_ENTITY, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).tab(BETTAS_TAB)));
    public static final RegistryObject<BucketItem> SEAHORSE_BUCKET = ITEMS.register("seahorse_bucket", () -> new MobBucketItem(SEAHORSE_ENTITY, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).tab(BETTAS_TAB)));
    public static final RegistryObject<BucketItem> CLOWNFISH_BUCKET = ITEMS.register("clownfish_bucket", () -> new MobBucketItem(CLOWNFISH_ENTITY, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).tab(BETTAS_TAB)));



    public static final RegistryObject<BlockItem> TANK_ITEM = ITEMS.register("tank", () -> new BlockItem(TANK.get(), new Item.Properties().tab(BETTAS_TAB)));
    public static final RegistryObject<Item> ALGAE_SCRAPER = ITEMS.register("algae_scraper", AlgaeScraper::new);
    public static final RegistryObject<Item> ALLROUND = ITEMS.register("allround", AllRound::new);
    public static final RegistryObject<BlockEntityType<TankTile>> TANK_TILE = TILE_ENTITIES.register("tank_tile", () -> BlockEntityType.Builder.of(TankTile::new, TANK.get()).build(null));
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

        ENTITY_TYPES.register(modEventBus);
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        TILE_ENTITIES.register(modEventBus);
        SERIALIZERS.register(modEventBus);

        modEventBus.addListener(this::setup);

        GeckoLib.initialize();

        MinecraftForge.EVENT_BUS.register(this);
    }

    public void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Regions.register(new BettaBiome.BettaRegion());
        });
    }
}
