/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.GuiScreen
 */
package just.monika.主播为什么开我端子.modules.render;

import just.monika.主播为什么开我端子.management.module.Mod;
import just.monika.主播为什么开我端子.management.module.Module;
import just.monika.主播为什么开我端子.management.option.Op;
import just.monika.主播为什么开我端子.ui.click.ClickGui;
import just.monika.主播为什么开我端子.ui.clickgui.Gui;
import just.monika.主播为什么开我端子.ui.clickgui.GuiGrabber;
import net.minecraft.client.gui.GuiScreen;

@Mod(keybind=54)
public class GUI
extends Module {
    @Op
    private boolean panel;

    @Override
    public void onEnable() {
        if (this.panel) {
            this.mc.displayGuiScreen((GuiScreen)new ClickGui());
        } else {
            Gui.instance.reloadOptions();
            this.mc.displayGuiScreen((GuiScreen)new GuiGrabber());
        }
    }
}

