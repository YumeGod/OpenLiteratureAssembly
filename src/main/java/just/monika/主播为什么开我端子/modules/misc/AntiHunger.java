/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.C03PacketPlayer
 */
package just.monika.主播为什么开我端子.modules.misc;

import just.monika.主播为什么开我端子.eventapi.EventTarget;
import just.monika.主播为什么开我端子.eventapi.events.PacketSendEvent;
import just.monika.主播为什么开我端子.management.module.Module;
import net.minecraft.network.play.client.C03PacketPlayer;

public class AntiHunger
extends Module {
    @EventTarget
    private void onPacketSend(PacketSendEvent event) {
        if (event.packet instanceof C03PacketPlayer) {
            C03PacketPlayer packet = (C03PacketPlayer)event.packet;
            packet.onGround = false;
        }
    }
}

