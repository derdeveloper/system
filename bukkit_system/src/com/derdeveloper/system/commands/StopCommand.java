package com.derdeveloper.system.commands;

import com.derdeveloper.system.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class StopCommand implements Listener {

    private Main plugin;

    public StopCommand(Main plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void handleStopCommand(PlayerCommandPreprocessEvent event) {
        String prefix = Main.getPrefix();

        Player p = event.getPlayer();
        String[] message = event.getMessage().split(" ");
        String command = message[0];

        if(command.equalsIgnoreCase("/stop") || command.equalsIgnoreCase("/bukkit:stop")) {
            if(p.hasPermission("system.stop")) {
                if(message.length == 1) {
                    for(Player op : Bukkit.getOnlinePlayers()) {
                        op.kickPlayer(ChatColor.RED + "Der Server wird neugestartet.");
                    }
                    Bukkit.shutdown();
                } else {
                    p.sendMessage(prefix + ChatColor.GRAY + "Benutzung: " + ChatColor.RED + command);
                }
            } else {
                p.sendMessage(prefix + ChatColor.GRAY + "Du hast keinen Zugriff auf diesen Befehl!");
            }
        }
    }
}
