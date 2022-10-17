package just.monika.主播为什么开我端子.eventapi.events;

import just.monika.主播为什么开我端子.eventapi.Event;
import net.minecraft.network.Packet;

public class PacketSendEvent extends Event
{
    public Packet packet;
    public State state;
    
    public PacketSendEvent(State state, Packet packet)
    {
	this.state = state;
	this.packet = packet;
    }
}
