package just.monika.主播为什么开我端子.eventapi.events;

import just.monika.主播为什么开我端子.eventapi.Event;
import net.minecraft.block.Block;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;

public class BoundingBoxEvent extends Event
{
    public Block block;
    public BlockPos pos;
    public AxisAlignedBB boundingBox;
    
    public BoundingBoxEvent(Block block, BlockPos pos, AxisAlignedBB boundingBox)
    {
	this.block = block;
	this.pos = pos;
	this.boundingBox = boundingBox;
    }
}
