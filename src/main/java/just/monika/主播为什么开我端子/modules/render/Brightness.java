/*
 * Decompiled with CFR 0_114.
 */
package just.monika.主播为什么开我端子.modules.render;

import just.monika.主播为什么开我端子.eventapi.EventTarget;
import just.monika.主播为什么开我端子.eventapi.events.TickEvent;
import just.monika.主播为什么开我端子.management.module.Mod;
import just.monika.主播为什么开我端子.management.module.Module;

@Mod
public class Brightness
extends Module {
	
    @EventTarget
    private void onTick(TickEvent event) {
    	this.mc.gameSettings.gammaSetting = 100F;
    }

    @Override
    public void onDisable() {
        super.onDisable();
    	this.mc.gameSettings.gammaSetting = 0F;
    }
}

