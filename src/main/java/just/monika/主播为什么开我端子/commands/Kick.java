/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.C03PacketPlayer
 *  net.minecraft.network.play.client.C03PacketPlayer$C05PacketPlayerLook
 */
package just.monika.主播为什么开我端子.commands;

import just.monika.主播为什么开我端子.management.command.Com;
import just.monika.主播为什么开我端子.management.command.Command;
import net.minecraft.client.Minecraft;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;

@Com(names={"kick", "k"})
public class Kick
extends Command {
    @Override
    public void runCommand(String[] args) {
        Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue((Packet)new C03PacketPlayer.C05PacketPlayerLook(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, false));
    }

    @Override
    public String getHelp() {
        return "Kick - kick <k> - Kicks you from the server.";
    }
}

