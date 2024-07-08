package net.danygames2014.nyabsolutelyrandom.item;

import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class ThunderStickItem extends TemplateItem {
    public ThunderStickItem(Identifier identifier) {
        super(identifier);
        this.setMaxDamage(15);
    }

    @Override
    public boolean useOnBlock(ItemStack stack, PlayerEntity user, World world, int x, int y, int z, int side) {
        thunder(world, x, y, z);
        stack.damage(1, user);
        return true;
    }

    public void thunder(World world, int x, int y, int z){
        LightningEntity lightning = new LightningEntity(world, x, y, z);
        world.spawnEntity(lightning);
    }
}
