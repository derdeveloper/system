package com.derdeveloper.system.commands;

import com.derdeveloper.system.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.Plugin;

public class PluginsCommand implements Listener {

    private Main plugin;

    public PluginsCommand(Main plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void handlePluginsCommand(PlayerCommandPreprocessEvent event) {
        String prefix = Main.getPrefix();

        Player p = event.getPlayer();
        String[] message = event.getMessage().split(" ");
        String command = message[0];

        if(command.equalsIgnoreCase("/plugins") || command.equalsIgnoreCase("/pl") || command.equalsIgnoreCase("/bukkit:plugins") || command.equalsIgnoreCase("/bukkit:pl")) {
            if(p.hasPermission("system.plugins")) {
               if(message.length == 1) {
                   Plugin[] plugins = Bukkit.getServer().getPluginManager().getPlugins();
                   String pl = "";
                   for(int i = 0; i < plugins.length; i++) {
                       if(pl.equalsIgnoreCase("")) {
                           pl = ChatColor.RED + plugins[i].getName();
                       } else {
                           pl = pl + ChatColor.GRAY + ", " + ChatColor.RED + plugins[i].getName();
                       }
                   }
                   p.sendMessage(prefix + ChatColor.GRAY + "Plugins (" + plugins.length + "): " + pl);
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
