/*
 * Decompiled with CFR 0_114.
 */
package just.monika.主播为什么开我端子.commands;

import just.monika.主播为什么开我端子.management.command.Com;
import just.monika.主播为什么开我端子.management.command.Command;
import just.monika.主播为什么开我端子.management.command.CommandManager;
import just.monika.主播为什么开我端子.util.ChatUtils;

@Com(names={""})
public class UnknownCommand
extends Command {
    @Override
    public void runCommand(String[] args) {
        ChatUtils.sendClientMessage("Unknown Command. Try " + CommandManager.commandPrefix + "help.");
    }
}

