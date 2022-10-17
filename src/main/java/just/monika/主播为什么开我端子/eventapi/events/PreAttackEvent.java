package just.monika.主播为什么开我端子.eventapi.events;

import just.monika.主播为什么开我端子.eventapi.Event;
import net.minecraft.entity.Entity;

public class PreAttackEvent extends Event
{
    public Entity attacked;
    
    public PreAttackEvent(Entity attacked)
    {
	this.attacked = attacked;
    }
    
}
