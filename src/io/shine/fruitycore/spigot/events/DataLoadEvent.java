package io.shine.fruitycore.spigot.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.fruity.api.developper.manager.PlayerManager;
import net.fruity.api.developper.objects.PlayerProfile;
import net.fruity.api.developper.stockage.MemoryStockage;

public class DataLoadEvent implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		String uuid = e.getPlayer().getUniqueId().toString();
		MemoryStockage.players.put(uuid, PlayerManager.getPlayer(uuid));
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		String uuid = e.getPlayer().getUniqueId().toString();
		PlayerProfile pp = MemoryStockage.players.get(uuid);
		pp.saveRedis();
		MemoryStockage.players.remove(uuid);
	}

}
