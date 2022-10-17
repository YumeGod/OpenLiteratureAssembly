package just.monika.主播为什么开我端子.eventapi.events;

import just.monika.主播为什么开我端子.eventapi.Event;

public class Render3DEvent extends Event
{
    public float partialTicks;
    
    public Render3DEvent(float partialTicks)
    {
	this.partialTicks = partialTicks;
    }
}
