package net.danygames2014.nyabsolutelyrandom.block;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class BirthdayCakeBlock extends TemplateBlock {
    public String celebrator;

    public BirthdayCakeBlock(Identifier identifier, String celebrator) {
        super(identifier, Material.CAKE);
        this.celebrator = celebrator;
        this.setBoundingBox(0.125F, 0.0F, 0.125F, 0.875F, 0.3125F, 0.875F);
        this.setHardness(0.25F);
    }

    @Override
    public boolean onUse(World world, int x, int y, int z, PlayerEntity player) {
        if (!world.isRemote) {
            if (player.name.equals(celebrator)) {
                player.method_490("Happy Birthday " + celebrator + "!");
            } else {
                player.method_490("This is " + celebrator + "'s Birthday Cake");
            }
            return true;
        }
        return super.onUse(world, x, y, z, player);
    }

    @Override
    public boolean isOpaque() {
        return false;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }
}
