package net.danygames2014.nyabsolutelyrandom.item;

import net.fabricmc.api.EnvType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Formatting;
import net.modificationstation.stationapi.api.util.Identifier;

public class BanHammerItem extends TemplateItem {
    public static boolean checkForOpStatus = true;

    public BanHammerItem(Identifier identifier) {
        super(identifier);
    }

    @Override
    public boolean preHit(ItemStack stack, Entity attackedEntity, PlayerEntity attacker) {
        if(FabricLoader.getInstance().getEnvironmentType() == EnvType.SERVER && attackedEntity instanceof PlayerEntity attackedPlayer) {
            handleBan(attackedPlayer, attacker);
        }

        return true;
    }

    public void handleBan(PlayerEntity attackedPlayer, PlayerEntity attackerPlayer){
        if(attackedPlayer instanceof ServerPlayerEntity attacked && attackerPlayer instanceof ServerPlayerEntity attacker){
            if(checkForOpStatus){
                if (!attacker.server.field_2842.method_584(attacker.name)) {
                    attacker.method_490(Formatting.RED + "You do not posses the powers to wield this hammer!");
                    return;
                }
            }

            @SuppressWarnings("deprecation")
            MinecraftServer server = (MinecraftServer) FabricLoader.getInstance().getGameInstance();

            var playerList = server.field_2842;
            playerList.method_561(attacked.name);
            attacked = playerList.method_586(attacked.name);
            if (attacked != null) {
                attacked.field_255.disconnect("The Ban Hammer has spoken");
            }
        }
    }
}
