package just.monika.主播为什么开我端子.eventapi.events;

import just.monika.主播为什么开我端子.eventapi.Event;

public class UseItemEvent extends Event
{
    public State state;
    
    public UseItemEvent(State state)
    {
	this.state = state;
    }
}
