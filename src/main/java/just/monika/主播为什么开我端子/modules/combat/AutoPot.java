/*
 * Decompiled with CFR 0_114.
 *
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.multiplayer.PlayerControllerMP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.inventory.Container
 *  net.minecraft.inventory.Slot
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemPotion
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.C03PacketPlayer
 *  net.minecraft.network.play.client.C03PacketPlayer$C04PacketPlayerPosition
 *  net.minecraft.network.play.client.C08PacketPlayerBlockPlacement
 *  net.minecraft.potion.Potion
 *  net.minecraft.potion.PotionEffect
 *  net.minecraft.util.AxisAlignedBB
 */
package just.monika.主播为什么开我端子.modules.combat;

import just.monika.主播为什么开我端子.eventapi.Event;
import just.monika.主播为什么开我端子.eventapi.EventTarget;
import just.monika.主播为什么开我端子.eventapi.events.MoveEvent;
import just.monika.主播为什么开我端子.eventapi.events.UpdateEvent;
import just.monika.主播为什么开我端子.management.module.Mod;
import just.monika.主播为什么开我端子.management.module.Module;
import just.monika.主播为什么开我端子.management.module.ModuleManager;
import just.monika.主播为什么开我端子.management.option.Op;
import just.monika.主播为什么开我端子.management.option.OptionManager;
import just.monika.主播为什么开我端子.management.value.Val;
import just.monika.主播为什么开我端子.modules.render.HUD;
import just.monika.主播为什么开我端子.util.RotationUtils;
import just.monika.主播为什么开我端子.util.Timer;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

@Mod
public class AutoPot
extends Module {
    @Val(min=0.5, max=10.0, increment=0.5)
    private double health = 4.5;
    @Val(min=200.0, max=2000.0, increment=25.0)
    private double delay = 250.0;
    @Op
    private boolean predict;
    @Op
    private boolean splashUp;
    private Timer timer = new Timer();
    private static int expectedPackets;
    private int lockedTicks;
    private static int potSlot;
    private static ItemStack originalStack;
    private static int currentItem;

    @EventTarget(value=4)
    private void onUpdate(UpdateEvent event) {
        int potSlot;
        if (event.state == Event.State.PRE) {
            if (this.lockedTicks >= 0) {
                if (this.lockedTicks == 0) {
                    event.y = 1.3;
                } else {
                    event.setCancelled(true);
                }
                --this.lockedTicks;
            } else {
                int potSlot2 = this.getPotionFromInventory();
                if (potSlot2 != -1 && (double)this.mc.thePlayer.getHealth() <= this.health * 2.0 && this.timer.delay((float)this.delay)) {
                    if (this.splashUp && this.mc.thePlayer.motionX == 0.0 && this.mc.thePlayer.motionZ == 0.0 && this.mc.thePlayer.isCollidedVertically) {
                        event.pitch = -90.0f;
                    } else {
                        event.pitch = 98.0f;
                        if (this.predict) {
                            double movedPosX = this.mc.thePlayer.posX + this.mc.thePlayer.motionX * 16.0;
                            double movedPosY = this.mc.thePlayer.boundingBox.minY - 3.6;
                            double movedPosZ = this.mc.thePlayer.posZ + this.mc.thePlayer.motionZ * 16.0;
                            float yaw = RotationUtils.getRotationFromPosition(movedPosX, movedPosZ, movedPosY)[0];
                            float pitch = RotationUtils.getRotationFromPosition(movedPosX, movedPosZ, movedPosY)[1];
                            event.yaw = yaw;
                            event.pitch = pitch;
                        }
                    }
                }
            }
        } else if (event.state == Event.State.POST && this.lockedTicks < 0 && (potSlot = this.getPotionFromInventory()) != -1 && (double)this.mc.thePlayer.getHealth() <= this.health * 2.0 && this.timer.delay((float)this.delay)) {
            originalStack = this.mc.thePlayer.inventoryContainer.getSlot(36 + this.mc.thePlayer.inventory.currentItem).getStack();
            AutoPot.potSlot = potSlot;
            currentItem = this.mc.thePlayer.inventory.currentItem;
            boolean blocking = this.mc.thePlayer.isBlocking();
            this.swap(potSlot, this.mc.thePlayer.inventory.currentItem, true);
            //this.mc.playerController.updateController();
            this.mc.thePlayer.sendQueue.addToSendQueue((Packet)new C08PacketPlayerBlockPlacement(this.mc.thePlayer.getHeldItem()));
            this.swap(potSlot, this.mc.thePlayer.inventory.currentItem, true);
            expectedPackets = 4;
            if (this.splashUp) {
                this.lockedTicks = 6;
                this.mc.thePlayer.sendQueue.addToSendQueue((Packet)new C03PacketPlayer.C04PacketPlayerPosition(this.mc.thePlayer.posX, this.mc.thePlayer.posY + 0.42, this.mc.thePlayer.posZ, true));
                this.mc.thePlayer.sendQueue.addToSendQueue((Packet)new C03PacketPlayer.C04PacketPlayerPosition(this.mc.thePlayer.posX, this.mc.thePlayer.posY + 0.75, this.mc.thePlayer.posZ, true));
                this.mc.thePlayer.sendQueue.addToSendQueue((Packet)new C03PacketPlayer.C04PacketPlayerPosition(this.mc.thePlayer.posX, this.mc.thePlayer.posY + 1.0, this.mc.thePlayer.posZ, true));
                this.mc.thePlayer.sendQueue.addToSendQueue((Packet)new C03PacketPlayer.C04PacketPlayerPosition(this.mc.thePlayer.posX, this.mc.thePlayer.posY + 1.166, this.mc.thePlayer.posZ, true));
                this.mc.thePlayer.sendQueue.addToSendQueue((Packet)new C03PacketPlayer.C04PacketPlayerPosition(this.mc.thePlayer.posX, this.mc.thePlayer.posY + 1.24, this.mc.thePlayer.posZ, true));
            }
            this.timer.reset();
        }
    }

    @EventTarget
    private void onMove(MoveEvent event) {
        if (this.lockedTicks >= 0) {
            event.x = 0.0;
            event.z = 0.0;
            event.y = 0.0;
        }
    }

    public static void resetItems() {
        if (expectedPackets > 0) {
            --expectedPackets;
            Minecraft mc = Minecraft.getMinecraft();
            mc.thePlayer.inventoryContainer.putStackInSlot(potSlot, null);
            mc.thePlayer.inventoryContainer.putStackInSlot(36 + currentItem, originalStack);
        }
    }

    protected void swap(int slot, int hotbarNum, boolean packet) {
        this.mc.playerController.windowClick(this.mc.thePlayer.inventoryContainer.windowId, slot, hotbarNum, 2, (EntityPlayer)this.mc.thePlayer, packet);
    }

    private int getPotionFromInventory() {
        int pot = -1;
        int counter = 0;
        int i = 1;
        while (i < 45) {
            ItemStack is;
            ItemPotion potion;
            Item item;
            if (this.mc.thePlayer.inventoryContainer.getSlot(i).getHasStack() && (item = (is = this.mc.thePlayer.inventoryContainer.getSlot(i).getStack()).getItem()) instanceof ItemPotion && (potion = (ItemPotion)item).getEffects(is) != null) {
                for (Object o : potion.getEffects(is)) {
                    PotionEffect effect = (PotionEffect)o;
                    if (effect.getPotionID() != Potion.heal.id || !ItemPotion.isSplash((int)is.getItemDamage())) continue;
                    ++counter;
                    pot = i;
                }
            }
            ++i;
        }
        Character colorFormatCharacter = new Character('\u00a7');
        this.suffix = OptionManager.getOption((String)"Hyphen", (Module) ModuleManager.getModule(HUD.class)).value ? colorFormatCharacter + "7 - " + counter : colorFormatCharacter + "7 " + counter;
        return pot;
    }

    @Override
    public void onDisable() {
        expectedPackets = 0;
        this.lockedTicks = -1;
        super.onDisable();
    }
}

