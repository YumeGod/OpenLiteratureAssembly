/*
 * Decompiled with CFR 0_114.
 */
package just.monika.主播为什么开我端子.commands;

import just.monika.主播为什么开我端子.management.command.Com;
import just.monika.主播为什么开我端子.management.command.Command;
import just.monika.主播为什么开我端子.management.command.CommandManager;
import just.monika.主播为什么开我端子.util.ChatUtils;

@Com(names={"help", "?"})
public class Help
extends Command {
    @Override
    public void runCommand(String[] args) {
        ChatUtils.sendClientMessage("All Commands:");
        for (Command command : CommandManager.commandList) {
            if (command instanceof OptionCommand || command.getHelp() == null) continue;
            ChatUtils.sendMessage(command.getHelp());
        }
        ChatUtils.sendMessage(OptionCommand.getHelpString());
    }

    @Override
    public String getHelp() {
        return "Help - help <?> - Returns a list of commands and their information.";
    }
}

