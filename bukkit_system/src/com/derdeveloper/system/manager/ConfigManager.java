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
    }

    public static ConfigManager getConfig() {
        return inst;
    }

    public void loadConfig() {
        // config.yml
        File config_yml = new File(plugin.getDataFolder(), "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(config_yml);
        config.addDefault("max_health", Double.valueOf(20.0));
        config.addDefault("max_food", Integer.valueOf(20));
        config.options().copyDefaults(true);
        try {
            config.save(config_yml);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // messages.yml
        File messages_yml = new File(plugin.getDataFolder(), "messages.yml");
        FileConfiguration messages = YamlConfiguration.loadConfiguration(messages_yml);
        messages.addDefault("healed", "&aDu wurdest geheilt.");
        messages.addDefault("noPerm", "&4Dazu hast du keine Rechte!");
        messages.options().copyDefaults(true);
        try {
            messages.save(messages_yml);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getString(String path) {
        File config_yml = new File(plugin.getDataFolder(), "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(config_yml);
        return config.getString(path);
    }

    public String getMessage(String path) {
        File messages_yml = new File(plugin.getDataFolder(), "messages.yml");
        FileConfiguration messages = YamlConfiguration.loadConfiguration(messages_yml);
        return messages.getString(path);
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
}
