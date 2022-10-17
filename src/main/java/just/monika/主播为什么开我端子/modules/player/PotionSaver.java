/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 */
package just.monika.主播为什么开我端子.modules.player;

import just.monika.主播为什么开我端子.eventapi.Event;
import just.monika.主播为什么开我端子.eventapi.EventTarget;
import just.monika.主播为什么开我端子.eventapi.events.PotionDeincrementEvent;
import just.monika.主播为什么开我端子.eventapi.events.UpdateEvent;
import just.monika.主播为什么开我端子.management.module.Mod;
import just.monika.主播为什么开我端子.management.module.Module;

@Mod
public class PotionSaver
extends Module {
    @EventTarget
    private void onUpdate(UpdateEvent event) {
        if (event.state == Event.State.PRE && this.mc.thePlayer.motionX == 0.0 && this.mc.thePlayer.motionZ == 0.0 && this.mc.thePlayer.isCollidedVertically) {
            event.setCancelled(true);
        }
    }

    @EventTarget
    private void onPotionDeincrement(PotionDeincrementEvent event) {
        if (this.mc.thePlayer.motionX == 0.0 && this.mc.thePlayer.motionZ == 0.0 && this.mc.thePlayer.isCollidedVertically) {
            event.setCancelled(true);
        }
    }
}

