/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.inventory.GuiInventory
 *  net.minecraft.client.multiplayer.PlayerControllerMP
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.inventory.Container
 *  net.minecraft.inventory.Slot
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemArmor
 *  net.minecraft.item.ItemStack
 */
package just.monika.主播为什么开我端子.modules.combat;

import just.monika.主播为什么开我端子.eventapi.EventTarget;
import just.monika.主播为什么开我端子.eventapi.events.TickEvent;
import just.monika.主播为什么开我端子.management.module.Mod;
import just.monika.主播为什么开我端子.management.module.Module;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

@Mod
public class AutoArmor
extends Module {
    @EventTarget
    private void onTick(TickEvent event) {
        if (this.mc.currentScreen == null || this.mc.currentScreen instanceof GuiInventory || !this.mc.currentScreen.getClass().getName().contains("inventory")) {
            int slotID = -1;
            double maxProt = -1.0;
            int i = 9;
            while (i < 45) {
                double protValue;
                ItemStack stack = this.mc.thePlayer.inventoryContainer.getSlot(i).getStack();
                if (stack != null && this.canEquip(stack) && (protValue = this.getProtValue(stack)) >= maxProt) {
                    slotID = i;
                    maxProt = protValue;
                }
                ++i;
            }
            if (slotID != -1) {
                this.mc.playerController.windowClick(this.mc.thePlayer.inventoryContainer.windowId, slotID, 0, 1, (EntityPlayer)this.mc.thePlayer);
            }
        }
    }

    private boolean canEquip(ItemStack stack) {
        if (!(this.mc.thePlayer.getEquipmentInSlot(1) == null && stack.getUnlocalizedName().contains("boots") || this.mc.thePlayer.getEquipmentInSlot(2) == null && stack.getUnlocalizedName().contains("leggings") || this.mc.thePlayer.getEquipmentInSlot(3) == null && stack.getUnlocalizedName().contains("chestplate") || this.mc.thePlayer.getEquipmentInSlot(4) == null && stack.getUnlocalizedName().contains("helmet"))) {
            return false;
        }
        return true;
    }

    private double getProtValue(ItemStack stack) {
        return (double)((ItemArmor)stack.getItem()).damageReduceAmount + (double)((100 - ((ItemArmor)stack.getItem()).damageReduceAmount * 4) * EnchantmentHelper.getEnchantmentLevel((int)Enchantment.protection.effectId, (ItemStack)stack) * 4) * 0.0075;
    }
}

