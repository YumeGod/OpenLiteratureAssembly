/*
 * Decompiled with CFR 0_114.
 */
package just.monika.主播为什么开我端子.management.option.options.speed;

import just.monika.主播为什么开我端子.management.module.Module;
import just.monika.主播为什么开我端子.management.option.Option;
import just.monika.主播为什么开我端子.management.option.OptionManager;

public class Basic
extends SpeedOption {
    public Basic(String name, boolean value, Module mod) {
        super(name, value, mod);
    }

    @Override
    public void setValue(boolean value) {
        if (value) {
            for (Option option : OptionManager.optionList) {
                if (!(option instanceof SpeedOption) || option == this) continue;
                option.setValueHard(false);
            }
            super.setValue(value);
        }
    }
}

