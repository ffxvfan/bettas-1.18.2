package com.dragn.bettas.decor;

import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.HashMap;
import java.util.Map;

public class Decor extends Block {

    public static Map<Item, Decor> ITEM_TO_DECOR = new HashMap<>();
    public static Map<Decor, Item> DECOR_TO_ITEM = new HashMap<>();
    public static Map<String, Decor> NAME_TO_DECOR = new HashMap<>();

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    private static final Material MATERIAL = new Material(MaterialColor.NONE, false, false, false, false, false, false, PushReaction.IGNORE);

    public static void addMappings(Decor decor, Item item) {
        ITEM_TO_DECOR.put(item, decor);
        DECOR_TO_ITEM.put(decor, item);
        for(BlockState state : decor.getStateDefinition().getPossibleStates()) {
            NAME_TO_DECOR.put(state.toString(), decor);
        }
    }

    public static class Vanilla extends Decor {
        public final Item item;

        public Vanilla(Item item) {
            super();
            this.item = item;
        }

        public void init() {
            addMappings(this, this.item);
        }
    }

    public Decor() {
        super(Block.Properties.of(MATERIAL).noOcclusion());
        registerDefaultState(getStateDefinition().any().setValue(FACING, Direction.NORTH));
    }

    public BlockState facing(Direction direction) {
        return defaultBlockState().setValue(FACING, direction);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
