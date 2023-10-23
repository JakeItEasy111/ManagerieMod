package com.jakeiteasy.menagerie.registry;

import com.jakeiteasy.menagerie.Menagerie;
import com.jakeiteasy.menagerie.entities.AlliedVexEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.common.Tags;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityRegistry {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Menagerie.MODID);

    public static final RegistryObject<EntityType<AlliedVexEntity>> ALLIED_VEX =
            ENTITY_TYPES.register("rhino", () -> EntityType.Builder.of(AlliedVexEntity::new, MobCategory.CREATURE)
                    .sized(2.5f, 2.5f).build("rhino"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}
