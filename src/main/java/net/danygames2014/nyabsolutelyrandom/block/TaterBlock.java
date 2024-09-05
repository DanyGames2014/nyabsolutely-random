package net.danygames2014.nyabsolutelyrandom.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.util.Identifier;

public class TaterBlock extends RotatableBlock {
    public TaterBlock(Identifier identifier) {
        super(identifier, Material.SPONGE);
    }

    @Override
    public Box getBoundingBox(World world, int x, int y, int z) {

        return Box.createCached(0.375F, 0.0F, 0.375F, 0.625F, 0.4375F, 0.625F);
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public boolean isOpaque() {
        return false;
    }
}
