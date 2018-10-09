/*
 * Copyright (c) derdeveloper
 * Die hier genutzten Methoden und Klassen sind Implementierungen aus der Craftbukkit API
 * Der hier genutzte Code steht zur freien Verfügung
 * 
 */

package com.derdeveloper.system.manager;

import org.bukkit.ChatColor;

import com.derdeveloper.system.Main;

/**
  * 
  * @author derdeveloper
  * Erstellt am 08.10.2018 um 20:22:10
  * 
  **/

public class ConfigManager {
	
	private Main plugin;
	private static ConfigManager singleton;
	
	public ConfigManager(Main plugin) {
		this.plugin = plugin;
		singleton = this;
	}
	
	public static ConfigManager getConfig() {
		return singleton;
	}
	
	public String getPrefix() {
		String string = this.getString("config.prefix");
		string = string.replace("<lc>", this.getLightColor());
		string = string.replace("<dc>", this.getDarkColor());
		return string;
	}
	
	public String getString(String string) {
		String string2 = plugin.getConfig().getString(string);
		string2 = ChatColor.translateAlternateColorCodes('&', string2);
		return string2;
	}
	
	public String getLightColor() {
		return this.getString("config.lightcolor");
	}
	
	public String getDarkColor() {
		return this.getString("config.darkcolor");
	}
}
