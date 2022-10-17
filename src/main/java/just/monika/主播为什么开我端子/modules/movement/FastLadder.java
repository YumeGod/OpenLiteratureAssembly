/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 */
package just.monika.主播为什么开我端子.modules.movement;

import just.monika.主播为什么开我端子.eventapi.EventTarget;
import just.monika.主播为什么开我端子.eventapi.events.MoveEvent;
import just.monika.主播为什么开我端子.management.module.Mod;
import just.monika.主播为什么开我端子.management.module.Module;

@Mod
public class FastLadder
extends Module {
    @EventTarget
    private void onMove(MoveEvent event) {
        if (event.y > 0.0 && this.mc.thePlayer.isOnLadder()) {
            event.y *= 2.4;
            //mc.thePlayer.setVelocity(0F, 0.32F, 0F);
        }
    }
}

