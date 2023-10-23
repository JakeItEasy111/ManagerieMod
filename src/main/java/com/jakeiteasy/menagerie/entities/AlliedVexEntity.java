package com.jakeiteasy.menagerie.entities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class AlliedVexEntity extends Allay {

    public AlliedVexEntity(EntityType<? extends Allay> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.FLYING_SPEED, (double)0.1F)
                .add(Attributes.MOVEMENT_SPEED, (double)0.1F)
                .add(Attributes.ATTACK_DAMAGE, 4.0D)
                .add(Attributes.FOLLOW_RANGE, 48.0D);
    }
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Monster.class, true));
    }


}
