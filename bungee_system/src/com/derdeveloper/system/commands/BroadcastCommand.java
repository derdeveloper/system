package com.derdeveloper.system.commands;

import com.derdeveloper.system.Main;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class BroadcastCommand extends Command {

    public BroadcastCommand(Main plugin) {
        super("broadcast");
        BungeeCord.getInstance().pluginManager.registerCommand(plugin, this);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        String prefix = Main.getPrefix();

        if(sender instanceof ProxiedPlayer) {
            ProxiedPlayer p = (ProxiedPlayer) sender;
            if(p.hasPermission("system.broadcast")) {
                if(args.length != 0) {
                    String message = "";
                    for(int i = 0; i < args.length; i++) {
                        message = message + args[i] + " ";
                    }
                    for(ProxiedPlayer op : BungeeCord.getInstance().getPlayers()) {
                        op.sendMessage(prefix + ChatColor.GRAY + ChatColor.translateAlternateColorCodes('&', message));
                    }
                } else {
                    p.sendMessage(prefix + ChatColor.GRAY + "Benutzung: " + ChatColor.RED + "/broadcast [Nachricht]");
                }
            } else {
                p.sendMessage(prefix + ChatColor.GRAY + "Du hast keinen Zugriff auf diesen Befehl!");
            }
        } else {
            sender.sendMessage("Dieser Befehl kann in der Konsole nicht ausgeführt werden!");
        }
    }
}
