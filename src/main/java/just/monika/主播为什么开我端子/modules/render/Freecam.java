package just.monika.主播为什么开我端子.modules.render;

import client.eventapi.*;
import client.eventapi.events.*;
import client.management.module.*;
import just.monika.主播为什么开我端子.eventapi.Event;
import just.monika.主播为什么开我端子.eventapi.EventTarget;
import just.monika.主播为什么开我端子.eventapi.events.BoundingBoxEvent;
import just.monika.主播为什么开我端子.eventapi.events.UpdateEvent;
import just.monika.主播为什么开我端子.management.module.Mod;
import just.monika.主播为什么开我端子.management.module.Module;
import net.minecraft.client.entity.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;

@Mod
public class Freecam extends Module
{
    private EntityOtherPlayerMP playerCopy;
    private double startX;
    private double startY;
    private double startZ;
    private float startYaw;
    private float startPitch;
    
    @Override
    public void onEnable() {
        if (this.mc.thePlayer != null) {
            this.mc.thePlayer.noClip = true;
            this.startX = this.mc.thePlayer.posX;
            this.startY = this.mc.thePlayer.posY;
            this.startZ = this.mc.thePlayer.posZ;
            this.startYaw = this.mc.thePlayer.rotationYaw;
            this.startPitch = this.mc.thePlayer.rotationPitch;
            this.playerCopy = new EntityOtherPlayerMP((World)this.mc.theWorld, this.mc.thePlayer.getGameProfile());
            this.playerCopy.inventory = this.mc.thePlayer.inventory;
            this.playerCopy.inventoryContainer = this.mc.thePlayer.inventoryContainer;
            this.playerCopy.setPositionAndRotation(this.startX, this.startY, this.startZ, this.startYaw, this.startPitch);
            this.playerCopy.rotationYawHead = this.mc.thePlayer.rotationYawHead;
            this.mc.theWorld.addEntityToWorld(-1, (Entity)this.playerCopy);
        }
        super.onEnable();
    }
    
    @EventTarget
    private void onPreUpdate(final UpdateEvent event) {
        if (event.state == Event.State.PRE) {
            event.setCancelled(this.mc.thePlayer.capabilities.isFlying = true);
        }
    }
    
    @EventTarget
    private void onBoundingBox(final BoundingBoxEvent event) {
        event.boundingBox = null;
    }
    
    @Override
    public void onDisable() {
        this.mc.thePlayer.setPositionAndRotation(this.startX, this.startY, this.startZ, this.startYaw, this.startPitch);
        this.mc.thePlayer.noClip = false;
        this.mc.theWorld.removeEntityFromWorld(-1);
        this.mc.thePlayer.capabilities.isFlying = false;
        super.onDisable();
    }
}
