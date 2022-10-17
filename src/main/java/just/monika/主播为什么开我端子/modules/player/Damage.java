/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.C03PacketPlayer
 *  net.minecraft.network.play.client.C03PacketPlayer$C04PacketPlayerPosition
 */
package just.monika.主播为什么开我端子.modules.player;

import just.monika.主播为什么开我端子.management.module.Mod;
import just.monika.主播为什么开我端子.management.module.Module;
import just.monika.主播为什么开我端子.management.value.Val;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;

@Mod
public class Damage
extends Module {
    @Val(increment=0.5, min=0.5)
    private double damage = 0.5;

    @Override
    public void onEnable() {
        if (this.mc.thePlayer != null) {
            int i = 0;
            while ((double)i < 80.0 + 40.0 * (this.damage - 0.5)) {
                this.mc.thePlayer.sendQueue.addToSendQueue((Packet)new C03PacketPlayer.C04PacketPlayerPosition(this.mc.thePlayer.posX, this.mc.thePlayer.posY + 0.1D, this.mc.thePlayer.posZ, false));
                this.mc.thePlayer.sendQueue.addToSendQueue((Packet)new C03PacketPlayer.C04PacketPlayerPosition(this.mc.thePlayer.posX, this.mc.thePlayer.posY, this.mc.thePlayer.posZ, false));
                ++i;
            }
            this.mc.thePlayer.sendQueue.addToSendQueue((Packet)new C03PacketPlayer.C04PacketPlayerPosition(this.mc.thePlayer.posX, this.mc.thePlayer.posY, this.mc.thePlayer.posZ, true));
        }
    }
}

