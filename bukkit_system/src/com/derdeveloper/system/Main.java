package com.derdeveloper.system;

import com.derdeveloper.system.commands.*;
import com.derdeveloper.system.manager.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin {

    Logger logger = Bukkit.getLogger();

    public void onEnable() {
        registerPlugin();
        logger.info("Plugin erfolgreich geladen.");
    }

    public void onDisable() {
        logger.info("Plugin erfolgreich entladen.");
    }

    public void registerPlugin() {
        new ConfigManager(this);
        new HealCommand(this);
        new ReloadCommand(this);
        new PluginsCommand(this);
        new FeedCommand(this);
        new StopCommand(this);
    }

    public static String getPrefix() {
        return ChatColor.RED + "•" + ChatColor.DARK_RED + "●" + ChatColor.RED + " Server.net " + ChatColor.GRAY + "| " + ChatColor.RESET;
    }
}
