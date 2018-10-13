package com.derdeveloper.system;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin {

    Logger logger = Bukkit.getLogger();

    public void onEnable() {
        logger.info("Plugin erfolgreich geladen.");
    }

    public void onDisable() {
        logger.info("Plugin erfolgreich entladen.");
    }

}
