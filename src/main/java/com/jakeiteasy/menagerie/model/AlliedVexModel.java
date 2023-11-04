package com.jakeiteasy.menagerie.model;

import com.jakeiteasy.menagerie.Menagerie;
import com.jakeiteasy.menagerie.animations.AlliedVexAnimationDefinitions;
import com.jakeiteasy.menagerie.entities.AlliedVexEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;

public class AlliedVexModel extends HierarchicalModel<AlliedVexEntity> implements ArmedModel {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    private final ModelPart allied_vex;
    private final ModelPart head;
    private double animTime = 0.0;

    public AlliedVexModel(ModelPart root) {
        this.allied_vex = root.getChild("allied_vex");
        this.head = allied_vex.getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition allied_vex = partdefinition.addOrReplaceChild("allied_vex", CubeListBuilder.create(), PartPose.offset(0.0F, 24.25F, 0.0F));

        PartDefinition lowerbody = allied_vex.addOrReplaceChild("lowerbody", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body = lowerbody.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 10).addBox(-1.5F, 0.0F, -1.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 16).addBox(-1.5F, 1.0F, -1.0F, 3.0F, 5.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offset(0.0F, -6.0F, 0.0F));

        PartDefinition right_arm = lowerbody.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(23, 0).addBox(-1.5F, -0.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -5.5F, 0.0F));

        PartDefinition left_arm = lowerbody.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(23, 6).addBox(-0.5F, -0.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -5.5F, 0.0F));

        PartDefinition head = allied_vex.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -5.0F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(-1, 28).addBox(-3.5F, -7.0F, -1.0F, 2.0F, 3.0F, 0.1F, new CubeDeformation(0.0F))
                .texOffs(3, 28).addBox(1.5F, -7.0F, -1.0F, 2.0F, 3.0F, 0.1F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

        PartDefinition left_wing = allied_vex.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(14, 12).addBox(0.0F, -1.0F, 0.0F, 0.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -5.0F, 1.0F));

        PartDefinition left_wing_r1 = left_wing.addOrReplaceChild("left_wing_r1", CubeListBuilder.create().texOffs(14, 12).addBox(0.5F, -5.0F, 1.0F, 0.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 5.0F, -1.0F, 0.0F, 0.2618F, 0.0F));

        PartDefinition right_wing = allied_vex.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(14, 12).addBox(0.0F, -1.0F, 0.0F, 0.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -5.0F, 1.0F));

        PartDefinition right_wing_r1 = right_wing.addOrReplaceChild("right_wing_r1", CubeListBuilder.create().texOffs(14, 12).addBox(-0.5F, -5.0F, 1.0F, 0.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 5.0F, -1.0F, 0.0F, -0.2618F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    public void animateWithAnimTime(AlliedVexEntity entity, float ageInTicks, float animTime) {
        this.animate(entity.flyAnimationState, AlliedVexAnimationDefinitions.getAlliedVexFly(animTime), ageInTicks, 1f);
    }

    @Override
    public void setupAnim(AlliedVexEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        //this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);
        animTime += 1.0 / 20.0;
        if (animTime > 1.75) {
            animTime = 0.0;
        }
        animateWithAnimTime(entity, ageInTicks, (float) animTime);
        Menagerie.LOGGER.info("animTime is " + animTime);
        //this.animateWalk(AlliedVexAnimationDefinitions.ALLIED_VEX_FLY, 0, 0, 2f, 2.5f);
    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        allied_vex.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return allied_vex;
    }

    @Override
    public void translateToHand(HumanoidArm pSide, PoseStack pPoseStack) {
        float f = 1.0F;
        float f1 = 3.0F;
        this.allied_vex.translateAndRotate(pPoseStack);
        this.allied_vex.getChild("body").translateAndRotate(pPoseStack);
        pPoseStack.translate(0.0F, 0.0625F, 0.1875F);
        pPoseStack.mulPose(Axis.XP.rotation(this.allied_vex.getChild("body").getChild("right_arm").xRot));
        pPoseStack.scale(0.7F, 0.7F, 0.7F);
        pPoseStack.translate(0.0625F, 0.0F, 0.0F);
    }
}