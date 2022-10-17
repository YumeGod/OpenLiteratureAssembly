/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemFirework
 *  net.minecraft.item.ItemRedstone
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.C08PacketPlayerBlockPlacement
 *  net.minecraft.network.play.client.C09PacketHeldItemChange
 */
package just.monika.主播为什么开我端子.modules.minigame;

import just.monika.主播为什么开我端子.eventapi.EventTarget;
import just.monika.主播为什么开我端子.eventapi.events.TickEvent;
import just.monika.主播为什么开我端子.management.module.Mod;
import just.monika.主播为什么开我端子.management.module.Module;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFirework;
import net.minecraft.item.ItemRedstone;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C09PacketHeldItemChange;

@Mod
public class AutoTaunt
extends Module {
    @EventTarget
    private void onTick(TickEvent event) {
        int i = 0;
        while (i < 8) {
            Item item;
            if (this.mc.thePlayer.inventory.mainInventory[i] != null && ((item = this.mc.thePlayer.inventory.mainInventory[i].getItem()) instanceof ItemRedstone || Item.getIdFromItem((Item)item) == 353 || item instanceof ItemFirework)) {
                this.mc.thePlayer.sendQueue.addToSendQueue((Packet)new C09PacketHeldItemChange(i));
                this.mc.thePlayer.sendQueue.addToSendQueue((Packet)new C08PacketPlayerBlockPlacement(this.mc.thePlayer.inventory.mainInventory[i]));
                this.mc.thePlayer.sendQueue.addToSendQueue((Packet)new C09PacketHeldItemChange(this.mc.thePlayer.inventory.currentItem));
            }
            ++i;
        }
    }
}

