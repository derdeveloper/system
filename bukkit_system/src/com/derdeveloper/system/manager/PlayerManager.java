package com.derdeveloper.system.manager;

import com.derdeveloper.system.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class PlayerManager {

    private Main plugin;
    private static PlayerManager inst;
    private static Player player = null;

    public PlayerManager(Main plugin) {
        this.plugin = plugin;
        inst = this;
    }

    public static PlayerManager getPlayer(Player p) {
        player = p;
        return inst;
    }

    public void healPlayer() {
        player.setHealth(20.0);
        player.setFoodLevel(20);
    }

    public void sendMessage(String string) {
        player.sendMessage(string);
    }
}
