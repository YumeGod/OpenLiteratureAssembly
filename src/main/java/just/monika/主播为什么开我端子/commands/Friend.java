/*
 * Decompiled with CFR 0_114.
 */
package just.monika.主播为什么开我端子.commands;

import just.monika.主播为什么开我端子.management.command.Com;
import just.monika.主播为什么开我端子.management.command.Command;
import just.monika.主播为什么开我端子.management.friend.FriendManager;
import just.monika.主播为什么开我端子.util.ChatUtils;

@Com(names={"friend", "f"})
public class Friend
extends Command {
    @Override
    public void runCommand(String[] args) {
        if (args.length < 3) {
            ChatUtils.sendClientMessage(this.getHelp());
            return;
        }
        if (args[1].equalsIgnoreCase("add") || args[1].equalsIgnoreCase("a")) {
            String alias = args[2];
            if (args.length > 3) {
                alias = args[3];
            }
            if (FriendManager.isFriend(args[2]) && args.length < 3) {
                ChatUtils.sendClientMessage(String.valueOf(args[2]) + " is already friended.");
                return;
            }
            FriendManager.removeFriend(args[2]);
            FriendManager.addFriend(args[2], alias);
            ChatUtils.sendClientMessage("Friend Added: " + args[2] + (args.length > 3 ? new StringBuilder(" as ").append(alias).toString() : ""));
        } else if (args[1].equalsIgnoreCase("del") || args[1].equalsIgnoreCase("d")) {
            if (FriendManager.isFriend(args[2])) {
                FriendManager.removeFriend(args[2]);
                ChatUtils.sendClientMessage("Friend Removed: " + args[2]);
            } else {
                ChatUtils.sendClientMessage(String.valueOf(args[2]) + " is not friended.");
            }
        } else {
            ChatUtils.sendClientMessage(this.getHelp());
        }
    }

    @Override
    public String getHelp() {
        return "Friend - friend <f>  (add <a> | del <d>) (name) [alias].";
    }
}

