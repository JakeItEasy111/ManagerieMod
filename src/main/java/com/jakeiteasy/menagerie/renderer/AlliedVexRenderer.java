package com.jakeiteasy.menagerie.renderer;

import com.jakeiteasy.menagerie.Menagerie;
import com.jakeiteasy.menagerie.entities.AlliedVexEntity;
import com.jakeiteasy.menagerie.model.AlliedVexModel;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class AlliedVexRenderer extends MobRenderer <AlliedVexEntity, AlliedVexModel> {

    public AlliedVexRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new AlliedVexModel(pContext.bakeLayer(AlliedVexLayers.ALLIED_VEX_LAYER)), 0.3f);
    }

    @Override
    public ResourceLocation getTextureLocation(AlliedVexEntity pEntity) {
        return new ResourceLocation(Menagerie.MODID, "textures/allied_vex.png");
    }

    @Override
    public void render(AlliedVexEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
