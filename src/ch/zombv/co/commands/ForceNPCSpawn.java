package ch.zombv.co.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import ch.zombv.co.main.Main;


public class ForceNPCSpawn implements CommandExecutor {

	private Main plugin;
	
	public ForceNPCSpawn(Main main) {
		this.plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			
		Player p = (Player) sender;
		
		if(args.length == 0) {
			if(p.hasPermission("COS.vspawnforce")) {
			
			if(!(plugin.getConfig().getString("Dailies." + "VillagerLoc." + "world") == null)) {
				
				for(Entity e : Bukkit.getWorld(p.getWorld().getName()).getEntities()) {
					if(e.getType().equals(EntityType.VILLAGER)) {
				    e.remove();
					}
				}
				
				double x = plugin.getConfig().getDouble("Dailies." + "VillagerLoc." + "x");
				double y = plugin.getConfig().getDouble("Dailies." + "VillagerLoc." + "y");
				double z = plugin.getConfig().getDouble("Dailies." + "VillagerLoc." + "z");
				
				String world = plugin.getConfig().getString("Dailies." + "VillagerLoc." + "world");
				
				Location loc = new Location(Bukkit.getWorld(world), x, y, z);
				
				Villager s = (Villager) Bukkit.getWorld(world).spawnCreature(loc, CreatureType.VILLAGER);
				
				s.setCustomName("§6Itemshop");
				s.setCustomNameVisible(true);
				s.setNoDamageTicks(200000000);
				s.setFireTicks(20*10);
				s.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 50));
				
				Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
				    public void run() {
				        s.teleport(loc);
				    }
				}, 0, 100);
				
			}
		}
		}
	}
		
		return false;
	}

}
