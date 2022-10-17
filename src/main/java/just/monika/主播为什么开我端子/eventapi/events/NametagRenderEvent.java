package just.monika.主播为什么开我端子.eventapi.events;

import just.monika.主播为什么开我端子.eventapi.Event;
import net.minecraft.entity.Entity;

public class NametagRenderEvent extends Event
{
    public Entity entity;
    public String string;
    public double x, y, z;
    
    public NametagRenderEvent(Entity entity, String string, double x, double y, double z)
    {
	this.entity = entity;
	this.string = string;
	this.x = x;
	this.y = y;
	this.z = z;
    }
}
