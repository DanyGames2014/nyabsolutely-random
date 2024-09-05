package net.danygames2014.nyabsolutelyrandom;

import com.matthewperiut.accessoryapi.api.AccessoryRegister;
import net.danygames2014.nyabsolutelyrandom.block.BirthdayCakeBlock;
import net.danygames2014.nyabsolutelyrandom.block.PosterBlock;
import net.danygames2014.nyabsolutelyrandom.block.RotatableBlock;
import net.danygames2014.nyabsolutelyrandom.item.*;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.modificationstation.stationapi.api.event.registry.BlockRegistryEvent;
import net.modificationstation.stationapi.api.event.registry.ItemRegistryEvent;
import net.modificationstation.stationapi.api.item.tool.ToolMaterialFactory;
import net.modificationstation.stationapi.api.mod.entrypoint.Entrypoint;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Namespace;
import net.modificationstation.stationapi.api.util.Null;

public class NyabsolutelyRandom {
    @Entrypoint.Namespace
    public static final Namespace NAMESPACE = Null.get();

    public static Item glassesItem;
    public static Item upsideDownGlassesItem;
    public static Item pinkGlassesItem;
    public static Item mexicoGlassesItem;

    public static Item paperBagHat;

    public static Item thunderStickItem;
    public static Item banHammerItem;

    public static Item glassSwordItem;

    public static Block calmilamsyCakeBlock;
    public static Block mineDiverBlock;

    public static Block transFlag;
    public static Block czechFlag;

    @EventListener
    public void registerItems(ItemRegistryEvent event){
        registerAccessorySlots();

        glassesItem = new GlassesItem(NAMESPACE.id("glasses")).setTranslationKey(NAMESPACE, "glasses");
        upsideDownGlassesItem = new UpsideDownGlassesItem(NAMESPACE.id("upside_down_glasses")).setTranslationKey(NAMESPACE, "upside_down_glasses");
        pinkGlassesItem = new PinkGlassesItem(NAMESPACE.id("pink_glasses")).setTranslationKey(NAMESPACE, "pink_glasses");
        mexicoGlassesItem = new MexicoGlassesItem(NAMESPACE.id("mexico_glasses")).setTranslationKey(NAMESPACE, "mexico_glasses");

        paperBagHat = new PaperBagHatItem(NAMESPACE.id("paper_bag_hat")).setTranslationKey(NAMESPACE, "paper_bag_hat");

        thunderStickItem = new ThunderStickItem(NAMESPACE.id("thunder_stick")).setTranslationKey(NAMESPACE, "thunder_stick");
        banHammerItem = new BanHammerItem(NAMESPACE.id("ban_hammer")).setTranslationKey(NAMESPACE, "ban_hammer");

        ToolMaterial glassMaterial = ToolMaterialFactory.create("glass", 0, 1, 1, 16);
        glassSwordItem = new GlassSwordItem(NAMESPACE.id("glass_sword"),glassMaterial).setTranslationKey(NAMESPACE, "glass_sword");
    }

    @EventListener
    public void registerBlocks(BlockRegistryEvent event){
        calmilamsyCakeBlock = new BirthdayCakeBlock(NAMESPACE.id("calmilamsy_cake"), "calmilamsy").setTranslationKey(NAMESPACE, "calmilamsy_cake");
        mineDiverBlock = new RotatableBlock(NAMESPACE.id("mine_diver_block"), Material.SPONGE).setTranslationKey(NAMESPACE.id("mine_diver_block"));

        transFlag = new PosterBlock(NAMESPACE.id("trans_flag")).setTranslationKey(NAMESPACE, "trans_flag");
        czechFlag = new PosterBlock(NAMESPACE.id("czech_flag")).setTranslationKey(NAMESPACE, "czech_flag");
    }

    public void registerAccessorySlots() {
        AccessoryRegister.add("glasses");
    }
}
