package io.shine.fruitycore.bungee.events;

import net.fruity.api.developper.enums.Rank;
import net.fruity.api.developper.manager.PlayerManager;
import net.fruity.api.developper.objects.PlayerProfile;
import net.fruity.api.developper.stockage.MemoryStockage;
import net.fruity.api.developper.stockage.MySQL;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class DataBungeeLoadEvent implements Listener {

	@EventHandler
	public void onProxyJoin(ServerConnectEvent e) {
		String uuid = e.getPlayer().getUniqueId().toString();
		if(!PlayerManager.isPlayerExist(uuid)) {
			MySQL sql = new MySQL();
			sql.connect();
			sql.executeSQL("INSERT INTO players (uuid) VALUES (\"" + uuid + "\")");
			sql.disconnect();
			PlayerProfile pp = new PlayerProfile(uuid, Rank.JOUEUR, 100);
			pp.saveRedis();
			MemoryStockage.players.put(uuid, pp);
			return;
		}else {
			MemoryStockage.players.put(uuid, PlayerManager.getPlayer(uuid));
			return;
		}
	}
}
