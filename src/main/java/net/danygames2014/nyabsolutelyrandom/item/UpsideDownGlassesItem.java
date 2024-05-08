package net.danygames2014.nyabsolutelyrandom.item;

import net.minecraft.class_555;
import net.minecraft.client.Minecraft;
import net.modificationstation.stationapi.api.util.Identifier;
import org.lwjgl.opengl.GL11;

public class UpsideDownGlassesItem extends GlassesItem{
    public UpsideDownGlassesItem(Identifier identifier) {
        super(identifier);
    }

    @Override
    public void preWorldRender(class_555 worldRenderer, Minecraft client) {
        GL11.glCullFace(GL11.GL_FRONT);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glLoadIdentity();
        GL11.glScalef(1.0F, -1.0F, 1.0F);
    }


    @Override
    public void postWorldRender(class_555 worldRenderer, Minecraft client) {
        GL11.glCullFace(GL11.GL_BACK);
    }
}
