package just.monika.主播为什么开我端子.eventapi.events;

import just.monika.主播为什么开我端子.eventapi.Event;

public class UpdateEvent extends Event
{
    public State state;
    public float yaw, pitch;
    public double y;
    public boolean ground;

    public UpdateEvent()
    {
	this.state = State.POST;
    }

    public UpdateEvent(double y, float yaw, float pitch, boolean ground)
    {
	this.state = State.PRE;
	this.yaw = yaw;
	this.pitch = pitch;
	this.y = y;
	this.ground = ground;
    }
}