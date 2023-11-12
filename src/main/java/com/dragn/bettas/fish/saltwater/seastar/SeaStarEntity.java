package com.dragn.bettas.fish.saltwater.seastar;

import com.dragn.bettas.BettasMain;
import com.dragn.bettas.fish.saltwater.seahorse.SeaHorseEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.TryFindWaterGoal;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.Random;

public class SeaStarEntity extends AbstractFish implements IAnimatable {

    private static final EntityDataAccessor<Integer> TEXTURE = SynchedEntityData.defineId(SeaStarEntity.class, EntityDataSerializers.INT);

    public static boolean checkTropicalFishSpawnRules(EntityType<SeaStarEntity> p_186232_, LevelAccessor p_186233_, MobSpawnType p_186234_, BlockPos p_186235_, Random p_186236_) {
        return p_186233_.getFluidState(p_186235_.below()).is(FluidTags.WATER) && p_186233_.getBlockState(p_186235_.above()).is(Blocks.WATER) && (p_186233_.getBiome(p_186235_).is(Biomes.LUSH_CAVES) || WaterAnimal.checkSurfaceWaterAnimalSpawnRules(p_186232_, p_186233_, p_186234_, p_186235_, p_186236_));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 1d)
                .add(Attributes.MOVEMENT_SPEED, 0.3d)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1d);
    }

    static class SeaStarMovementController extends MoveControl {

        public SeaStarMovementController(Mob mob) {
            super(mob);
        }

        public void tick() {
            if (this.operation == Operation.MOVE_TO) {
                this.operation = Operation.WAIT;
                this.mob.setSpeed((float) (this.speedModifier * this.mob.getAttributeValue(Attributes.MOVEMENT_SPEED)));
            }
        }
    }



    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    public SeaStarEntity(EntityType<? extends AbstractFish> entityType, Level world) {
        super(entityType, world);
        this.moveControl = new SeaStarMovementController(this);
        this.noCulling = true;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "controller", 0, (event) -> PlayState.CONTINUE));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 0.25d, 30));
        this.goalSelector.addGoal(2, new TryFindWaterGoal(this));
    }


    //Bucket
    public void saveToBucketTag(ItemStack itemStack) {
        super.saveToBucketTag(itemStack);
        CompoundTag compoundTag = itemStack.getOrCreateTag();
        compoundTag.putInt("Texture", getTexture());
    }
    @Override
    public ItemStack getBucketItemStack() {
        return BettasMain.SEASTAR_ITEM.get().getDefaultInstance();
    }

    @Override
    protected SoundEvent getFlopSound() {
        return null;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(TEXTURE, 0);
    }

    public int getTexture() {
        return this.entityData.get(TEXTURE);
    }

    public void setTexture(int texture) {
        this.entityData.set(TEXTURE, texture);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt("Texture", getTexture());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        if(compoundTag.contains("Texture")) {
            setTexture(compoundTag.getInt("Texture"));
        }
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {
        if(compoundTag != null && compoundTag.contains("Texture")) {
            setTexture(compoundTag.getInt("Texture"));
        } else {
            setTexture(BettasMain.RANDOM.nextInt(Texture.values().length));
        }
        return super.finalizeSpawn(levelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
    }
}