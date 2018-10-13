package com.derdeveloper.system;

import com.derdeveloper.system.manager.ConfigManager;
import com.derdeveloper.system.manager.PlayerManager;
import org.bukkit.Bukkit;
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
        new PlayerManager(this);
        new ConfigManager(this);

        ConfigManager.getConfig().loadConfig();
    }
}
