package com.jakeiteasy.menagerie.registry;

import com.jakeiteasy.menagerie.Menagerie;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityRegistry {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Menagerie.MODID);

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}
