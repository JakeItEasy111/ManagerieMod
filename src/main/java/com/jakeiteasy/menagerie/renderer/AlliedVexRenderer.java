package com.jakeiteasy.menagerie.renderer;

import com.jakeiteasy.menagerie.Menagerie;
import com.jakeiteasy.menagerie.entities.AlliedVexEntity;
import com.jakeiteasy.menagerie.model.AlliedVexModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class AlliedVexRenderer extends MobRenderer <AlliedVexEntity, AlliedVexModel<AlliedVexEntity>> {

    public AlliedVexRenderer(EntityRendererProvider.Context pContext, AlliedVexModel<AlliedVexEntity> pModel) {
        super(pContext, pModel, 0.3f);
    }

    @Override
    public ResourceLocation getTextureLocation(AlliedVexEntity pEntity) {
        return new ResourceLocation(Menagerie.MODID, "alliedVex");
    }
}
