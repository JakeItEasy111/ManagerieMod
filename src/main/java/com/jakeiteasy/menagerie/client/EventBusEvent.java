package com.jakeiteasy.menagerie.client;

import com.jakeiteasy.menagerie.Menagerie;
import com.jakeiteasy.menagerie.entities.AlliedVexEntity;
import com.jakeiteasy.menagerie.registry.EntityRegistry;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Menagerie.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)

public class EventBusEvent {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityRegistry.ALLIED_VEX.get(), AlliedVexEntity.createAttributes().build());
    }
}
