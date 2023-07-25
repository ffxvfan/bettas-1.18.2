package com.dragn.bettas.network;

import com.dragn.bettas.BettasMain;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class NetworkManager {
    public static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
      new ResourceLocation(BettasMain.MODID, "network"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    public static void init() {
        INSTANCE.registerMessage(0, RemoveDecorRequest.class, RemoveDecorRequest::encode, RemoveDecorRequest::decode, RemoveDecorRequest::handle);
    }
}
