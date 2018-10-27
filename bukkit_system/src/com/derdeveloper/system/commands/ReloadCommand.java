package com.derdeveloper.system.commands;

import com.derdeveloper.system.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class ReloadCommand implements Listener {

    private Main plugin;

    public ReloadCommand(Main plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void handleReloadCommand(PlayerCommandPreprocessEvent event) {
        String prefix = Main.getPrefix();

        Player p = event.getPlayer();
        String[] message = event.getMessage().split(" ");
        String command = message[0];
        if(command.equalsIgnoreCase("/reload") || command.equalsIgnoreCase("/rl") || command.equalsIgnoreCase("/bukkit:reload") || command.equalsIgnoreCase("/bukkit:rl")) {
            if(p.hasPermission("system.reload")) {
                if(message.length == 1) {
                    Bukkit.reload();
                    p.sendMessage(prefix + ChatColor.GRAY + "Der Server wurde erfolgreich neugeladen.");
                } else {
                    p.sendMessage(prefix + ChatColor.GRAY + "Benutzung: " + ChatColor.RED + command);
                }
            } else {
                p.sendMessage(prefix + ChatColor.GRAY + "Du hast keinen Zugriff auf diesen Befehl!");
            }
            event.setCancelled(true);
        }
    }
}