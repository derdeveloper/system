/*
 * Copyright (c) derdeveloper
 * Die hier genutzten Methoden und Klassen sind Implementierungen aus der Craftbukkit API
 * Der hier genutzte Code steht zur freien Verfügung
 * 
 */

package com.derdeveloper.system.manager;

import java.util.logging.Level;

import org.bukkit.Bukkit;

import com.derdeveloper.system.Main;

/**
  * 
  * @author derdeveloper
  * Erstellt am 08.10.2018 um 19:28:38
  * 
  **/

public class LogManager {
	
	private Main plugin;
	private static LogManager singleton;
	
	public LogManager(Main plugin) {
		this.plugin = plugin;
		singleton = this;
	}
	
	public static LogManager getLogger() {
		return singleton;
	}
	
	public void log(Level level, String string) {
		Bukkit.getLogger().log(level, string);
	}
}
