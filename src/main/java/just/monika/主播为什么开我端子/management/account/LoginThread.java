/*
 * Decompiled with CFR 0_114.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.Agent
 *  com.mojang.authlib.GameProfile
 *  com.mojang.authlib.UserAuthentication
 *  com.mojang.authlib.exceptions.AuthenticationException
 *  com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService
 *  com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.Session
 */
package just.monika.主播为什么开我端子.management.account;

import com.mojang.authlib.Agent;
import com.mojang.authlib.exceptions.AuthenticationException;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;

import just.monika.主播为什么开我端子.Client;

import java.net.Proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.util.Session;

public class LoginThread
extends Thread {
    private Minecraft mc = Minecraft.getMinecraft();
    private String pass;
    private String email;

    public LoginThread(String email, String pass) {
        super("LoginThread");
        this.email = email;
        this.pass = pass;
        Client.accountScreen.info = "\u00a7aLogging In...";
    }

    private Session createSession(String email, String pass) {
        YggdrasilAuthenticationService service = new YggdrasilAuthenticationService(Proxy.NO_PROXY, "");
        YggdrasilUserAuthentication authentication = (YggdrasilUserAuthentication)service.createUserAuthentication(Agent.MINECRAFT);
        authentication.setUsername(email);
        authentication.setPassword(pass);
        try {
            authentication.logIn();
            return new Session(authentication.getSelectedProfile().getName(), authentication.getSelectedProfile().getId().toString(), authentication.getAuthenticatedToken(), "legacy");
        }
        catch (AuthenticationException e) {
            return null;
        }
    }

    @Override
    public void run() {
        if (this.pass.equals("")) {
            this.mc.session = new Session(this.email, "", "", "legacy");
            Client.accountScreen.info = "\u00a7eLogged In: " + this.email;
            return;
        }
        Session session = this.createSession(this.email, this.pass);
        if (session == null) {
            Client.accountScreen.info = "\u00a7cLogin Failed";
        } else {
            this.mc.session = session;
            Client.accountScreen.info = "\u00a7aLogged In: " + session.getUsername();
        }
    }
}

