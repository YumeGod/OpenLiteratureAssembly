package just.monika.主播为什么开我端子.modules.player;

import just.monika.主播为什么开我端子.management.module.Mod;
import just.monika.主播为什么开我端子.management.module.Module;
import just.monika.主播为什么开我端子.management.value.Val;

@Mod
public class SpeedMine
  extends Module
{
  @Val(min=1.0D, max=10.0D, increment=1.0D)
  public static double amplifier = 1.0D;
}
