/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.C01PacketChatMessage
 */
package just.monika.主播为什么开我端子.modules.misc;

import just.monika.主播为什么开我端子.eventapi.EventTarget;
import just.monika.主播为什么开我端子.eventapi.events.PacketSendEvent;
import just.monika.主播为什么开我端子.management.command.Command;
import just.monika.主播为什么开我端子.management.command.CommandManager;
import just.monika.主播为什么开我端子.management.module.Mod;
import just.monika.主播为什么开我端子.management.module.Module;
import net.minecraft.network.play.client.C01PacketChatMessage;

@Mod(enabled = true, shown = false)
public class Commands extends Module
{
    @EventTarget
    private void onPacketSend(final PacketSendEvent event) {
        if (event.packet instanceof C01PacketChatMessage) {
            final C01PacketChatMessage packet = (C01PacketChatMessage)event.packet;
            final String message = packet.getMessage();
            if (message.startsWith(CommandManager.commandPrefix)) {
                event.setCancelled(true);
                final String[] args = message.split(" ");
                final Command commandFromMessage = CommandManager.getCommandFromMessage(message);
                commandFromMessage.runCommand(args);
            }
        }
    }
}

