/*
 * Copyright (c) derdeveloper
 * Die hier genutzten Methoden und Klassen sind Implementierungen aus der Craftbukkit API
 * Der hier genutzte Code steht zur freien Verfügung
 * 
 */

package com.derdeveloper.system.manager;

import org.bukkit.entity.Player;

import com.derdeveloper.system.Main;

/**
  * 
  * @author derdeveloper
  * Erstellt am 08.10.2018 um 19:54:29
  * 
  **/

public class PlayerManager {
	
	private Main plugin;
	private static PlayerManager singleton;
	
	public PlayerManager(Main plugin) {
		this.plugin = plugin;
		singleton = this;
	}
	
	public static PlayerManager getPlayer() {
		return singleton;
	}
	
	public void healPlayer(Player player) {
		player.setHealth(20);
		player.setFoodLevel(20);
	}
	
	public boolean hasPermission(Player player, String permission) {
		if(player.hasPermission(permission)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void sendNoPerm(Player player) {
		ConfigManager cfm = ConfigManager.getConfig();
		player.sendMessage(cfm.getPrefix() + cfm.getDarkColor() + "Du hast keinen Zugriff auf diesen Befehl!");
	}
	
	public void sendMessage(Player player, String string) {
		ConfigManager cfm = ConfigManager.getConfig();
		player.sendMessage(cfm.getPrefix() + string);
	}
}
