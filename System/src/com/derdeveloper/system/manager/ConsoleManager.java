/*
 * Copyright (c) derdeveloper
 * Die hier genutzten Methoden und Klassen sind Implementierungen aus der Craftbukkit API
 * Der hier genutzte Code steht zur freien Verfügung
 */

package com.derdeveloper.system.manager;

import org.bukkit.Bukkit;

import com.derdeveloper.system.Main;

/**
  * 
  * @author derdeveloper
  * Erstellt am 08.10.2018 um 19:58:29
  * 
  **/

public class ConsoleManager {
	
	private Main plugin;
	private static ConsoleManager singleton;
	
	public ConsoleManager(Main plugin) {
		this.plugin = plugin;
		singleton = this;
	}
	
	public static ConsoleManager getConsole() {
		return singleton;
	}
	
	public void sendMessage(String string) {
		Bukkit.getConsoleSender().sendMessage(string);
	}
}
