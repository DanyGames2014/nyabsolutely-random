package net.danygames2014.nyabsolutelyrandom.item;

import com.matthewperiut.accessoryapi.api.Accessory;
import com.matthewperiut.accessoryapi.api.render.AccessoryRenderer;
import com.matthewperiut.accessoryapi.api.render.HasCustomRenderer;
import net.danygames2014.nyabsolutelyrandom.client.GlassesRenderer;
import net.minecraft.class_555;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Identifier;

import java.util.Optional;

public class GlassesItem extends TemplateItem implements Accessory, HasCustomRenderer {
    public String texture;
    public GlassesRenderer renderer;

    public GlassesItem(Identifier identifier) {
        super(identifier);
        this.setMaxCount(1);
        this.texture = "/assets/nyabsolutelyrandom/stationapi/textures/accessory/glasses/base.png";
    }

    @Override
    public String[] getAccessoryTypes(ItemStack item) {
        return new String[]{"glasses"};
    }

    public void preWorldRender(class_555 worldRenderer, Minecraft client){

    }

    public void postWorldRender(class_555 worldRenderer, Minecraft client){

    }

    public void postHudRender(class_555 worldRenderer, Minecraft client){

    }

    @Override
    public Optional<AccessoryRenderer> getRenderer() {
        return Optional.ofNullable(renderer);
    }

    @Override
    public void constructRenderer() {
        renderer = new GlassesRenderer(texture);
    }
}
