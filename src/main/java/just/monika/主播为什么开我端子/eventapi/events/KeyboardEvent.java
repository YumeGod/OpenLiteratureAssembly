package just.monika.主播为什么开我端子.eventapi.events;

import just.monika.主播为什么开我端子.eventapi.Event;

public class KeyboardEvent extends Event
{
    public int key;
    
    public KeyboardEvent(int key)
    {
	this.key = key;
    }
}
