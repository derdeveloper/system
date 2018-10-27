package com.derdeveloper.system.commands;

import com.derdeveloper.system.Main;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class PingCommand extends Command {

    public PingCommand(Main plugin) {
        super("ping");
        BungeeCord.getInstance().getPluginManager().registerCommand(plugin,  this);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        String prefix = Main.getPrefix();

        if(sender instanceof ProxiedPlayer) {
            ProxiedPlayer p = (ProxiedPlayer) sender;
            if(p.hasPermission("system.ping")) {
                if(args.length == 0) {
                    p.sendMessage(prefix + ChatColor.GRAY + "Dein Ping: " + ChatColor.RED + p.getPing() + "ms");
                } else if(args.length == 1) {
                    if(p.hasPermission("system.ping.other")) {
                        String arg = args[0];
                        ProxiedPlayer t = BungeeCord.getInstance().getPlayer(arg);
                        if(arg.length() > 16) {
                            p.sendMessage(prefix + ChatColor.GRAY + "Der Name darf nicht mehr als 16 Zeichen enthalten.");
                        } else {
                            if(t == p) {
                                p.sendMessage(prefix + ChatColor.GRAY + "Dein Ping: " + ChatColor.RED + p.getPing() + "ms");
                            } else if(t != null) {
                                p.sendMessage(prefix + ChatColor.GRAY + "Ping von " + ChatColor.RED + t.getDisplayName() + ChatColor.GRAY + ": " + ChatColor.RED + t.getPing() + "ms");
                            } else {
                                p.sendMessage(prefix + ChatColor.GRAY + "Der Spieler " + ChatColor.RED + arg + ChatColor.GRAY + " ist offline!");
                            }
                        }
                    } else {
                        p.sendMessage(prefix + ChatColor.GRAY + "Du hast keinen Zugriff auf diesen Befehl!");
                    }
                } else {
                    p.sendMessage(prefix + ChatColor.GRAY + "Benutzung: " + ChatColor.RED + "/ping <Spieler>");
                }
            } else {
                p.sendMessage(prefix + ChatColor.GRAY + "Du hast keinen Zugriff auf diesen Befehl!");
            }
        } else {
            sender.sendMessage("Dieser Befehl kann in der Konsole nicht ausgeführt werden!");
        }
    }
}
