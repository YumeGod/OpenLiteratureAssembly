package just.monika.主播为什么开我端子.eventapi.events;

import just.monika.主播为什么开我端子.eventapi.Event;

public class MoveEvent extends Event
{
    public double x, y, z;
    
    public MoveEvent(double x, double y, double z)
    {
	this.x = x;
	this.y = y;
	this.z = z;
    }
}
