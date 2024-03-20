package net.giuliano.peruviansdelight.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.giuliano.peruviansdelight.PeruviansDelight;
import net.giuliano.peruviansdelight.entity.custom.AtunEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class AtunRenderer extends MobRenderer<AtunEntity, AtunModel<AtunEntity>> {
    public AtunRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new AtunModel<>(pContext.bakeLayer(ModModelLayers.ATUN_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(AtunEntity pEntity) {
        return new ResourceLocation(PeruviansDelight.MOD_ID, "textures/entity/atun.png");
    }

    @Override
    public void render(AtunEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
