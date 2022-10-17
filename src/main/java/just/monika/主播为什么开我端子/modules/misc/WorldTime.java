/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.server.S03PacketTimeUpdate
 */
package just.monika.主播为什么开我端子.modules.misc;

import just.monika.主播为什么开我端子.eventapi.EventTarget;
import just.monika.主播为什么开我端子.eventapi.events.PacketReceiveEvent;
import just.monika.主播为什么开我端子.eventapi.events.TickEvent;
import just.monika.主播为什么开我端子.management.module.Mod;
import just.monika.主播为什么开我端子.management.module.Module;
import just.monika.主播为什么开我端子.management.value.Val;
import net.minecraft.network.play.server.S03PacketTimeUpdate;

@Mod
public class WorldTime
extends Module {
    @Val(min=0.0, max=24000.0, increment=250.0)
    private double time = 9000.0;

    @EventTarget
    private void onPacketRecieve(PacketReceiveEvent event) {
        if (event.packet instanceof S03PacketTimeUpdate) {
            event.setCancelled(true);
        }
    }

    @EventTarget
    private void onTick(TickEvent event) {
        this.mc.theWorld.setWorldTime((long)this.time);
    }
}

