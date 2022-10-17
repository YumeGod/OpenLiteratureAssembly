/*
 * Decompiled with CFR 0_114.
 *
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.server.S12PacketEntityVelocity
 */
package just.monika.主播为什么开我端子.modules.combat;

import just.monika.主播为什么开我端子.eventapi.EventTarget;
import just.monika.主播为什么开我端子.eventapi.events.PacketReceiveEvent;
import just.monika.主播为什么开我端子.eventapi.events.TickEvent;
import just.monika.主播为什么开我端子.management.module.Mod;
import just.monika.主播为什么开我端子.management.module.Module;
import just.monika.主播为什么开我端子.management.module.ModuleManager;
import just.monika.主播为什么开我端子.management.option.OptionManager;
import just.monika.主播为什么开我端子.management.value.Val;
import just.monika.主播为什么开我端子.modules.render.HUD;
import net.minecraft.network.play.server.S12PacketEntityVelocity;

@Mod
public class Velocity
extends Module {
    @Val(min=0.0, max=200.0, increment=5.0)
    private double percent = 0.0;

    @EventTarget
    private void onTick(TickEvent event) {
        Character colorFormatCharacter = new Character('\u00a7');
        this.suffix = OptionManager.getOption((String)"Hyphen", (Module) ModuleManager.getModule(HUD.class)).value ? colorFormatCharacter + "7 - " + this.percent + "%" : colorFormatCharacter + "7 " + this.percent + "%";
    }

    @EventTarget
    private void onPacketReceive(PacketReceiveEvent event) {
        S12PacketEntityVelocity packet;
        if (event.packet instanceof S12PacketEntityVelocity && this.mc.theWorld.getEntityByID((packet = (S12PacketEntityVelocity)event.packet).getEntityID()) == this.mc.thePlayer) {
            if (this.percent > 0.0) {
                packet.motionX = (int)((double)packet.motionX * (this.percent / 100.0));
                packet.motionY = (int)((double)packet.motionY * (this.percent / 100.0));
                packet.motionZ = (int)((double)packet.motionZ * (this.percent / 100.0));
            } else {
                event.setCancelled(true);
            }
        }
    }
}

