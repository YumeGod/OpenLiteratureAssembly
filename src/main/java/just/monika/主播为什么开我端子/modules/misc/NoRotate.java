/*
 * Decompiled with CFR 0_114.
 *
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.server.S08PacketPlayerPosLook
 */
package just.monika.主播为什么开我端子.modules.misc;

import just.monika.主播为什么开我端子.eventapi.EventTarget;
import just.monika.主播为什么开我端子.eventapi.events.PacketReceiveEvent;
import just.monika.主播为什么开我端子.management.module.Mod;
import just.monika.主播为什么开我端子.management.module.Module;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;

@Mod
public class NoRotate
extends Module {
    @EventTarget
    private void onPacketReceive(PacketReceiveEvent event) {
        if (event.packet instanceof S08PacketPlayerPosLook) {
            S08PacketPlayerPosLook packet = (S08PacketPlayerPosLook)event.packet;
            packet.yaw = this.mc.thePlayer.rotationYaw;
            packet.pitch = this.mc.thePlayer.rotationPitch;
        }
    }
}

