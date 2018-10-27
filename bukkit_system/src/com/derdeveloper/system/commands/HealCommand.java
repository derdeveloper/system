package com.derdeveloper.system.commands;

import com.derdeveloper.system.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    private Main plugin;

    public HealCommand(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("heal").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String prefix = Main.getPrefix();

        if(command.getName().equalsIgnoreCase("heal")) {
            if(sender instanceof Player) {
                Player p = (Player) sender;
                if(p.hasPermission("system.heal")) {
                    if(args.length == 0) {
                        p.setHealth(20.0);
                        p.setFoodLevel(20);
                        p.sendMessage(prefix + ChatColor.GRAY + "Du wurdest geheilt.");
                    } else if(args.length == 1) {
                        if(p.hasPermission("system.heal.other")) {
                            String arg = args[0];
                            Player t = Bukkit.getPlayer(arg);
                            if(arg.length() > 16) {
                                p.sendMessage(prefix + ChatColor.GRAY + "Der Name darf nicht mehr als 16 Zeichen enthalten.");
                            } else {
                                if(t == p) {
                                    p.setHealth(20.0);
                                    p.setFoodLevel(20);
                                    p.sendMessage(prefix + ChatColor.GRAY + "Du wurdest geheilt.");
                                } else if(t != null) {
                                    if(!t.hasPermission("system.heal.prevent")) {
                                        t.setHealth(20.0);
                                        t.setFoodLevel(20);
                                        t.sendMessage(prefix + ChatColor.GRAY + "Du wurdest geheilt.");
                                        p.sendMessage(prefix + ChatColor.GRAY + "Der Spieler "+ ChatColor.RED + t.getDisplayName() + ChatColor.GRAY + " wurde erfolgreich geheilt.");
                                    } else {
                                        p.sendMessage(prefix + ChatColor.GRAY + "Du darfst den Spieler " + ChatColor.RED + t.getDisplayName() + ChatColor.GRAY + " nicht heilen!");
                                    }
                                } else {
                                    p.sendMessage(prefix + ChatColor.GRAY + "Der Spieler "+ ChatColor.RED + arg + ChatColor.GRAY + " ist offline!");
                                }
                            }
                        } else {
                            p.sendMessage(prefix + ChatColor.GRAY + "Du hast keinen Zugriff auf diesen Befehl!");
                        }
                    } else {
                        p.sendMessage(prefix + ChatColor.GRAY + "Benutzung: " + ChatColor.RED + "/heal <Spieler>");
                    }
                } else {
                    p.sendMessage(prefix + ChatColor.GRAY + "Du hast keinen Zugriff auf diesen Befehl!");
                }
            } else {
                if(args.length == 1) {
                    String arg = args[0];
                    Player t = Bukkit.getPlayer(arg);
                    if(arg.length() > 16) {
                        if(t != null) {
                            t.setHealth(20.0);
                            t.setFoodLevel(20);
                            t.sendMessage(prefix + ChatColor.GRAY + "Du wurdest geheilt.");
                            sender.sendMessage("Der Spieler " + t.getDisplayName() + " wurde erfolgreich geheilt.");
                        } else {
                            sender.sendMessage("Der Spieler " + arg + " ist offline!");
                        }
                    }
                } else {
                    sender.sendMessage("Benutzung: /heal [Spieler]");
                }
            }
        }
        return true;
    }
}
