package net.danygames2014.nyabsolutelyrandom.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.modificationstation.stationapi.api.block.BlockState;
import net.modificationstation.stationapi.api.item.ItemPlacementContext;
import net.modificationstation.stationapi.api.state.StateManager;
import net.modificationstation.stationapi.api.state.property.Properties;
import net.modificationstation.stationapi.api.template.block.TemplateBlock;
import net.modificationstation.stationapi.api.util.Identifier;

public class PosterBlock extends TemplateBlock {
    public PosterBlock(Identifier identifier) {
        super(identifier, Material.WOOL);
    }

    @Override
    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING);
        super.appendProperties(builder);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return getDefaultState().with(Properties.HORIZONTAL_FACING, context.getHorizontalPlayerFacing());
    }

    @Override
    public Box getCollisionShape(World world, int x, int y, int z) {
        return null;
    }

    public Box getBoundingBox(World world, int x, int y, int z) {
        this.updateBoundingBox(world, x, y, z);
        return super.getBoundingBox(world, x, y, z);
    }

    public void updateBoundingBox(World world, int x, int y, int z) {
        this.setBoundingBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        switch (world.getBlockState(x,y,z).get(Properties.HORIZONTAL_FACING)){
            case WEST -> {
                this.setBoundingBox(0.0F, 0.125F, 0.9375F, 1.0F, 0.8125F, 1.0F);
            }

            case NORTH -> {
                this.setBoundingBox(0.0F, 0.125F, 0.0F, 0.0625F, 0.8125F, 1.0F);
            }

            case EAST -> {
                this.setBoundingBox(0.0F, 0.125F, 0.0F, 1.0F, 0.8125F, 0.0625F);
            }

            case SOUTH ->  {
                this.setBoundingBox(0.9375F, 0.125F, 0.0F, 1.0F, 0.8125F, 1.0F);
            }
        }
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
