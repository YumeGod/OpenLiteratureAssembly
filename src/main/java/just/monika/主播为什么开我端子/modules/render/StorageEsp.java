package just.monika.主播为什么开我端子.modules.render;

import java.awt.Color;

import just.monika.主播为什么开我端子.eventapi.EventTarget;
import just.monika.主播为什么开我端子.eventapi.events.Render3DEvent;
import just.monika.主播为什么开我端子.management.module.Mod;
import just.monika.主播为什么开我端子.management.module.Module;
import just.monika.主播为什么开我端子.management.option.Op;
import just.monika.主播为什么开我端子.util.RenderUtils;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.util.AxisAlignedBB;

@Mod
public class StorageEsp extends Module
{
    @Op
    public static boolean chest;
    @Op
    public static boolean dispenser;
    @Op
    public static boolean enderChest;

    static {
        StorageEsp.chest = true;
    }

    @EventTarget
    private void onRender(final Render3DEvent event) {
        GlStateManager.pushMatrix();
        for (final Object o : this.mc.theWorld.loadedTileEntityList) {
        	final TileEntity ent = (TileEntity)o;
            if (!(ent instanceof TileEntityChest) && !(ent instanceof TileEntityDispenser) && !(ent instanceof TileEntityEnderChest)) {
                continue;
            }
            if (ent instanceof TileEntityChest && !StorageEsp.chest) {
                continue;
            }
            if (ent instanceof TileEntityDispenser && !StorageEsp.dispenser) {
                continue;
            }
            if (ent instanceof TileEntityEnderChest && !StorageEsp.enderChest) {
                continue;
            }
            this.drawEsp(ent, event.partialTicks);
        }
        GlStateManager.popMatrix();
    }

    private void drawEsp(final TileEntity ent, final float pTicks) {
        final double x1 = ent.getPos().getX() - RenderManager.renderPosX;
        final double y1 = ent.getPos().getY() - RenderManager.renderPosY;
        final double z1 = ent.getPos().getZ() - RenderManager.renderPosZ;
        final float[] color = this.getColor(ent);
        AxisAlignedBB box = new AxisAlignedBB(x1, y1, z1, x1 + 1.0, y1 + 1.0, z1 + 1.0);
        if (ent instanceof TileEntityChest) {
            final TileEntityChest chest = TileEntityChest.class.cast(ent);
            if (chest.adjacentChestZPos != null) {
                box = new AxisAlignedBB(x1 + 0.0625, y1, z1 + 0.0625, x1 + 0.9375, y1 + 0.875, z1 + 1.9375);
            }
            else if (chest.adjacentChestXPos != null) {
                box = new AxisAlignedBB(x1 + 0.0625, y1, z1 + 0.0625, x1 + 1.9375, y1 + 0.875, z1 + 0.9375);
            }
            else {
                if (chest.adjacentChestZPos != null || chest.adjacentChestXPos != null || chest.adjacentChestZNeg != null || chest.adjacentChestXNeg != null) {
                    return;
                }
                box = new AxisAlignedBB(x1 + 0.0625, y1, z1 + 0.0625, x1 + 0.9375, y1 + 0.875, z1 + 0.9375);
            }
        }
        else if (ent instanceof TileEntityEnderChest) {
            box = new AxisAlignedBB(x1 + 0.0625, y1, z1 + 0.0625, x1 + 0.9375, y1 + 0.875, z1 + 0.9375);
        }
        RenderUtils.filledBox(box, new Color(color[0], color[1], color[2]).getRGB() & 0x19FFFFFF, true);
        RenderUtils.drawOutlinedBoundingBox(box, new Color(color[0], color[1], color[2]).getRGB());
    }

    private float[] getColor(final TileEntity ent) {
        if (ent instanceof TileEntityChest) {
            return new float[] { 0.0f, 0.9f, 0.9f };
        }
        if (ent instanceof TileEntityDispenser) {
            return new float[] { 0.29f, 0.29f, 0.29f };
        }
        if (ent instanceof TileEntityEnderChest) {
            return new float[] { 0.3f, 0.0f, 0.3f };
        }
        return new float[] { 1.0f, 1.0f, 1.0f };
    }
}
