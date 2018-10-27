package com.derdeveloper.system.manager;

import com.derdeveloper.system.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    private Main plugin;
    private static ConfigManager inst;

    public ConfigManager(Main plugin) {
        this.plugin = plugin;
        inst = this;
        loadConfig();
    }

    public static ConfigManager getConfig() {
        return inst;
    }

    public void loadConfig() {
        File file = new File(plugin.getDataFolder(), "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        config.options().copyDefaults(true);
        try {
            config.save(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getString(String path) {
        File config_yml = new File(plugin.getDataFolder(), "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(config_yml);
        return config.getString(path);
    }

    public Integer getInt(String path) {
        File config_yml = new File(plugin.getDataFolder(), "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(config_yml);
        return config.getInt(path);
    }

    public Double getDouble(String path) {
        File config_yml = new File(plugin.getDataFolder(), "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(config_yml);
        return config.getDouble(path);
    }

    public Boolean getBoolean(String path) {
        File config_yml = new File(plugin.getDataFolder(), "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(config_yml);
        return config.getBoolean(path);
    }
}
