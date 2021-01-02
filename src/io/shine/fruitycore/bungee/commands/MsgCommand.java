package io.shine.fruitycore.bungee.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

public class MsgCommand extends Command {

	public MsgCommand(String name) {
		super(name);
	}

	@Override
	public void execute(CommandSender s, String[] args) {
		if(args.length < 2) {
			s.sendMessage(new TextComponent("§cErreur >> /msg [Joueur] [Message]"));
			return;
		}else {
			
		}
	}

}
