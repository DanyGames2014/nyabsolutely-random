package net.danygames2014.nyabsolutelyrandom.item;

import net.minecraft.class_555;
import net.minecraft.client.Minecraft;
import net.minecraft.client.render.Tessellator;
import net.modificationstation.stationapi.api.util.Identifier;
import org.lwjgl.opengl.GL11;

public class MexicoGlassesItem extends GlassesItem{
    public MexicoGlassesItem(Identifier identifier) {
        super(identifier);
    }

    @Override
    public void postHudRender(class_555 worldRenderer, Minecraft client) {
        int startX = 0;
        int startY = 0;
        int endX = client.displayWidth;
        int endY = client.displayHeight;

        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glShadeModel(GL11.GL_SMOOTH);
        Tessellator tessellator = Tessellator.INSTANCE;
        tessellator.startQuads();
        tessellator.color(255, 220, 125, 120);
        tessellator.vertex(endX, startY, 0.0);
        tessellator.vertex(startX, startY, 0.0);
        tessellator.vertex(startX, endY, 0.0);
        tessellator.vertex(endX, endY, 0.0);
        tessellator.draw();
        GL11.glShadeModel(GL11.GL_FLAT);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
    }

    @Override
    public void constructRenderer() {
        this.texture = "assets/nyabsolutelyrandom/stationapi/textures/accessory/glasses/mexico.png";
        super.constructRenderer();
    }
}
