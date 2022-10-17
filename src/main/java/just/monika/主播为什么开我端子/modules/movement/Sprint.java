package just.monika.主播为什么开我端子.modules.movement;

import just.monika.主播为什么开我端子.eventapi.EventTarget;
import just.monika.主播为什么开我端子.eventapi.events.PacketSendEvent;
import just.monika.主播为什么开我端子.eventapi.events.SprintEvent;
import just.monika.主播为什么开我端子.eventapi.events.TickEvent;
import just.monika.主播为什么开我端子.management.module.Mod;
import just.monika.主播为什么开我端子.management.module.Module;
import just.monika.主播为什么开我端子.management.module.ModuleManager;
import just.monika.主播为什么开我端子.management.option.Op;
import net.minecraft.network.play.client.C0BPacketEntityAction;

@Mod
public class Sprint
extends Module {
    @Op
    private boolean multiDirection;
    @Op
    private boolean fake;
    @Op
    private boolean legit;

    @EventTarget
    private void onTick(TickEvent event) {
        if (this.canSprint()) {
            this.mc.thePlayer.setSprinting(true);
        }
    }

    @EventTarget
    private void onSprint(SprintEvent event) {
        if (this.canSprint()) {
            event.sprint = true;
        }
    }

    @EventTarget
    private void onPacketSend(PacketSendEvent event) {
        C0BPacketEntityAction packet;
        if (this.fake && event.packet instanceof C0BPacketEntityAction && ((packet = (C0BPacketEntityAction)event.packet).getAction() == C0BPacketEntityAction.Action.START_SPRINTING || packet.getAction() == C0BPacketEntityAction.Action.STOP_SPRINTING)) {
            event.setCancelled(true);
        }
    }

    private boolean canSprint() {
        if (!this.mc.thePlayer.isCollidedHorizontally && !this.mc.thePlayer.isSneaking() && (!this.legit || ModuleManager.getModule(NoSlowdown.class).enabled || this.legit && this.mc.thePlayer.getFoodStats().getFoodLevel() > 5 && !this.mc.thePlayer.isUsingItem())) {
            if (this.multiDirection) {
                if (this.mc.thePlayer.movementInput.moveForward == 0.0f && this.mc.thePlayer.movementInput.moveStrafe == 0.0f) {
                    return false;
                }
                return true;
            }
            if (this.mc.thePlayer.movementInput.moveForward > 0.0f) {
                return true;
            }
            return false;
        }
        return false;
    }
}

