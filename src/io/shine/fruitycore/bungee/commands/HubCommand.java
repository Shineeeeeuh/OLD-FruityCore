package io.shine.fruitycore.bungee.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class HubCommand extends Command {

	public HubCommand(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender s, String[] args) {
		ProxiedPlayer p = ProxyServer.getInstance().getPlayer(s.getName());
		if (p.getServer().getInfo().getName().equalsIgnoreCase("lobby")) {
			s.sendMessage(new TextComponent("§c§lErreur §c>> Vous êtes déjà au hub !"));
			return;
		}else {
			p.connect(ProxyServer.getInstance().getServerInfo("lobby"));
			s.sendMessage(new TextComponent("§6Fruity §e>> §6Téléportation au Hub !"));
		}
	}

}
