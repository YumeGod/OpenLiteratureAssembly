/*
 * Decompiled with CFR 0_114.
 *
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 */
package just.monika.主播为什么开我端子.modules.player;

import just.monika.主播为什么开我端子.eventapi.EventTarget;
import just.monika.主播为什么开我端子.eventapi.events.UpdateEvent;
import just.monika.主播为什么开我端子.management.module.Mod;
import just.monika.主播为什么开我端子.management.module.Module;

@Mod
public class FastPlace
extends Module {
    @EventTarget
    private void onUpdate(UpdateEvent event) {
        this.mc.rightClickDelayTimer = 0;
    }
}

