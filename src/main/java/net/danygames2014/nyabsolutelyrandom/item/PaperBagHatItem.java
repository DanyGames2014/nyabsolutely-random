package net.danygames2014.nyabsolutelyrandom.item;

import net.danygames2014.nyabsolutelyrandom.NyabsolutelyRandom;
import net.minecraft.item.ArmorItem;
import net.modificationstation.stationapi.api.client.item.ArmorTextureProvider;
import net.modificationstation.stationapi.api.template.item.TemplateArmorItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class PaperBagHatItem extends TemplateArmorItem implements ArmorTextureProvider {
    public PaperBagHatItem(Identifier identifier) {
        super(identifier, 0, 0, 0); // identifier, type, textureIndex, equipmentSlot
        this.maxProtection = 2;
        this.setMaxDamage(34);
    }

    @Override
    public Identifier getTexture(ArmorItem armor) {
        return NyabsolutelyRandom.NAMESPACE.id("paper_bag_hat");
    }
}
