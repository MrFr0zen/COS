package ch.zombv.co.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import ch.zombv.co.main.Main;

public class SetVillagerSpawn implements CommandExecutor {

	private Main plugin;
	
	public SetVillagerSpawn(Main main) {
		this.plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(args.length == 0) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				if(p.hasPermission("cos.setVSpawn")) {
				
				double x = p.getLocation().getX();
				double y = p.getLocation().getY();
				double z = p.getLocation().getZ();
				
				String world = p.getWorld().getName();
				
//				float yaw = p.getLocation().getYaw();
//				float pitch = p.getLocation().getPitch();
				
				plugin.getConfig().set("Dailies." + "VillagerLoc." + "x", x);
				plugin.getConfig().set("Dailies." + "VillagerLoc." + "y", y);
				plugin.getConfig().set("Dailies." + "VillagerLoc." + "z", z);
				plugin.getConfig().set("Dailies." + "VillagerLoc." + "world",world);
				plugin.saveConfig();
				
//				plugin.getConfig().set("Dailies." + "VillagerLoc.", "x" + x);
//				plugin.getConfig().set("Dailies." + "VillagerLoc.", "x" + x);
				p.sendMessage(plugin.pr + "Du hast den Villagerspawn gesetzt.");
			}
			}
		}
		return false;
	}

}
