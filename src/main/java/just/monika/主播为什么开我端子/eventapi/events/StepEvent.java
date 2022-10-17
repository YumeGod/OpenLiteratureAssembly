package just.monika.主播为什么开我端子.eventapi.events;

import just.monika.主播为什么开我端子.eventapi.Event;

public class StepEvent extends Event
{
    public double stepHeight;
    public boolean bypass;
    
    public StepEvent(double stepHeight)
    {
	this.stepHeight = stepHeight;
    }
    
}
