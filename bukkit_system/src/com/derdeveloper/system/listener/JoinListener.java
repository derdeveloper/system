package com.derdeveloper.system.listener;

import com.derdeveloper.system.Main;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    private Main plugin;

    public JoinListener(Main plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void handlePlayerJoin(PlayerJoinEvent event) {
        String prefix = Main.getPrefix();

        event.setJoinMessage(prefix + ChatColor.RED + event.getPlayer().getDisplayName() + ChatColor.GRAY + " hat den Server betreten.");
    }
}
