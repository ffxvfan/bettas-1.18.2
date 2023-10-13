package com.dragn.bettas.tank;

import com.dragn.bettas.BettasMain;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.mojang.datafixers.util.Pair;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraftforge.client.model.IModelConfiguration;
import net.minecraftforge.client.model.IModelLoader;
import net.minecraftforge.client.model.geometry.IModelGeometry;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.function.Function;

public class TankLoader implements IModelLoader<TankLoader.TankModelGeometry> {

    public static final ResourceLocation LOCATION = new ResourceLocation(BettasMain.MODID, "tank_loader");
    public static final TankLoader INSTANCE = new TankLoader();

    @Override
    public TankModelGeometry read(JsonDeserializationContext deserializationContext, JsonObject modelContents) {
        return new TankModelGeometry();
    }

    @Override
    public void onResourceManagerReload(ResourceManager resourceManager) {

    }

    public static class TankModelGeometry implements IModelGeometry<TankModelGeometry> {

        @Override
        public BakedModel bake(IModelConfiguration owner, ModelBakery bakery, Function<Material, TextureAtlasSprite> spriteGetter, ModelState modelTransform, ItemOverrides overrides, ResourceLocation modelLocation) {
            return new TankModel(owner, bakery, spriteGetter, modelTransform, overrides, modelLocation);
        }

        @Override
        public Collection<Material> getTextures(IModelConfiguration owner, Function<ResourceLocation, UnbakedModel> modelGetter, Set<Pair<String, String>> missingTextureErrors) {
            return Arrays.asList(TankModel.BASE, TankModel.WALLS, TankModel.ALGAE_LEVELS[0], TankModel.ALGAE_LEVELS[1], TankModel.ALGAE_LEVELS[2], TankModel.ALGAE_LEVELS[3], TankModel.ALGAE_LEVELS[4]);
        }
    }
}
