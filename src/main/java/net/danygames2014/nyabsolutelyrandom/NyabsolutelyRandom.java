package net.danygames2014.nyabsolutelyrandom;

import com.matthewperiut.accessoryapi.api.AccessoryRegister;
import net.danygames2014.nyabsolutelyrandom.block.BirthdayCakeBlock;
import net.danygames2014.nyabsolutelyrandom.item.UpsideDownGlassesItem;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class NyabsolutelyRandom {
    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();

    public static Item upsideDownGlasses;

    public static Block calmilamsyCakeBlock;

    @EventListener
    public void registerItems(ItemRegistryEvent event){
        registerAccessorySlots();

        upsideDownGlasses = new UpsideDownGlassesItem(NAMESPACE.id("upside_down_glasses")).setTranslationKey(NAMESPACE, "upside_down_glasses");
    }

    @EventListener
    public void registerBlocks(BlockRegistryEvent event){
        calmilamsyCakeBlock = new BirthdayCakeBlock(NAMESPACE.id("calmilamsy_cake"), "calmilamsy").setTranslationKey(NAMESPACE, "calmilamsy_cake");
    }

    public void registerAccessorySlots() {
        AccessoryRegister.add("glasses");
    }
}
