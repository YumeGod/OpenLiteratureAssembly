/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Keyboard
 */
package just.monika.主播为什么开我端子.commands;

import just.monika.主播为什么开我端子.management.module.Module;
import just.monika.主播为什么开我端子.management.module.ModuleManager;
import org.lwjgl.input.Keyboard;

import just.monika.主播为什么开我端子.management.command.Com;
import just.monika.主播为什么开我端子.management.command.Command;
import just.monika.主播为什么开我端子.util.ChatUtils;

@Com(names={"bind", "b"})
public class Bind
extends Command {
    @Override
    public void runCommand(String[] args) {
        String modName = "";
        String keyName = "";
        if (args.length > 1) {
            modName = args[1];
            if (args.length > 2) {
                keyName = args[2];
            }
        }
        Module module = ModuleManager.getModule(modName);
        if (module.name.equalsIgnoreCase("null")) {
            ChatUtils.sendClientMessage("Invalid Module.");
            return;
        }
        if (keyName == "") {
            ChatUtils.sendClientMessage(String.valueOf(module.name) + "'s bind has been cleared.");
            module.keyBind = 0;
            ModuleManager.save();
            return;
        }
        module.keyBind = Keyboard.getKeyIndex((String)keyName.toUpperCase());
        ModuleManager.save();
        if (Keyboard.getKeyIndex((String)keyName.toUpperCase()) == 0) {
            ChatUtils.sendClientMessage("Invalid Key entered, Bind cleared.");
        } else {
            ChatUtils.sendClientMessage(String.valueOf(module.name) + " bound to " + keyName);
        }
    }

    @Override
    public String getHelp() {
        return "Bind - bind <b> (module) (key) - Bind the specified module to a key.";
    }
}

