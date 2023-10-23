package com.jakeiteasy.menagerie.client;

import com.jakeiteasy.menagerie.Menagerie;
import com.jakeiteasy.menagerie.model.AlliedVexModel;
import com.jakeiteasy.menagerie.renderer.AlliedVexLayers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Menagerie.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void onClientSetup(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(AlliedVexLayers.ALLIED_VEX_LAYER, AlliedVexModel::createBodyLayer);
    }
}
