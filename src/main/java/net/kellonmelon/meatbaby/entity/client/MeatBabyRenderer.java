package net.kellonmelon.meatbaby.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.kellonmelon.meatbaby.MeatBaby;
import net.kellonmelon.meatbaby.entity.custom.MeatBabyEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MeatBabyRenderer extends GeoEntityRenderer<MeatBabyEntity> {
    public MeatBabyRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new MeatBabyModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(MeatBabyEntity animatable) {
        return new ResourceLocation(MeatBaby.MOD_ID, "textures/entities/meat_baby_texture.png");
    }

    @Override
    public RenderType getRenderType(MeatBabyEntity animatable, float partialTick, PoseStack poseStack,
                                    @Nullable MultiBufferSource bufferSource,
                                    @Nullable VertexConsumer buffer, int packedLight, ResourceLocation texture) {
        return super.getRenderType(animatable, partialTick, poseStack, bufferSource, buffer, packedLight, texture);
    }
}
