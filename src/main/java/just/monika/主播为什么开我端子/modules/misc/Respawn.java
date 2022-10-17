/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 */
package just.monika.主播为什么开我端子.modules.misc;

import just.monika.主播为什么开我端子.eventapi.EventTarget;
import just.monika.主播为什么开我端子.eventapi.events.TickEvent;
import just.monika.主播为什么开我端子.management.module.Mod;
import just.monika.主播为什么开我端子.management.module.Module;

@Mod
public class Respawn
extends Module {
    @EventTarget
    private void onTick(TickEvent event) {
        if (!this.mc.thePlayer.isEntityAlive()) {
            this.mc.thePlayer.respawnPlayer();
        }
    }
}

