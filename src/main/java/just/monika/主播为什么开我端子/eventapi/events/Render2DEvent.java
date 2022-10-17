package just.monika.主播为什么开我端子.eventapi.events;

import just.monika.主播为什么开我端子.eventapi.Event;

public class Render2DEvent extends Event
{
    public int width;
    public int height;
    
    public Render2DEvent(int width, int height)
    {
	this.width = width;
	this.height = height;
    }
}
