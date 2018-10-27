package com.derdeveloper.system;

import com.derdeveloper.system.commands.BroadcastCommand;
import com.derdeveloper.system.commands.MSGCommand;
import com.derdeveloper.system.commands.PingCommand;
import com.derdeveloper.system.listener.PingListener;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.plugin.Plugin;


public class Main extends Plugin {

    public void onEnable() {
        new PingCommand(this);
        new BroadcastCommand(this);
        new MSGCommand(this);
        new PingListener(this);
        System.out.println("Plugin erfolgreich geladen");
    }

    public void onDisable() {

    }

    public static String getPrefix() {
        return ChatColor.RED + "•" + ChatColor.DARK_RED + "●" + ChatColor.RED + " Server.net " + ChatColor.GRAY + "| " + ChatColor.RESET;
    }

    public static String getPrivateMessagePrefix() {
        return ChatColor.RED + "•" + ChatColor.DARK_RED + "●" + ChatColor.RED + " Nachrichten " + ChatColor.GRAY + "| " + ChatColor.RESET;
    }

}
