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
 *  net.minecraft.util.MovementInput
 */
package just.monika.主播为什么开我端子.modules.movement;

import just.monika.主播为什么开我端子.eventapi.EventTarget;
import just.monika.主播为什么开我端子.eventapi.events.MoveEvent;
import just.monika.主播为什么开我端子.eventapi.events.StepConfirmEvent;
import just.monika.主播为什么开我端子.eventapi.events.StepEvent;
import just.monika.主播为什么开我端子.management.module.Mod;
import just.monika.主播为什么开我端子.management.module.Module;
import just.monika.主播为什么开我端子.management.module.ModuleManager;
import just.monika.主播为什么开我端子.management.value.Val;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;

@Mod
public class Step extends Module
{
    @Val(min = 1.0, max = 10.0, increment = 1.0)
    private double height;
    private int stepStage;
    public static boolean stepping;

    public Step() {
        this.height = 1.0;
    }

    @EventTarget
    private void onMove(final MoveEvent event) {
    }

    @EventTarget
    private void onStep(final StepEvent event) {
    	if (this.mc.thePlayer.movementInput != null && !Jesus.shouldOffsetPacket && !this.mc.thePlayer.movementInput.jump && this.mc.thePlayer.isCollidedVertically && ((ModuleManager.getModule(Speed.class).enabled && Speed.canStep) || !ModuleManager.getModule(Speed.class).enabled)) {
        	event.stepHeight = this.height;
    	}
        if (this.height <= 1.0) {
        	event.bypass = true;
        }
    }

    @EventTarget
    private void onStepConfirmed(final StepConfirmEvent event) {
        this.stepStage = 0;
        this.mc.thePlayer.sendQueue.addToSendQueue((Packet)new C03PacketPlayer.C04PacketPlayerPosition(this.mc.thePlayer.posX, this.mc.thePlayer.posY + 0.42, this.mc.thePlayer.posZ, this.mc.thePlayer.onGround));
        this.mc.thePlayer.sendQueue.addToSendQueue((Packet)new C03PacketPlayer.C04PacketPlayerPosition(this.mc.thePlayer.posX, this.mc.thePlayer.posY + 0.75, this.mc.thePlayer.posZ, this.mc.thePlayer.onGround));
    }

    @Override
    public void onDisable() {
        this.stepStage = 0;
        this.mc.thePlayer.stepHeight = 0.6f;
        super.onDisable();
    }
}
