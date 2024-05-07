package net.danygames2014.nyabsolutelyrandom;

import com.matthewperiut.accessoryapi.api.AccessoryRegister;
import net.danygames2014.nyabsolutelyrandom.item.UpsideDownGlassesItem;
import net.fabricmc.api.ModInitializer;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class NyabsolutelyRandom implements ModInitializer {
    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();

    public static Item upsideDownGlasses;

    @EventListener
    public void registerItems(ItemRegistryEvent event){
        upsideDownGlasses = new UpsideDownGlassesItem(NAMESPACE.id("upside_down_glasses")).setTranslationKey(NAMESPACE, "upside_down_glasses");
    }

    @EventListener
    public void registerBlocks(BlockRegistryEvent event){

    }

    @Override
    public void onInitialize() {
        AccessoryRegister.add("glasses");
    }
}
