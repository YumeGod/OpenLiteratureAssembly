/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  org.lwjgl.input.Keyboard
 */
package just.monika.主播为什么开我端子.management.module;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import just.monika.主播为什么开我端子.management.option.Option;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

import just.monika.主播为什么开我端子.eventapi.EventManager;
import just.monika.主播为什么开我端子.management.option.OptionManager;
import just.monika.主播为什么开我端子.management.value.Value;
import just.monika.主播为什么开我端子.management.value.ValueManager;

public class Module {
    protected Minecraft mc = Minecraft.getMinecraft();
    private static final int MIN_HEX = -865847;
    private static final int MAX_HEX = -3542326;
    public String realName;
    public String name;
    public boolean enabled;
    public int keyBind;
    public boolean shown;
    public int color;
    public Category category;
    public String suffix;

    public void toggle() {
        if (this.enabled) {
            this.onDisable();
        } else {
            this.onEnable();
        }
        ModuleManager.save();
    }

    public void onEnable() {
        Random randomService = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append("0x");
        while (sb.length() < 10) {
            sb.append(Integer.toHexString(randomService.nextInt()));
        }
        sb.setLength(8);
        this.color = Integer.decode(sb.toString());
        this.enabled = true;
        EventManager.register(this);
    }

    public void onDisable() {
        this.enabled = false;
        EventManager.unregister(this);
    }

    public void preInit() {
    }

    public List<Option> getOptions() {
        ArrayList<Option> list = new ArrayList<Option>();
        for (Option option : OptionManager.optionList) {
            if (option.mod != this) continue;
            list.add(option);
        }
        return list;
    }

    private int getFadeHex(int hex1, int hex2, double ratio) {
        int r = hex1 >> 16;
        int g = hex1 >> 8 & 255;
        int b = hex1 & 255;
        r = (int)((double)r + (double)((hex2 >> 16) - r) * ratio);
        g = (int)((double)g + (double)((hex2 >> 8 & 255) - g) * ratio);
        b = (int)((double)b + (double)((hex2 & 255) - b) * ratio);
        return r << 16 | g << 8 | b;
    }

    public List<just.monika.主播为什么开我端子.ui.clickgui.Option> getConvertedOptions() {
        ArrayList<just.monika.主播为什么开我端子.ui.clickgui.Option> optionList = new ArrayList<just.monika.主播为什么开我端子.ui.clickgui.Option>();
        for (Option option : OptionManager.optionList) {
            if (!option.mod.equals(this)) continue;
            just.monika.主播为什么开我端子.ui.clickgui.Option boolOption = new just.monika.主播为什么开我端子.ui.clickgui.Option(this, just.monika.主播为什么开我端子.ui.clickgui.Option.Type.bool, option.name, option.value, new double[]{0.0, 0.0}, 0.0);
            optionList.add(boolOption);
        }
        for (Value value : ValueManager.valueList) {
            if (!value.mod.equals(this)) continue;
            just.monika.主播为什么开我端子.ui.clickgui.Option valOption = new just.monika.主播为什么开我端子.ui.clickgui.Option(this, just.monika.主播为什么开我端子.ui.clickgui.Option.Type.floa, value.name, Float.valueOf((float)value.value), new double[]{value.min, value.max}, value.increment);
            optionList.add(valOption);
        }
        String keyName = "None";
        if (this.keyBind > 0) {
            keyName = Keyboard.getKeyName((int)this.keyBind);
        }
        just.monika.主播为什么开我端子.ui.clickgui.Option bindOption = new just.monika.主播为什么开我端子.ui.clickgui.Option(this, just.monika.主播为什么开我端子.ui.clickgui.Option.Type.keyb, "Bind", keyName, new double[]{0.0, 0.0}, 0.0);
        optionList.add(bindOption);
        return optionList;
    }
}

