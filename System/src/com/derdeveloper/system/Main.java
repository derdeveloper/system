/*
 * Copyright (c) derdeveloper
 * Die hier genutzten Methoden und Klassen sind Implementierungen aus der Craftbukkit API
 * Der hier genutzte Code steht zur freien Verfügung
 * 
 */

package com.derdeveloper.system;

import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;

import com.derdeveloper.system.commands.HealCommand;
import com.derdeveloper.system.manager.ConfigManager;
import com.derdeveloper.system.manager.ConsoleManager;
import com.derdeveloper.system.manager.LogManager;
import com.derdeveloper.system.manager.PlayerManager;

/**
  * 
  * @author derdeveloper
  * Erstellt am 08.10.2018 um 17:43:43
  * 
  **/

public class Main extends JavaPlugin {
	
	public void onEnable() {	
		new LogManager(this);
		LogManager lm = LogManager.getLogger();
		lm.log(Level.INFO, "Modul " + LogManager.class.getSimpleName() + " erfolgreich geladen.");
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		lm.log(Level.INFO, "Konfigurationsdatei config.yml erfolgreich geladen.");
		
		new PlayerManager(this);
		lm.log(Level.INFO, "Modul " + PlayerManager.class.getSimpleName() + " erfolgreich geladen.");
		
		new ConsoleManager(this);
		lm.log(Level.INFO, "Modul " + ConsoleManager.class.getSimpleName() + " erfolgreich geladen."); 
		
		new ConfigManager(this);
		lm.log(Level.INFO, "Modul " + ConfigManager.class.getSimpleName() + " erfolgreich geladen.");
		
		new HealCommand(this);
		lm.log(Level.INFO, "Modul " + HealCommand.class.getSimpleName() + " erfolgreich geladen.");
	}
}
