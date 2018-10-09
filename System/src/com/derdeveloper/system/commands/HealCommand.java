/*
 * Copyright (c) derdeveloper
 * Die hier genutzten Methoden und Klassen sind Implementierungen aus der Craftbukkit API
 * Der hier genutzte Code steht zur freien Verfügung
 * 
 */

package com.derdeveloper.system.commands;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.derdeveloper.system.Main;
import com.derdeveloper.system.manager.ConfigManager;
import com.derdeveloper.system.manager.ConsoleManager;
import com.derdeveloper.system.manager.LogManager;
import com.derdeveloper.system.manager.PlayerManager;

/**
  * 
  * @author derdeveloper
  * Erstellt am 08.10.2018 um 19:38:07
  * 
  **/

public class HealCommand implements CommandExecutor {
	
	private Main plugin;
	
	public HealCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("heal").setExecutor(this);
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		LogManager lm = LogManager.getLogger();
		ConsoleManager cm = ConsoleManager.getConsole();
		PlayerManager pm =  PlayerManager.getPlayer();
		ConfigManager cfm = ConfigManager.getConfig();
		
		if(command.getName().equalsIgnoreCase("heal")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				if(pm.hasPermission(p, "system.heal")) {
					if(args.length == 0) {
						pm.healPlayer(p);
						pm.sendMessage(p, ChatColor.GRAY + "Du wurdest geheilt!");
					} else if(args.length == 1) {
						if(pm.hasPermission(p, "system.heal.other")) {
							Player t = Bukkit.getPlayerExact(args[0]);
							if(t == p) {
								pm.healPlayer(p);
								pm.sendMessage(p, ChatColor.GRAY + "Du wurdest geheilt!");
							} else if(t != null) {
								if(!pm.hasPermission(t, "system.heal.prevent")) {
									pm.healPlayer(t);
									pm.sendMessage(t, ChatColor.GRAY + "Du wurdest geheilt!");
									pm.sendMessage(p, ChatColor.GRAY + "Du hast den Spieler " + cfm.getLightColor() + t.getName() + ChatColor.GRAY + " erfolgreich geheilt!");
								} else {
									pm.sendMessage(p, cfm.getLightColor() + "Du darfst den Spieler " + t.getName() + " nicht heilen!");
								}
							} else {
								pm.sendMessage(p, cfm.getLightColor() + "Der Spieler " + args[0] + " ist nicht online!");
							}
						} else {
							pm.sendNoPerm(p);
						}
					} else {
						pm.sendMessage(p, ChatColor.GRAY + "Benutzung: " + cfm.getLightColor() + "/" + command.getName() + " <Spieler>");
					}
				} else {
					pm.sendNoPerm(p);
				}
			} else {
				if(args.length == 1) {
					Player t = Bukkit.getPlayerExact(args[0]);
					if(t != null) {
						pm.healPlayer(t);
						pm.sendMessage(t, ChatColor.GRAY + "Du wurdest geheilt!");
						cm.sendMessage("Du hast den Spieler " + t.getName() + " erfolgreich geheilt!");
					} else {
						cm.sendMessage("Der Spieler " + args[0] + " ist nicht online!");
					}
				} else {
					cm.sendMessage("Benutzung: /" + command.getName() + " [Spieler]");
				}
			}
		} else {
			lm.log(Level.WARNING, "Fehler: Modul " + this.getClass().getSimpleName() + " konnte nicht geladen werden.");
		}
		return true;
	}
}
