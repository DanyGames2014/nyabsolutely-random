package net.danygames2014.nyabsolutelyrandom.mixin.upsidedownglasses;

import com.matthewperiut.accessoryapi.api.helper.AccessoryAccess;
import net.danygames2014.nyabsolutelyrandom.NyabsolutelyRandom;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.class_555;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_555.class)
public class class_555Mixin {
    @Inject(method = "method_1840", at = @At(value = "INVOKE", target = "Lnet/minecraft/class_555;method_1851(F)V", shift = At.Shift.BEFORE))
    public void invertScreen(CallbackInfo ci){
        Minecraft client = (Minecraft) FabricLoader.getInstance().getGameInstance();
        if(client.player != null && AccessoryAccess.hasAccessory(client.player, NyabsolutelyRandom.upsideDownGlasses)){
            GL11.glDisable(GL11.GL_CULL_FACE);
            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glLoadIdentity();
            GL11.glScalef(1.0F, -1.0F, 1.0F);
        }
    }
}
