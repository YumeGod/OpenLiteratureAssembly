/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  io.netty.util.concurrent.GenericFutureListener
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.NetworkManager
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.C07PacketPlayerDigging
 *  net.minecraft.network.play.client.C07PacketPlayerDigging$Action
 *  net.minecraft.network.play.client.C08PacketPlayerBlockPlacement
 *  net.minecraft.util.BlockPos
 *  net.minecraft.util.EnumFacing
 */
package just.monika.主播为什么开我端子.modules.movement;

import just.monika.主播为什么开我端子.eventapi.Event;
import just.monika.主播为什么开我端子.eventapi.EventTarget;
import just.monika.主播为什么开我端子.eventapi.events.ItemSpeedEvent;
import just.monika.主播为什么开我端子.eventapi.events.UpdateEvent;
import just.monika.主播为什么开我端子.management.module.Mod;
import just.monika.主播为什么开我端子.management.module.Module;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

@Mod
public class NoSlowdown
extends Module {
    @EventTarget
    private void onItemUse(ItemSpeedEvent event) {
        event.setCancelled(true);
    }

    @EventTarget(value=4)
    private void onUpdate(UpdateEvent event) {
        if (this.mc.thePlayer.isBlocking() && (this.mc.thePlayer.motionX != 0.0 || this.mc.thePlayer.motionZ != 0.0)) {
            if (event.state == Event.State.PRE) {
                this.mc.getNetHandler().getNetworkManager().dispatchPacket((Packet)new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, EnumFacing.DOWN), null);
            } else if (event.state == Event.State.POST) {
                this.mc.thePlayer.sendQueue.addToSendQueue((Packet)new C08PacketPlayerBlockPlacement(this.mc.thePlayer.inventory.getCurrentItem()));
            }
        }
    }
}

