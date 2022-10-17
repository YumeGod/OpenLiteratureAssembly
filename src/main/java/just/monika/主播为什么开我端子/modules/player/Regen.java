/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.C03PacketPlayer
 */
package just.monika.主播为什么开我端子.modules.player;

import just.monika.主播为什么开我端子.eventapi.Event;
import just.monika.主播为什么开我端子.eventapi.EventTarget;
import just.monika.主播为什么开我端子.eventapi.events.UpdateEvent;
import just.monika.主播为什么开我端子.management.module.Mod;
import just.monika.主播为什么开我端子.management.module.Module;
import just.monika.主播为什么开我端子.management.value.Val;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;

@Mod
public class Regen
extends Module {
    @Val(min=0.0, max=10.0, increment=0.5)
    private double health = 8.0;
    @Val(min=0.0, max=3000.0, increment=50.0)
    private double packets = 450.0;

    @EventTarget
    private void onUpdate(UpdateEvent event) {
        if (event.state == Event.State.POST && (double)this.mc.thePlayer.getHealth() < this.health * 2.0 && this.mc.thePlayer.isCollidedVertically) {
            int i = 0;
            while ((double)i < this.packets) {
                this.mc.thePlayer.sendQueue.addToSendQueue((Packet)new C03PacketPlayer(true));
                ++i;
            }
        }
    }
}

