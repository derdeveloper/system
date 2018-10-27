package com.derdeveloper.system.commands;

import com.derdeveloper.system.Main;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class MSGCommand extends Command {
    public MSGCommand(Main plugin) {
        super("msg");
        BungeeCord.getInstance().pluginManager.registerCommand(plugin, this);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        String prefix = Main.getPrefix();
        String msgprefix = Main.getPrivateMessagePrefix();

        if(sender instanceof ProxiedPlayer) {
            ProxiedPlayer p = (ProxiedPlayer) sender;
            if(p.hasPermission("system.msg")) {
                if(args.length == 0 || args.length == 1) {
                    p.sendMessage(prefix + ChatColor.GRAY + "Benutzung: " + ChatColor.RED + "/msg [Spieler] [Nachricht]");
                } else {
                    String arg = args[0];
                    String message = "";
                    ProxiedPlayer t = BungeeCord.getInstance().getPlayer(arg);
                    if(arg.length() > 16) {
                        p.sendMessage(prefix + ChatColor.GRAY + "Der Name darf nicht mehr als 16 Zeichen enthalten.");
                    } else {
                        if(t == p) {
                            p.sendMessage(prefix + ChatColor.GRAY + "Du kannst dir selber keine Nachrichten schicken!");
                        } else if(t != null) {
                            for(int i = 1; i < args.length; i++) {
                                message = message + args[i] + " ";
                            }
                            if(p.hasPermission("system.msg.format")) {
                                message = ChatColor.translateAlternateColorCodes('&', message);
                            }
                            t.sendMessage(msgprefix + ChatColor.RED + p.getDisplayName() + ChatColor.GRAY + " » " + ChatColor.RED + "mir " + ChatColor.GRAY + ": " + message);
                            p.sendMessage(msgprefix + ChatColor.RED + "mir" + ChatColor.GRAY + " » " + ChatColor.RED + t.getDisplayName() + ChatColor.GRAY + ": " + message);
                        } else {
                            p.sendMessage(prefix + ChatColor.GRAY + "Der Spieler " + ChatColor.RED + arg + ChatColor.GRAY + " ist offline!");
                        }
                    }
                }
            } else {
                p.sendMessage(prefix + ChatColor.GRAY + "Du hast keinen Zugriff auf diesen Befehl!");
            }
        } else {
            sender.sendMessage("Dieser Befehl kann in der Konsole nicht ausgeführt werden!");
        }
    }
}
