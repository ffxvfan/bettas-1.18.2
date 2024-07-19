package com.dragn.bettas.betta;

import com.dragn.bettas.BettasMain;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.Random;

public class BettaEntity extends AbstractFish implements IAnimatable {

    private static final EntityDataAccessor<Integer> MODEL = SynchedEntityData.defineId(BettaEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> BASE_PATTERN = SynchedEntityData.defineId(BettaEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<int[]> COLOR_MAP =  SynchedEntityData.defineId(BettaEntity.class, (EntityDataSerializer<int[]>) BettasMain.COLOR_SERIALIZER.get().getSerializer());

    public static boolean checkBettasAquaticsSpawnRules(EntityType<BettaEntity> entity, LevelAccessor level, MobSpawnType mobSpawnType, BlockPos pos, Random random) {
        int seaLevel = level.getSeaLevel();
        int depthMin = seaLevel - 13;
        return pos.getY() >= depthMin && pos.getY() <= seaLevel
                && level.getBlockState(pos.below()).is(Blocks.WATER)
                && level.getBlockState(pos.above()).is(Blocks.WATER)
                && level.getBlockState(pos.east()).is(Blocks.WATER)
                && level.getBlockState(pos.west()).is(Blocks.WATER)
                && level.getBlockState(pos.north()).is(Blocks.WATER)
                && level.getBlockState(pos.south()).is(Blocks.WATER);
    }

    public static int[] generateMap() {
        int[] map = new int[7];

        Palette palette = Palette.getRandomPalette();
        map[0] = palette.getRandomColor();
        map[1] = palette.getRandomShade();

        palette = Palette.getRandomPalette();
        map[2] = palette.getRandomColor();
        map[3] = palette.getRandomShade();

        palette = Palette.getRandomPalette();
        map[4] = palette.getRandomColor();
        map[5] = palette.getRandomShade();

        palette = Palette.getRandomPalette();
        map[6] = palette.getRandomColor();

        return map;
    }



    private ResourceLocation textureLocation = null; // cached texture; populated at runtime

    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public BettaEntity(EntityType<? extends AbstractFish> entity, Level level) {
        super(entity, level);
        this.noCulling = true;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 4)
                .add(Attributes.ATTACK_DAMAGE, 0.5)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.9)
                ;}

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new RandomSwimmingGoal(this, 1d, 10));
        this.goalSelector.addGoal(  0, new NearestAttackableTargetGoal<BettaEntity>(this, BettaEntity.class, 35, true, true, LivingEntity::attackable));
        this.goalSelector.addGoal(  0, new MeleeAttackGoal(this, 2, true));
    }

    @Override
    public ItemStack getBucketItemStack() {
        return BettasMain.BETTA_BUCKET.get().getDefaultInstance();
    }

    public void saveToBucketTag(ItemStack itemStack) {
        super.saveToBucketTag(itemStack);
        CompoundTag compoundTag = itemStack.getOrCreateTag();
        compoundTag.putInt("Model", getModel());
        compoundTag.putInt("BasePattern", getBasePattern());
        compoundTag.putIntArray("ColorMap", getColorMap());
    }

    @Override
    protected SoundEvent getFlopSound() {
        return null;
    }

    @Override
    public int getMaxSpawnClusterSize() {
        return 1;
    }

    private <E extends IAnimatable>PlayState predicate(AnimationEvent<E> event) {

        if (event.isMoving()) {
            if (isAggressive()) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("aggressive", ILoopType.EDefaultLoopTypes.LOOP));

            } else
                event.getController().setAnimation(new AnimationBuilder().addAnimation("swim", ILoopType.EDefaultLoopTypes.LOOP));
        } else
            event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", ILoopType.EDefaultLoopTypes.LOOP));

        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "controller", 8, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    public ResourceLocation getTextureLocation() {
        if(textureLocation == null) {
            textureLocation = TextureGen.generateTexture(BasePattern.patternFromOrdinal(getBasePattern()), getColorMap());
        }
        return textureLocation;
    }

    public int getModel() {
        return this.entityData.get(MODEL);
    }

    public int getBasePattern() {
        return this.entityData.get(BASE_PATTERN);
    }

    public int[] getColorMap() {
        return this.entityData.get(COLOR_MAP);
    }

    public void setModel(int model) {
        this.entityData.set(MODEL, model);
    }

    public void setBasePattern(int baseTexture) {
        this.entityData.set(BASE_PATTERN, baseTexture);
    }

    public void setColorMap(int[] colorMap) {
        this.entityData.set(COLOR_MAP, colorMap);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if(compoundTag.contains("Model")) {
            setModel(compoundTag.getInt("Model"));
        }
        if(compoundTag.contains("BasePattern")) {
            setBasePattern(compoundTag.getInt("BasePattern"));
        }
        if(compoundTag.contains("ColorMap")) {
            setColorMap(compoundTag.getIntArray("ColorMap"));
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt("Model", getModel());
        compoundTag.putInt("BasePattern", getBasePattern());
        compoundTag.putIntArray("ColorMap", getColorMap());
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {
        if(compoundTag != null && compoundTag.contains("Model") && compoundTag.contains("BasePattern") && compoundTag.contains("ColorMap")) {
            setModel(compoundTag.getInt("Model"));
            setBasePattern(compoundTag.getInt("BasePattern"));
            setColorMap(compoundTag.getIntArray("ColorMap"));
        } else {
            setModel(BettasMain.RANDOM.nextInt(Model.values().length));
            setBasePattern(BettasMain.RANDOM.nextInt(BasePattern.values().length));
            setColorMap(generateMap());
        }
        return super.finalizeSpawn(levelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(MODEL, 0);
        this.entityData.define(BASE_PATTERN, 0);
        this.entityData.define(COLOR_MAP, new int[7]);
    }
}
