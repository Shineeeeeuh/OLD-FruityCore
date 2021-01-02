package io.shine.fruitycore.spigot;

import org.bukkit.plugin.java.JavaPlugin;

import io.shine.fruitycore.spigot.events.DataLoadEvent;

public class CoreSpigot extends JavaPlugin{
	
	@Override
	public void onEnable() {
		registerEvents();
	}
	
	public void registerEvents() {
		getServer().getPluginManager().registerEvents(new DataLoadEvent(), this);
	}

}
