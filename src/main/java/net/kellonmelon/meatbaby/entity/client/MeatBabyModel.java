package net.kellonmelon.meatbaby.entity.client;

import net.kellonmelon.meatbaby.MeatBaby;
import net.kellonmelon.meatbaby.entity.custom.MeatBabyEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MeatBabyModel extends AnimatedGeoModel<MeatBabyEntity> {
    @Override
    public ResourceLocation getModelResource(MeatBabyEntity object) {
        return new ResourceLocation(MeatBaby.MOD_ID, "geo/meat_baby.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MeatBabyEntity object) {
        return new ResourceLocation(MeatBaby.MOD_ID, "textures/entities/meat_baby_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MeatBabyEntity animatable) {
        return new ResourceLocation(MeatBaby.MOD_ID, "animations/model4.animation.json");
    }
}
