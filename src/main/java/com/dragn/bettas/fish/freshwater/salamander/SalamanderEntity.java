package com.dragn.bettas.fish.freshwater.salamander;

import com.dragn.bettas.BettasMain;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
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

public class SalamanderEntity extends AbstractFish implements IAnimatable {

    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public static boolean checkBettasAquaticsSpawnRules(EntityType<SalamanderEntity> entity, ServerLevelAccessor level, MobSpawnType mobSpawnType, BlockPos pos, Random random) {
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

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 3d)
                .add(Attributes.MOVEMENT_SPEED, 1d);
    }

    public SalamanderEntity(EntityType<? extends SalamanderEntity> entity, Level level) {
        super(entity, level);
        this.noCulling = true;
    }

    protected SoundEvent getAmbientSound() {
        return null;
    }

    protected SoundEvent getDeathSound() {
        return null;
    }

    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return null;
    }

    protected SoundEvent getFlopSound() {
        return null;
    }


    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {

        if (event.isMoving()) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("swim", ILoopType.EDefaultLoopTypes.LOOP));

        } else
            event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", ILoopType.EDefaultLoopTypes.LOOP));


        return PlayState.CONTINUE;
    }


    //Controls animations
    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this,"controller",5,this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }



    //Bucket
    public void saveToBucketTag(ItemStack itemStack) {
        super.saveToBucketTag(itemStack);
        CompoundTag compoundTag = itemStack.getOrCreateTag();
        compoundTag.putInt("Variant", getTexture());
    }
    @Override
    public ItemStack getBucketItemStack() {
        return BettasMain.SALAMANDER_BUCKET.get().getDefaultInstance();
    }



    private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(SalamanderEntity.class, EntityDataSerializers.INT);
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(VARIANT, 0);
    }

    public int getTexture() {
        return this.entityData.get(VARIANT);
    }

    public void setTexture(int texture) {
        this.entityData.set(VARIANT, texture);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt("Variant", getTexture());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if(compoundTag.contains("Variant")) {
            setTexture(compoundTag.getInt("Variant"));
        }
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {
        if(compoundTag != null && compoundTag.contains("Variant")) {
            setTexture(compoundTag.getInt("Variant"));
        } else {
            setTexture(BettasMain.RANDOM.nextInt(Variant.values().length));
        }
        return super.finalizeSpawn(levelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
    }
}
