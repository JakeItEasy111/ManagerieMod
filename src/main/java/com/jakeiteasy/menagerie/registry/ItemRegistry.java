package com.jakeiteasy.menagerie.registry;

import com.jakeiteasy.menagerie.Menagerie;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Menagerie.MODID);

    public static final RegistryObject<Item> ALLIED_VEX_SPAWN_EGG = ITEMS.register("allied_vex_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityRegistry.ALLIED_VEX, 0xFF69B4, 0xFFD9E8,
                    new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
