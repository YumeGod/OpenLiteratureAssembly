/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.properties.IProperty
 *  net.minecraft.block.properties.PropertyInteger
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.C03PacketPlayer
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.BlockPos
 */
package just.monika.主播为什么开我端子.modules.movement;

import just.monika.主播为什么开我端子.eventapi.Event;
import just.monika.主播为什么开我端子.eventapi.EventTarget;
import just.monika.主播为什么开我端子.eventapi.events.BoundingBoxEvent;
import just.monika.主播为什么开我端子.eventapi.events.PacketSendEvent;
import just.monika.主播为什么开我端子.eventapi.events.UpdateEvent;
import just.monika.主播为什么开我端子.management.module.Mod;
import just.monika.主播为什么开我端子.management.module.Module;
import just.monika.主播为什么开我端子.util.LiquidUtils;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.util.AxisAlignedBB;

@Mod
public class Jesus
extends Module {
    public static boolean shouldOffsetPacket;

    @EventTarget
    private void onUpdate(UpdateEvent event) {
        if (event.state == Event.State.PRE) {
            if (LiquidUtils.isInLiquid() && this.mc.thePlayer.isInsideOfMaterial(Material.air) && !this.mc.thePlayer.isSneaking()) {
                this.mc.thePlayer.motionY = 0.085;
            }
            if (!LiquidUtils.isOnLiquid() || LiquidUtils.isInLiquid() || !this.shouldSetBoundingBox()) {
                shouldOffsetPacket = false;
            }
        }
    }

    @EventTarget
    private void onBoundingBox(BoundingBoxEvent event) {
        if (!LiquidUtils.isInLiquid() && event.block instanceof BlockLiquid && this.mc.theWorld.getBlockState(event.pos).getBlock() instanceof BlockLiquid && (Integer)this.mc.theWorld.getBlockState(event.pos).getValue((IProperty)BlockLiquid.LEVEL) == 0 && this.shouldSetBoundingBox() && (double)(event.pos.getY() + 1) <= this.mc.thePlayer.boundingBox.minY) {
            event.boundingBox = new AxisAlignedBB((double)event.pos.getX(), (double)event.pos.getY(), (double)event.pos.getZ(), (double)(event.pos.getX() + 1), (double)(event.pos.getY() + 1), (double)(event.pos.getZ() + 1));
        }
    }

    @EventTarget
    private void onPacketSend(PacketSendEvent event) {
        if (event.state == Event.State.PRE && event.packet instanceof C03PacketPlayer && LiquidUtils.isOnLiquid()) {
            C03PacketPlayer packet = (C03PacketPlayer)event.packet;
            boolean bl = Jesus.shouldOffsetPacket = !shouldOffsetPacket;
            if (shouldOffsetPacket) {
                packet.y -= 1.0E-6;
            }
        }
    }

    private boolean shouldSetBoundingBox() {
        if (!this.mc.thePlayer.isSneaking() && this.mc.thePlayer.fallDistance < 4.0f) {
            return true;
        }
        return false;
    }

    @Override
    public void onDisable() {
        shouldOffsetPacket = false;
        super.onDisable();
    }
}

