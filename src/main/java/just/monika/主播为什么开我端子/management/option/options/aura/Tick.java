/*
 * Decompiled with CFR 0_114.
 */
package just.monika.主播为什么开我端子.management.option.options.aura;

import just.monika.主播为什么开我端子.management.module.Module;
import just.monika.主播为什么开我端子.management.option.Option;
import just.monika.主播为什么开我端子.management.option.OptionManager;

public class Tick
extends Option {
    public Tick(String name, boolean value, Module mod) {
        super(name, value, mod);
    }

    @Override
    public void setValue(boolean value) {
        if (value) {
            OptionManager.getOption("Boost", this.mod).setValueHard(false);
        } else {
            OptionManager.getOption("Boost", this.mod).setValueHard(true);
        }
        super.setValue(value);
    }
}

