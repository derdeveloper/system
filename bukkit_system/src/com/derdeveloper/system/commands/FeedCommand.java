package com.derdeveloper.system.commands;

import com.derdeveloper.system.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {

    private Main plugin;

    public FeedCommand(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("feed").setExecutor(this);
        plugin.getCommand("eat").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String prefix = Main.getPrefix();

        if(command.getName().equalsIgnoreCase("feed") || command.getName().equalsIgnoreCase("eat")) {
            if(sender instanceof Player) {
                Player p = (Player) sender;
                if(p.hasPermission("system.feed")) {
                    if(args.length == 0) {
                        p.setFoodLevel(20);
                        p.sendMessage(prefix + ChatColor.GRAY + "Dein Hunger wurde gestillt.");
                    } else if(args.length == 1) {
                        if(p.hasPermission("system.feed.other"))  {
                            String arg = args[0];
                            Player t = Bukkit.getPlayer(arg);
                            if(arg.length() > 16) {
                                p.sendMessage(prefix + ChatColor.GRAY + "Der Name darf nicht mehr als 16 Zeichen enthalten.");
                            } else {
                                if(t == p) {
                                    p.setFoodLevel(20);
                                    p.sendMessage(prefix + ChatColor.GRAY + "Dein Hunger wurde gestillt.");
                                } else if(t != null) {
                                    if(!t.hasPermission("system.heal.prevent")) {
                                        t.setFoodLevel(20);
                                        t.sendMessage(prefix + ChatColor.GRAY + "Dein Hunger wurde gestillt.");
                                        p.sendMessage(prefix + ChatColor.GRAY + "Der Hunger des Spielers " + ChatColor.RED + t.getDisplayName() + ChatColor.GRAY + " wurde gestillt.");
                                    } else {
                                        p.sendMessage(prefix + ChatColor.GRAY + "Du darfst den Hunger des Spielers" + ChatColor.RED + t.getDisplayName() + ChatColor.GRAY + " nicht stillen!");
                                    }
                                } else {
                                    p.sendMessage(prefix + ChatColor.GRAY + "Der Spieler " + ChatColor.RED + arg + ChatColor.GRAY + " ist offline!");
                                }
                            }
                        } else {
                            p.sendMessage(prefix + ChatColor.GRAY + "Du hast keinen Zugriff auf diesen Befehl!");
                        }
                    } else {
                        p.sendMessage(prefix + ChatColor.GRAY + "Benutzung: " + ChatColor.RED + "/" + command.getName() + " <Spieler>");
                    }
                } else {
                    p.sendMessage(prefix + ChatColor.GRAY + "Du hast keinen Zugrif auf diesen Befehl!");
                }
            } else {
                if(args.length == 1) {
                    String arg = args[0];
                    Player t = Bukkit.getPlayer(args[0]);
                    if(t != null) {
                        t.setFoodLevel(20);
                        t.sendMessage(prefix + ChatColor.GRAY + "Dein Hunger wurde gestillt.");
                        sender.sendMessage("Der Hunger des Spielers " + t.getDisplayName() + " wurde erfolgreich gestillt.");
                    } else {
                        sender.sendMessage("Der Spieler " + arg + " ist offline!");
                    }
                } else {
                    sender.sendMessage("Benutzung: " + command.getName() + " [Spieler]");
                }
            }
        }
        return true;
    }
}
