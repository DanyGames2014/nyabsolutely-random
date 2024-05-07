package net.danygames2014.nyabsolutelyrandom.item;

import com.matthewperiut.accessoryapi.api.Accessory;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class GlassesItem extends TemplateItem implements Accessory {
    public GlassesItem(Identifier identifier) {
        super(identifier);
    }

    @Override
    public String[] getAccessoryTypes(ItemStack item) {
        return new String[]{"glasses"};
    }
}
