package just.monika.主播为什么开我端子;

import just.monika.主播为什么开我端子.commands.Hud;
import just.monika.主播为什么开我端子.commands.InventoryCleaner;
import just.monika.主播为什么开我端子.management.account.AccountManager;
import just.monika.主播为什么开我端子.management.command.CommandManager;
import just.monika.主播为什么开我端子.management.friend.FriendManager;
import just.monika.主播为什么开我端子.management.module.ModuleManager;
import just.monika.主播为什么开我端子.management.option.OptionManager;
import just.monika.主播为什么开我端子.management.value.ValueManager;
import just.monika.主播为什么开我端子.ui.alt.screens.account.AccountScreen;
import just.monika.主播为什么开我端子.ui.clickgui.Draw;
import just.monika.主播为什么开我端子.ui.clickgui.Gui;
import just.monika.主播为什么开我端子.util.FontRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.Display;

public class Client {
    public static final String NAME = "LiteratureAssembly";
    public static final double VERSION = 0.01;
    public static AccountScreen accountScreen = new AccountScreen();
    public static FontRenderer font;

    public static void init() throws Exception {
        Client.configureFont();
        ModuleManager.init();
        CommandManager.init();
        OptionManager.init();
        ValueManager.init();
        FriendManager.init();
        AccountManager.init();
        Hud.load();
        InventoryCleaner.load();
        Draw.load();
        new Gui();
        Display.setTitle(NAME + " " + VERSION + " | " + Minecraft.getMinecraft().getVersion());
    }

    private static void configureFont() {
        Minecraft mc = Minecraft.getMinecraft();
        font = new FontRenderer(mc.gameSettings, new ResourceLocation(NAME.toLowerCase() + "/font/ascii.png"), mc.renderEngine, false);
        if (mc.gameSettings.language != null) {
            mc.fontRendererObj.setUnicodeFlag(mc.isUnicode());
            mc.fontRendererObj.setBidiFlag(mc.mcLanguageManager.isCurrentLanguageBidirectional());
        }
        mc.mcResourceManager.registerReloadListener(font);
    }
}

