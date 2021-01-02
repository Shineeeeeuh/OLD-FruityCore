package io.shine.fruitycore.bungee;

import io.shine.fruitycore.bungee.commands.HubCommand;
import io.shine.fruitycore.bungee.commands.SetRankCommand;
import io.shine.fruitycore.bungee.events.DataBungeeLoadEvent;
import net.md_5.bungee.api.plugin.Plugin;

public class CoreBungee extends Plugin{
	
	@Override
	public void onEnable() {
		registerEvents();
		registerCommands();
	}
	
	public void registerCommands() {
		getProxy().getPluginManager().registerCommand(this, new HubCommand("hub"));
		getProxy().getPluginManager().registerCommand(this, new HubCommand("lobby"));
		getProxy().getPluginManager().registerCommand(this, new SetRankCommand("setrank"));
	}
	
	public void registerEvents() {
		getProxy().getPluginManager().registerListener(this, new DataBungeeLoadEvent());
	}

}
