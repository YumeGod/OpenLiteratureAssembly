package just.monika.主播为什么开我端子.eventapi;

import java.lang.reflect.Method;

public class MethodData
{
    
    public final Object source;
    public final Method target;
    public final byte priority;
    
    MethodData(Object source, Method target, byte priority)
    {
	this.source = source;
	this.target = target;
	this.priority = priority;
    }
    
}
