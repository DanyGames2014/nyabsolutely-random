package net.danygames2014.nyabsolutelyrandom.mixin.upsidedownglasses;

import com.matthewperiut.accessoryapi.api.helper.AccessoryAccess;
import net.danygames2014.nyabsolutelyrandom.item.GlassesItem;
import net.minecraft.class_555;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_555.class)
public class class_555Mixin {
    @Shadow private Minecraft field_2349;

    @Inject(method = "method_1840", at = @At(value = "INVOKE", target = "Lnet/minecraft/class_555;method_1851(F)V", shift = At.Shift.BEFORE))
    public void preWorldRender(CallbackInfo ci){
        if(field_2349.player != null){
            for (var item : AccessoryAccess.getAccessories(field_2349.player, "glasses")){
                if(item.getItem() instanceof GlassesItem glasses){
                    glasses.preWorldRender(field_2349.field_2818, field_2349);
                }
            }
        }
    }

    @Inject(method = "method_1844", at = @At(value = "INVOKE", target = "Ljava/lang/System;nanoTime()J", ordinal = 1, shift = At.Shift.BEFORE))
    public void postWorldRender(float par1, CallbackInfo ci){
        if(field_2349.player != null){
            for (var item : AccessoryAccess.getAccessories(field_2349.player, "glasses")){
                if(item.getItem() instanceof GlassesItem glasses){
                    glasses.postWorldRender(field_2349.field_2818, field_2349);
                }
            }
        }
    }

    @Inject(method = "method_1844", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/hud/InGameHud;render(FZII)V", shift = At.Shift.AFTER))
    public void postHudRender(float par1, CallbackInfo ci){
        if(field_2349.player != null){
            for (var item : AccessoryAccess.getAccessories(field_2349.player, "glasses")){
                if(item.getItem() instanceof GlassesItem glasses){
                    glasses.postHudRender(field_2349.field_2818, field_2349);
                }
            }
        }
    }
}
