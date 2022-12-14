/*
 * Decompiled with CFR 0_114.
 */
package just.monika.主播为什么开我端子.ui.clickgui;

import just.monika.主播为什么开我端子.management.module.Module;
import just.monika.主播为什么开我端子.management.option.OptionManager;
import just.monika.主播为什么开我端子.util.ColorUtil;

public class SlotOptionBoolean
extends Slot {
    public Option option;

    public SlotOptionBoolean(Interactable parent, Option option, float x, float y, float width, float height) {
        super(parent, x, y, width, height);
        this.option = option;
    }

    @Override
    public void update(int mouseX, int mouseY) {
        this.hover = this.mouseOver(mouseX, mouseY) && this.parent.hover;
        this.size.y = !this.extended ? 32.0f : 32.0f + this.slotList.size.y + 4.0f;
        this.slotList.pos = this.pos.offset(4.0f, 32.0f);
        this.slotList.size.x = this.size.x - 8.0f;
        this.slotList.update(mouseX, mouseY);
    }

    @Override
    public void mousePress(int mouseX, int mouseY, int button) {
        super.mousePress(mouseX, mouseY, button);
        if (this.active) {
            OptionManager.getOption(this.option.title, this.option.parent).toggle();
            this.option.value = OptionManager.getOption((String)this.option.title, (Module)this.option.parent).value;
        }
    }

    @Override
    public void mouseRelease(int mouseX, int mouseY, int button) {
        super.mouseRelease(mouseX, mouseY, button);
    }

    @Override
    public void mouseScroll(int amount) {
        super.mouseScroll(amount);
    }

    @Override
    public void keyPress(int key, int keyChar) {
        super.keyPress(key, keyChar);
    }

    @Override
    public void keyRelease(int key, int keyChar) {
        super.keyRelease(key, keyChar);
    }

    @Override
    public void render() {
        Draw.rectBordered(this.pos.x, this.pos.y, this.pos.x + this.size.x, this.pos.y + this.size.y, ColorUtil.blend(-13421773, -16777216, this.option.valBool() ? (this.hover ? 0.6f : 0.7f) : (this.hover ? 0.8f : 1.0f)), -15658735, 1.0f);
        Draw.rect(this.pos.x + 2.0f, this.pos.y + 1.0f, this.pos.x + this.size.x - 2.0f, this.pos.y + 2.0f, this.option.valBool() ? 536870912 : 553648127);
        Draw.string(this.option.title, this.pos.x + this.size.x / 2.0f, this.pos.y + 16.0f + (float)(this.option.valBool() ? 2 : 0), -1, 0, 0);
        super.render();
    }
}

