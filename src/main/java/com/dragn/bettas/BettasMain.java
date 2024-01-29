package com.dragn.bettas;

import com.dragn.bettas.betta.BettaEntity;
import com.dragn.bettas.biome.BettaBiome;
import com.dragn.bettas.decor.Decor;
import com.dragn.bettas.fish.freshwater.cherrybarb.CherryBarbEntity;
import com.dragn.bettas.fish.freshwater.ghostshrimp.GhostShrimpEntity;
import com.dragn.bettas.fish.freshwater.glowfish.GlowFishEntity;
import com.dragn.bettas.fish.freshwater.goldfish.GoldfishEntity;
import com.dragn.bettas.fish.freshwater.guppy.GuppyEntity;
import com.dragn.bettas.fish.freshwater.isopod.IsopodEntity;
import com.dragn.bettas.fish.freshwater.koi.KoiEntity;
import com.dragn.bettas.fish.freshwater.silvershark.SilverSharkEntity;
import com.dragn.bettas.fish.freshwater.snail.SnailEntity;
import com.dragn.bettas.fish.freshwater.snakehead.SnakeheadEntity;
import com.dragn.bettas.fish.freshwater.tetra.TetraEntity;
import com.dragn.bettas.fish.saltwater.angelfish.AngelfishEntity;
import com.dragn.bettas.fish.saltwater.clownfish.ClownfishEntity;
import com.dragn.bettas.fish.saltwater.crab.CrabEntity;
import com.dragn.bettas.fish.saltwater.filefish.FilefishEntity;
import com.dragn.bettas.fish.saltwater.glaucus.GlaucusEntity;
import com.dragn.bettas.fish.saltwater.jelly.JellyEntity;
import com.dragn.bettas.fish.saltwater.seahorse.SeaHorseEntity;
import com.dragn.bettas.fish.saltwater.seaslug.SeaSlugEntity;
import com.dragn.bettas.fish.saltwater.seastar.SeaStarEntity;
import com.dragn.bettas.item.AlgaeScraper;
import com.dragn.bettas.item.AllRound;
import com.dragn.bettas.tank.Tank;
import com.dragn.bettas.tank.TankTile;
import com.dragn.bettas.util.config.BettasCommonConfig;
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
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
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
    public static final CreativeModeTab TANK_TAB = new CreativeModeTab("tank_tab") {
        @Override
        public ItemStack makeIcon() { return new ItemStack(TANK_ITEM.get());}
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
    public static final RegistryObject<EntityType<TetraEntity>> TETRA_ENTITY = ENTITY_TYPES.register("tetra", () -> EntityType.Builder.of(TetraEntity::new, MobCategory.WATER_AMBIENT).sized(0.1f, 0.1f).build(new ResourceLocation(MODID, "tetra").toString()));
    public static final RegistryObject<EntityType<CherryBarbEntity>> CHERRYBARB_ENTITY = ENTITY_TYPES.register("cherrybarb", () -> EntityType.Builder.of(CherryBarbEntity::new, MobCategory.WATER_AMBIENT).sized(0.1f, 0.1f).build(new ResourceLocation(MODID, "cherrybarb").toString()));
    public static final RegistryObject<EntityType<GoldfishEntity>> GOLDFISH_ENTITY = ENTITY_TYPES.register("goldfish", () -> EntityType.Builder.of(GoldfishEntity::new, MobCategory.WATER_AMBIENT).sized(0.3f, 0.1f).build(new ResourceLocation(MODID, "goldfish").toString()));
    public static final RegistryObject<EntityType<GuppyEntity>> GUPPY_ENTITY = ENTITY_TYPES.register("guppy", () -> EntityType.Builder.of(GuppyEntity::new, MobCategory.WATER_AMBIENT).sized(0.3f, 0.1f).build(new ResourceLocation(MODID, "guppy").toString()));
    public static final RegistryObject<EntityType<SilverSharkEntity>> SILVERSHARK_ENTITY = ENTITY_TYPES.register("silvershark", () -> EntityType.Builder.of(SilverSharkEntity::new, MobCategory.WATER_AMBIENT).sized(0.7f, 0.4f).build(new ResourceLocation(MODID, "silvershark").toString()));
    public static final RegistryObject<EntityType<GhostShrimpEntity>> GHOSTSHRIMP_ENTITY = ENTITY_TYPES.register("ghostshrimp", () -> EntityType.Builder.of(GhostShrimpEntity::new, MobCategory.WATER_AMBIENT).sized(0.3f, 0.1f).build(new ResourceLocation(MODID, "ghostshrimp").toString()));
    public static final RegistryObject<EntityType<IsopodEntity>> ISOPOD_ENTITY = ENTITY_TYPES.register("isopod", () -> EntityType.Builder.of(IsopodEntity::new, MobCategory.WATER_AMBIENT).sized(0.4f, 0.4f).build(new ResourceLocation(MODID, "isopod").toString()));
    public static final RegistryObject<EntityType<SnakeheadEntity>> SNAKEHEAD_ENTITY = ENTITY_TYPES.register("snakehead", () -> EntityType.Builder.of(SnakeheadEntity::new, MobCategory.WATER_AMBIENT).sized(0.7f, 0.4f).build(new ResourceLocation(MODID, "snakehead").toString()));
    public static final RegistryObject<EntityType<GlowFishEntity>> GLOWFISH_ENTITY = ENTITY_TYPES.register("glowfish", () -> EntityType.Builder.of(GlowFishEntity::new, MobCategory.WATER_AMBIENT).sized(0.1f, 0.1f).build(new ResourceLocation(MODID, "glowfish").toString()));

    //SALTWATER
    public static final RegistryObject<EntityType<SeaHorseEntity>> SEAHORSE_ENTITY = ENTITY_TYPES.register("seahorse", () -> EntityType.Builder.of(SeaHorseEntity::new, MobCategory.WATER_AMBIENT).sized(0.3f, 0.3f).build(new ResourceLocation(MODID, "seahorse").toString()));
    public static final RegistryObject<EntityType<ClownfishEntity>> CLOWNFISH_ENTITY = ENTITY_TYPES.register("clownfish", () -> EntityType.Builder.of(ClownfishEntity::new, MobCategory.WATER_AMBIENT).sized(0.3f, 0.1f).build(new ResourceLocation(MODID, "clownfish").toString()));
    public static final RegistryObject<EntityType<SeaStarEntity>> SEASTAR_ENTITY = ENTITY_TYPES.register("seastar", () -> EntityType.Builder.of(SeaStarEntity::new, MobCategory.WATER_AMBIENT).sized(0.45f, 0.005f).build(new ResourceLocation(MODID, "seastar").toString()));
    public static final RegistryObject<EntityType<AngelfishEntity>> ANGELFISH_ENTITY = ENTITY_TYPES.register("angelfish", () -> EntityType.Builder.of(AngelfishEntity::new, MobCategory.WATER_AMBIENT).sized(0.3f, 0.1f).build(new ResourceLocation(MODID, "angelfish").toString()));
    public static final RegistryObject<EntityType<FilefishEntity>> FILEFISH_ENTITY = ENTITY_TYPES.register("filefish", () -> EntityType.Builder.of(FilefishEntity::new, MobCategory.WATER_AMBIENT).sized(0.3f, 0.5f).build(new ResourceLocation(MODID, "filefish").toString()));
    public static final RegistryObject<EntityType<SeaSlugEntity>> SEASLUG_ENTITY = ENTITY_TYPES.register("seaslug", () -> EntityType.Builder.of(SeaSlugEntity::new, MobCategory.WATER_AMBIENT).sized(0.1f, 0.1f).build(new ResourceLocation(MODID, "seaslug").toString()));
    public static final RegistryObject<EntityType<GlaucusEntity>> GLAUCUS_ENTITY = ENTITY_TYPES.register("glaucus", () -> EntityType.Builder.of(GlaucusEntity::new, MobCategory.WATER_AMBIENT).sized(0.1f, 0.1f).build(new ResourceLocation(MODID, "glaucus").toString()));
    public static final RegistryObject<EntityType<JellyEntity>> JELLY_ENTITY = ENTITY_TYPES.register("jelly", () -> EntityType.Builder.of(JellyEntity::new, MobCategory.WATER_AMBIENT).sized(0.3f, 0.3f).build(new ResourceLocation(MODID, "jelly").toString()));
    public static final RegistryObject<EntityType<CrabEntity>> CRAB_ENTITY = ENTITY_TYPES.register("crab", () -> EntityType.Builder.of(CrabEntity::new, MobCategory.WATER_AMBIENT).sized(0.3f, 0.3f).build(new ResourceLocation(MODID, "crab").toString()));


    public static final RegistryObject<Tank> TANK = BLOCKS.register("tank", Tank::new);
    static {
        final String[] plainDecor = {"big_log", "filter", "heater", "large_rock", "medium_rock", "small_log", "small_rock", "shipwreck", "mossball_1", "mossball_2", "mini_castle"};
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
    public static final RegistryObject<ForgeSpawnEggItem> TETRA_SPAWN_EGG = ITEMS.register("tetra_spawn_egg", () -> new ForgeSpawnEggItem(TETRA_ENTITY, 0x7acae2, 0xa43737, new Item.Properties().stacksTo(64).tab(BETTAS_TAB)));
    public static final RegistryObject<ForgeSpawnEggItem> CHERRYBARB_SPAWN_EGG = ITEMS.register("cherrybarb_spawn_egg", () -> new ForgeSpawnEggItem(CHERRYBARB_ENTITY, 0xe22600, 0xe6350a, new Item.Properties().stacksTo(64).tab(BETTAS_TAB)));
    public static final RegistryObject<ForgeSpawnEggItem> GOLDFISH_SPAWN_EGG = ITEMS.register("goldfish_spawn_egg", () -> new ForgeSpawnEggItem(GOLDFISH_ENTITY, 0xff7300, 0xff9c1b, new Item.Properties().stacksTo(64).tab(BETTAS_TAB)));
    public static final RegistryObject<ForgeSpawnEggItem> GUPPY_SPAWN_EGG = ITEMS.register("guppy_spawn_egg", () -> new ForgeSpawnEggItem(GUPPY_ENTITY, 0x868882, 0x50deff, new Item.Properties().stacksTo(64).tab(BETTAS_TAB)));
    public static final RegistryObject<ForgeSpawnEggItem> SILVERSHARK_SPAWN_EGG = ITEMS.register("silvershark_spawn_egg", () -> new ForgeSpawnEggItem(SILVERSHARK_ENTITY, 0x818181, 0x628fca, new Item.Properties().stacksTo(64).tab(BETTAS_TAB)));
    public static final RegistryObject<ForgeSpawnEggItem> GHOSTSHRIMP_SPAWN_EGG = ITEMS.register("ghostshrimp_spawn_egg", () -> new ForgeSpawnEggItem(GHOSTSHRIMP_ENTITY, 0xffffff, 0xffe4ad, new Item.Properties().stacksTo(64).tab(BETTAS_TAB)));
    public static final RegistryObject<ForgeSpawnEggItem> ISOPOD_SPAWN_EGG = ITEMS.register("isopod_spawn_egg", () -> new ForgeSpawnEggItem(ISOPOD_ENTITY, 0x9f8c7b, 0xd3cab9, new Item.Properties().stacksTo(64).tab(BETTAS_TAB)));
    public static final RegistryObject<ForgeSpawnEggItem> SNAKEHEAD_SPAWN_EGG = ITEMS.register("snakehead_spawn_egg", () -> new ForgeSpawnEggItem(SNAKEHEAD_ENTITY, 0x1f1f1f, 0x938a39, new Item.Properties().stacksTo(64).tab(BETTAS_TAB)));
    public static final RegistryObject<ForgeSpawnEggItem> GLOWFISH_SPAWN_EGG = ITEMS.register("glowfish_spawn_egg", () -> new ForgeSpawnEggItem(GLOWFISH_ENTITY, 0x97ff39, 0xc7ff81, new Item.Properties().stacksTo(64).tab(BETTAS_TAB)));

    public static final RegistryObject<ForgeSpawnEggItem> SEAHORSE_SPAWN_EGG = ITEMS.register("seahorse_spawn_egg", () -> new ForgeSpawnEggItem(SEAHORSE_ENTITY, 0xffcba6, 0xb9b6d6, new Item.Properties().stacksTo(64).tab(BETTAS_TAB)));
    public static final RegistryObject<ForgeSpawnEggItem> CLOWNFISH_SPAWN_EGG = ITEMS.register("clownfish_spawn_egg", () -> new ForgeSpawnEggItem(CLOWNFISH_ENTITY, 0xff4d00, 0xf1f1f1, new Item.Properties().stacksTo(64).tab(BETTAS_TAB)));
    public static final RegistryObject<ForgeSpawnEggItem> SEASTAR_ITEM = ITEMS.register("seastar_item", () -> new ForgeSpawnEggItem(SEASTAR_ENTITY, 0xc88d8d, 0xb4b778, new Item.Properties().stacksTo(64).tab(BETTAS_TAB)));
    public static final RegistryObject<ForgeSpawnEggItem> ANGELFISH_SPAWN_EGG = ITEMS.register("angelfish_spawn_egg", () -> new ForgeSpawnEggItem(ANGELFISH_ENTITY, 0xe8400d, 0x271203, new Item.Properties().stacksTo(64).tab(BETTAS_TAB)));
    public static final RegistryObject<ForgeSpawnEggItem> FILEFISH_SPAWN_EGG = ITEMS.register("filefish_spawn_egg", () -> new ForgeSpawnEggItem(FILEFISH_ENTITY, 0x33b2de, 0xf2a305, new Item.Properties().stacksTo(64).tab(BETTAS_TAB)));
    public static final RegistryObject<ForgeSpawnEggItem> SEASLUG_SPAWN_EGG = ITEMS.register("seaslug_spawn_egg", () -> new ForgeSpawnEggItem(SEASLUG_ENTITY, 0x1d1d1d, 0x63366b, new Item.Properties().stacksTo(64).tab(BETTAS_TAB)));
    public static final RegistryObject<ForgeSpawnEggItem> GLAUCUS_SPAWN_EGG = ITEMS.register("glaucus_spawn_egg", () -> new ForgeSpawnEggItem(GLAUCUS_ENTITY, 0xc5deff, 0x4c6bbd, new Item.Properties().stacksTo(64).tab(BETTAS_TAB)));
    public static final RegistryObject<ForgeSpawnEggItem> JELLY_SPAWN_EGG = ITEMS.register("jelly_spawn_egg", () -> new ForgeSpawnEggItem(JELLY_ENTITY, 0xffb46f, 0xb96767, new Item.Properties().stacksTo(64).tab(BETTAS_TAB)));
    public static final RegistryObject<ForgeSpawnEggItem> CRAB_SPAWN_EGG = ITEMS.register("crab_spawn_egg", () -> new ForgeSpawnEggItem(CRAB_ENTITY, 0xae4239, 0x812222, new Item.Properties().stacksTo(64).tab(BETTAS_TAB)));


    public static final RegistryObject<BucketItem> BETTA_BUCKET = ITEMS.register("betta_bucket", () -> new MobBucketItem(BETTA_ENTITY, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).tab(BETTAS_TAB)));
    public static final RegistryObject<BucketItem> SNAIL_BUCKET = ITEMS.register("snail_bucket", () -> new MobBucketItem(SNAIL_ENTITY, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).tab(BETTAS_TAB)));
    public static final RegistryObject<BucketItem> KOI_BUCKET = ITEMS.register("koi_bucket", () -> new MobBucketItem(KOI_ENTITY, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).tab(BETTAS_TAB)));
    public static final RegistryObject<BucketItem> TETRA_BUCKET = ITEMS.register("tetra_bucket", () -> new MobBucketItem(TETRA_ENTITY, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).tab(BETTAS_TAB)));
    public static final RegistryObject<BucketItem> CHERRYBARB_BUCKET = ITEMS.register("cherrybarb_bucket", () -> new MobBucketItem(CHERRYBARB_ENTITY, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).tab(BETTAS_TAB)));
    public static final RegistryObject<BucketItem> GOLDFISH_BUCKET = ITEMS.register("goldfish_bucket", () -> new MobBucketItem(GOLDFISH_ENTITY, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).tab(BETTAS_TAB)));
    public static final RegistryObject<BucketItem> GUPPY_BUCKET = ITEMS.register("guppy_bucket", () -> new MobBucketItem(GUPPY_ENTITY, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).tab(BETTAS_TAB)));
    public static final RegistryObject<BucketItem> SILVERSHARK_BUCKET = ITEMS.register("silvershark_bucket", () -> new MobBucketItem(SILVERSHARK_ENTITY, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).tab(BETTAS_TAB)));
    public static final RegistryObject<BucketItem> GHOSTSHRIMP_BUCKET = ITEMS.register("ghostshrimp_bucket", () -> new MobBucketItem(GHOSTSHRIMP_ENTITY, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).tab(BETTAS_TAB)));
    public static final RegistryObject<BucketItem> ISOPOD_BUCKET = ITEMS.register("isopod_bucket", () -> new MobBucketItem(ISOPOD_ENTITY, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).tab(BETTAS_TAB)));
    public static final RegistryObject<BucketItem> SNAKEHEAD_BUCKET = ITEMS.register("snakehead_bucket", () -> new MobBucketItem(SNAKEHEAD_ENTITY, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).tab(BETTAS_TAB)));
    public static final RegistryObject<BucketItem> GLOWFISH_BUCKET = ITEMS.register("glowfish_bucket", () -> new MobBucketItem(GLOWFISH_ENTITY, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).tab(BETTAS_TAB)));

    public static final RegistryObject<BucketItem> SEAHORSE_BUCKET = ITEMS.register("seahorse_bucket", () -> new MobBucketItem(SEAHORSE_ENTITY, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).tab(BETTAS_TAB)));
    public static final RegistryObject<BucketItem> CLOWNFISH_BUCKET = ITEMS.register("clownfish_bucket", () -> new MobBucketItem(CLOWNFISH_ENTITY, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).tab(BETTAS_TAB)));
    public static final RegistryObject<BucketItem> ANGELFISH_BUCKET = ITEMS.register("angelfish_bucket", () -> new MobBucketItem(ANGELFISH_ENTITY, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).tab(BETTAS_TAB)));
    public static final RegistryObject<BucketItem> FILEFISH_BUCKET = ITEMS.register("filefish_bucket", () -> new MobBucketItem(FILEFISH_ENTITY, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).tab(BETTAS_TAB)));
    public static final RegistryObject<BucketItem> SEASLUG_BUCKET = ITEMS.register("seaslug_bucket", () -> new MobBucketItem(SEASLUG_ENTITY, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).tab(BETTAS_TAB)));
    public static final RegistryObject<BucketItem> GLAUCUS_BUCKET = ITEMS.register("glaucus_bucket", () -> new MobBucketItem(GLAUCUS_ENTITY, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).tab(BETTAS_TAB)));
    public static final RegistryObject<BucketItem> JELLY_BUCKET = ITEMS.register("jelly_bucket", () -> new MobBucketItem(JELLY_ENTITY, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).tab(BETTAS_TAB)));
    public static final RegistryObject<BucketItem> CRAB_BUCKET = ITEMS.register("crab_bucket", () -> new MobBucketItem(CRAB_ENTITY, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).tab(BETTAS_TAB)));


    public static final RegistryObject<BlockItem> TANK_ITEM = ITEMS.register("tank", () -> new BlockItem(TANK.get(), new Item.Properties().tab(TANK_TAB)));
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

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, BettasCommonConfig.SPEC, "bettas_aquatics-common.toml");

        MinecraftForge.EVENT_BUS.register(this);
    }

    public void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Regions.register(new BettaBiome.BettaRegion());
        });
    }
}
