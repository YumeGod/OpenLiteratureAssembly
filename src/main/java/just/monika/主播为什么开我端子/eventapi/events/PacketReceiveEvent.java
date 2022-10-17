package just.monika.主播为什么开我端子.eventapi.events;

import just.monika.主播为什么开我端子.eventapi.Event;
import net.minecraft.network.Packet;

public class PacketReceiveEvent extends Event
{
    public Packet packet;
    
    public PacketReceiveEvent(Packet packet)
    {
	this.packet = packet;
    }
}
