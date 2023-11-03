package com.jakeiteasy.menagerie.model;

import com.jakeiteasy.menagerie.animations.AlliedVexAnimations;
import com.jakeiteasy.menagerie.entities.AlliedVexEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class AlliedVexModel<T extends Entity> extends HierarchicalModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "alliedvex"), "main");
    private final ModelPart allied_vex;
    public AlliedVexModel (ModelPart root) {
        this.allied_vex = root.getChild("allied_vex");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition allied_vex = partdefinition.addOrReplaceChild("allied_vex", CubeListBuilder.create(), PartPose.offset(0.0F, 15.25F, 0.0F));

        PartDefinition lowerbody = allied_vex.addOrReplaceChild("lowerbody", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body = lowerbody.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 10).addBox(-1.5F, 0.0F, -1.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 16).addBox(-1.5F, 1.0F, -1.0F, 3.0F, 5.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offset(0.0F, -6.0F, 0.0F));

        PartDefinition right_arm = lowerbody.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(23, 0).addBox(-1.5F, -0.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -5.5F, 0.0F));

        PartDefinition left_arm = lowerbody.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(23, 6).addBox(-0.5F, -0.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -5.5F, 0.0F));

        PartDefinition head = allied_vex.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -5.0F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 29).addBox(-3.5F, -7.0F, -1.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(4, 29).addBox(1.5F, -7.0F, -1.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

        PartDefinition left_wing = allied_vex.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(14, 12).addBox(0.0F, -1.0F, 0.0F, 0.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -5.0F, 1.0F));

        PartDefinition left_wing_r1 = left_wing.addOrReplaceChild("left_wing_r1", CubeListBuilder.create().texOffs(14, 12).addBox(0.5F, -5.0F, 1.0F, 0.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 5.0F, -1.0F, 0.0F, 0.2618F, 0.0F));

        PartDefinition right_wing = allied_vex.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(14, 12).addBox(0.0F, -1.0F, 0.0F, 0.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -5.0F, 1.0F));

        PartDefinition right_wing_r1 = right_wing.addOrReplaceChild("right_wing_r1", CubeListBuilder.create().texOffs(14, 12).addBox(-0.5F, -5.0F, 1.0F, 0.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 5.0F, -1.0F, 0.0F, -0.2618F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animate(((AlliedVexEntity) entity).flyAnimationState, AlliedVexAnimations.ALLIED_VEX_IDLE, ageInTicks, 2f);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        allied_vex.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return allied_vex;
    }
}