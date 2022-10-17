/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockCactus
 *  net.minecraft.util.AxisAlignedBB
 *  net.minecraft.util.BlockPos
 */
package just.monika.主播为什么开我端子.modules.misc;

import just.monika.主播为什么开我端子.eventapi.EventTarget;
import just.monika.主播为什么开我端子.eventapi.events.BoundingBoxEvent;
import just.monika.主播为什么开我端子.management.module.Mod;
import just.monika.主播为什么开我端子.management.module.Module;
import net.minecraft.block.BlockCactus;
import net.minecraft.util.AxisAlignedBB;

@Mod
public class AntiCactus
extends Module {
    @EventTarget
    private void onBoundingBox(BoundingBoxEvent event) {
        if (event.block instanceof BlockCactus) {
            event.boundingBox = new AxisAlignedBB((double)event.pos.getX(), (double)event.pos.getY(), (double)event.pos.getZ(), (double)(event.pos.getX() + 1), (double)(event.pos.getY() + 1), (double)(event.pos.getZ() + 1));
        }
    }
}

