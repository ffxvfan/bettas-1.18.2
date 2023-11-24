package com.dragn.bettasaquatics.fish.freshwater.koi;

import com.dragn.bettasaquatics.BettasAquaticsMain;
import net.minecraft.resources.ResourceLocation;


public enum Variant {
    A(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi1.png")),
    B(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi2.png")),
    C(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi3.png")),
    D(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi4.png")),
    E(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi5.png")),
    F(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi6.png")),
    G(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi7.png")),
    H(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi8.png")),
    I(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi9.png")),
    J(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi10.png")),
    K(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi11.png")),
    L(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi12.png")),
    M(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi13.png")),
    N(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi14.png")),
    O(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi15.png")),
    P(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi16.png")),
    Q(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi17.png")),
    R(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi18.png")),
    S(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi19.png")),
    T(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi20.png")),
    U(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi21.png")),
    V(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi22.png")),
    W(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi23.png")),
    X(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi24.png")),
    Y(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi25.png")),
    Z(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi26.png")),
    AA(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi27.png")),
    BB(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi28.png")),
    CC(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi29.png")),
    DD(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi30.png")),
    EE(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi31.png")),
    FF(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi32.png")),
    GG(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi33.png")),
    HH(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi34.png")),
    II(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi35.png")),
    JJ(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi36.png")),
    KK(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi37.png")),
    LL(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi38.png")),
    MM(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi39.png")),
    NN(new ResourceLocation(BettasAquaticsMain.MODID, "textures/entity/koi40.png"));

    public final ResourceLocation resourceLocation;

    Variant(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static Variant patternFromOrdinal(int pattern) {
        return Variant.values()[pattern % Variant.values().length];
    }
}
