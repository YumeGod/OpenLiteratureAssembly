/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.C0APacketAnimation
 */
package just.monika.主播为什么开我端子.modules.misc;

import just.monika.主播为什么开我端子.eventapi.Event;
import just.monika.主播为什么开我端子.eventapi.EventTarget;
import just.monika.主播为什么开我端子.eventapi.events.UpdateEvent;
import just.monika.主播为什么开我端子.management.module.Mod;
import just.monika.主播为什么开我端子.management.module.Module;
import just.monika.主播为什么开我端子.management.option.Op;
import just.monika.主播为什么开我端子.management.value.Val;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C0APacketAnimation;

@Mod
public class Derp
extends Module {
    @Op
    private boolean spinny;
    @Op
    private boolean headless;
    @Val(min=1.0, max=50.0, increment=1.0)
    private double increment = 25.0;
    private double serverYaw;

    @EventTarget(value=0)
    private void onUpdate(UpdateEvent event) {
        if (event.state == Event.State.PRE) {
            if (this.spinny) {
                this.serverYaw += this.increment;
                event.yaw = (float)this.serverYaw;
            }
            if (this.headless) {
                event.pitch = 180.0f;
            }
            if (!this.headless && !this.spinny) {
                event.yaw = (float)(Math.random() * 360.0);
                event.pitch = (float)(Math.random() * 360.0);
                this.mc.thePlayer.sendQueue.addToSendQueue((Packet)new C0APacketAnimation());
            }
        }
    }
}

