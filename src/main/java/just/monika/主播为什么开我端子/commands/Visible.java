/*
 * Decompiled with CFR 0_114.
 */
package just.monika.主播为什么开我端子.commands;

import just.monika.主播为什么开我端子.management.command.Com;
import just.monika.主播为什么开我端子.management.command.Command;
import just.monika.主播为什么开我端子.management.module.Module;
import just.monika.主播为什么开我端子.management.module.ModuleManager;
import just.monika.主播为什么开我端子.util.ChatUtils;

@Com(names={"visible", "v", "show"})
public class Visible
extends Command {
    @Override
    public void runCommand(String[] args) {
        String modName = "";
        if (args.length > 1) {
            modName = args[1];
        }
        Module module = ModuleManager.getModule(modName);
        if (module.name.equalsIgnoreCase("null")) {
            ChatUtils.sendClientMessage("Invalid Module.");
            return;
        }
        module.shown = !module.shown;
        ChatUtils.sendClientMessage(String.valueOf(module.name) + " is now " + (module.enabled ? "shown" : "hidden"));
    }

    @Override
    public String getHelp() {
        return "Visible - visible <v, show> (module) - Shows or hides the module on the arraylist.";
    }
}

