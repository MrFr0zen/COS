package ch.zombv.co.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ch.zombv.co.main.Main;

public class CMDcoins implements CommandExecutor{
	
	private Main plugin;
	
	public CMDcoins(Main main) {
		this.plugin = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if(command.getName().equalsIgnoreCase("coins")) {
			if(sender instanceof Player) {
				Player p = (Player)sender;
					if(args.length == 0) {
						String UUID = p.getUniqueId().toString();
						
						p.sendMessage(Main.pr + " §aDu hast §6" + Main.getInstance().getCoinsapi().getCoins(UUID) + " §aCoins");
					
					} else {
						p.sendMessage(Main.pr +" §cBitte benutze nur §6/coins§c!");
				}																
			}
		}		
		return false;
	}
}

