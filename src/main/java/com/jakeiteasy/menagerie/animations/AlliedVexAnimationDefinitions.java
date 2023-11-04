package com.jakeiteasy.menagerie.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class AlliedVexAnimationDefinitions {
    public static AnimationDefinition getAlliedVexFly(float animTime) {
        return AnimationDefinition.Builder.withLength(1.75f).looping()
                .addAnimation("head",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(-35f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation("body",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(15f, 0f, 0f),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation("right_arm",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(-55.41f, -18.83f, -12.55f),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation("left_arm",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(-55.41f, 18.83f, 12.55f),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation("left_wing",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(0f, (float) (Math.sin(animTime*625)*30+30), 0f),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation("right_wing",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(0f, (float) (-(Math.sin(animTime*625)*30)-30), 0f),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation("allied_vex",
                        new AnimationChannel(AnimationChannel.Targets.POSITION,
                                new Keyframe(0f, KeyframeAnimations.posVec((float) (Math.sin(animTime*100)*1), (float) (Math.sin(animTime*200)*2), 0f),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation("allied_vex",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec(45f, (float) (Math.cos(animTime*200)*15), (float) (Math.sin(animTime*200)*10)),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation("lowerbody",
                        new AnimationChannel(AnimationChannel.Targets.POSITION,
                                new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, (float) (Math.cos(animTime*200)*0.5)),
                                        AnimationChannel.Interpolations.LINEAR)))
                .addAnimation("lowerbody",
                        new AnimationChannel(AnimationChannel.Targets.ROTATION,
                                new Keyframe(0f, KeyframeAnimations.degreeVec((float) (Math.cos(animTime*200)*10), (float) (Math.cos(animTime*200)*10), 0f),
                                        AnimationChannel.Interpolations.LINEAR))).build();
    }
}
