package net.danygames2014.nyabsolutelyrandom.client;

import com.matthewperiut.accessoryapi.api.render.AccessoryRenderer;
import com.matthewperiut.accessoryapi.api.render.RenderingHelper;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class GlassesRenderer implements AccessoryRenderer {
    private static final BipedEntityModel model = new BipedEntityModel(0.6F);
    public String texture;
    public Color color = Color.WHITE;

    public GlassesRenderer(String texture) {
        this.texture = texture;
    }

    float brightness;
    @Override
    public void renderThirdPerson(PlayerEntity player, PlayerEntityRenderer renderer, ItemStack itemStack, double x, double y, double z, float h, float v) {
        RenderingHelper.beforeBiped(player, renderer, model, x, y, z, h, v);

        TextureManager textureManager = EntityRenderDispatcher.field_2489.field_2493;
        if (textureManager == null) {
            System.err.println("The entity texture manager is currently null");
            return;
        }
        textureManager.bindTexture(textureManager.getTextureId(texture));
        brightness = player.method_1394(h);

        GL11.glColor3f(brightness * color.getRed() / 255f, brightness * color.getGreen() / 255f, brightness * color.getBlue() / 255f);

        model.head.render(0.0625F);

        RenderingHelper.afterBiped(model);
    }
}
