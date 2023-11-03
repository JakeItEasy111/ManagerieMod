package com.jakeiteasy.menagerie.datagen;

import com.jakeiteasy.menagerie.Menagerie;
import com.jakeiteasy.menagerie.registry.ItemRegistry;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Menagerie.MODID, existingFileHelper);
    }
    @Override
    protected void registerModels() {
        withExistingParent(ItemRegistry.ALLIED_VEX_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }
}
