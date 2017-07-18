package ch.zombv.co.CosListener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;

import ch.zombv.co.main.Main;

public class ISVillagerInteractEvent implements Listener {

	private Main plugin;
	
	public ISVillagerInteractEvent(Main main) {
		this.plugin = main;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onInt(PlayerInteractEntityEvent e) {
		Player p = e.getPlayer();
		Entity ent = e.getRightClicked();
		
		if(ent.getType().equals(EntityType.VILLAGER)) {
			if(ent.getCustomName().equalsIgnoreCase("§aItemshop"));
			Inventory IS = Bukkit.createInventory(null, 9, "§aItemshop");
			
			p.openInventory(IS);
		}
	}
}
