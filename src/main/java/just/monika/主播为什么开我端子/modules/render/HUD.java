/*
 * Decompiled with CFR 0_114.
 */
package just.monika.主播为什么开我端子.modules.render;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import just.monika.主播为什么开我端子.Client;
import just.monika.主播为什么开我端子.eventapi.EventTarget;
import just.monika.主播为什么开我端子.eventapi.events.KeyboardEvent;
import just.monika.主播为什么开我端子.eventapi.events.Render2DEvent;
import just.monika.主播为什么开我端子.management.module.Mod;
import just.monika.主播为什么开我端子.management.module.Module;
import just.monika.主播为什么开我端子.management.module.ModuleManager;
import just.monika.主播为什么开我端子.management.option.Op;
import just.monika.主播为什么开我端子.management.value.Val;
import just.monika.主播为什么开我端子.ui.TabGui;

@Mod(shown = false, enabled = true)
public class HUD extends Module
{
    @Val(min = 10.0, max = 200.0, increment = 10.0)
    public static double transitionDelay;
    @Op
    private boolean hyphen;
    public static int color;
    
    static {
        HUD.transitionDelay = 50.0;
        HUD.color = -9764816;
    }
    
    public HUD() {
        this.hyphen = true;
    }
    
    @Override
    public void onEnable() {
        TabGui.init();
        super.onEnable();
    }
    
    @EventTarget
    private void onKeypress(final KeyboardEvent event) {
        TabGui.keyPress(event.key);
    }
    
    @EventTarget(4)
    private void onRender2D(final Render2DEvent event) {
        Client.font.drawStringWithShadow(Client.NAME, 3.0f, 3.0f, -1);
        Client.font.drawStringWithShadow(Client.VERSION + "", 2 + Client.font.getStringWidth(Client.NAME) + 4, 3.0f, HUD.color);
        int yPos = 2;
        for (final Module module : getSortedModuleArray()) {
            final String name = String.valueOf(module.name) + module.suffix;
            Client.font.drawStringWithShadow(name, event.width - Client.font.getStringWidth(name) - 2, yPos, module.color);
            yPos += 10;
        }
        TabGui.render();
    }
    
    private static List<Module> getSortedModuleArray() {
        final List<Module> list = new ArrayList<Module>();
        for (final Module mod : ModuleManager.moduleList) {
            if (mod.enabled) {
                if (!mod.shown) {
                    continue;
                }
                list.add(mod);
            }
        }
        list.sort(new Comparator<Module>() {
            @Override
            public int compare(final Module m1, final Module m2) {
                final String s1 = String.valueOf(m1.name) + ((m1.suffix == null) ? "" : m1.suffix);
                final String s2 = String.valueOf(m2.name) + ((m2.suffix == null) ? "" : m2.suffix);
                final int cmp = Client.font.getStringWidth(s2) - Client.font.getStringWidth(s1);
                return (cmp != 0) ? cmp : s2.compareTo(s1);
            }
        });
        return list;
    }
}
