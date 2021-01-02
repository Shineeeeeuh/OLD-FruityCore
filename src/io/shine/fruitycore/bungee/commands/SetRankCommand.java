package io.shine.fruitycore.bungee.commands;

import net.fruity.api.developper.enums.Rank;
import net.fruity.api.developper.objects.PlayerProfile;
import net.fruity.api.developper.stockage.MemoryStockage;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class SetRankCommand extends Command {

	public SetRankCommand(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender s, String[] args) {
		ProxiedPlayer p = ProxyServer.getInstance().getPlayer(s.getName());
		PlayerProfile pp = MemoryStockage.players.get(p.getUniqueId().toString());
		if(pp.getRank().isAdminPermission()) {
			if(args.length < 2) {
				s.sendMessage(new TextComponent("§c§lErreur §c>> /setrank [Joueur] [Rank ID]"));
				return;
			}else {
				if(ProxyServer.getInstance().getPlayer(args[0]) == null) {
					s.sendMessage(new TextComponent("§c§lErreur §c>> Ce joueur n'est pas connecté !"));
					return;
				}else {
					if(!isNumeric(args[1])) {
						s.sendMessage(new TextComponent("§c§lErreur §c>> L'ID du Rank que vous avez saisi n'es pas un nombre !"));
						return;
					}else {
						ProxiedPlayer p2 = ProxyServer.getInstance().getPlayer(args[0]);
						PlayerProfile pp2 = MemoryStockage.players.get(p2.getUniqueId().toString());
						boolean b = false;
						for(Rank r : Rank.values()) {
							if(r.getID() == Integer.parseInt(args[1])) {
								b = true;
								pp2.setRank(r);
								break;
							}
							continue;
						}
						if(!b) {
							s.sendMessage(new TextComponent("§c§lErreur §c>> Aucun rank à été trouver avec votre ID !"));
							return;
						}else {
							pp2.saveMySQL();
							pp2.saveRedis();
							s.sendMessage(new TextComponent("§6Fruity §e>> §6Vous avez changer le rang de §e"+args[1]+" §6avec succées !"));
							return;
						}
					}
				}
			}
		}else {
			s.sendMessage(new TextComponent("§c§lErreur §c>> Vous devez être Admin pour exécuter cette commande !"));
			return;
		}
	}
	
	public boolean isNumeric(String s) {
	    try {
	        int i = Integer.parseInt(s);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}

}
