/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.server.S2DPacketOpenWindow
 */
package just.monika.主播为什么开我端子.modules.misc;

import just.monika.主播为什么开我端子.eventapi.EventTarget;
import just.monika.主播为什么开我端子.eventapi.events.PacketReceiveEvent;
import just.monika.主播为什么开我端子.management.module.Mod;
import just.monika.主播为什么开我端子.management.module.Module;
import net.minecraft.network.play.server.S2DPacketOpenWindow;

@Mod(name="Inventory+")
public class InventoryPlus
extends Module {
    public static boolean shouldCancel = true;

    @EventTarget
    private void onPacketSend(PacketReceiveEvent event) {
        if (event.packet instanceof S2DPacketOpenWindow) {
            shouldCancel = false;
            this.mc.thePlayer.closeScreen();
            shouldCancel = true;
        }
    }

    public static boolean cancelClose() {
        return false;
    }
}

