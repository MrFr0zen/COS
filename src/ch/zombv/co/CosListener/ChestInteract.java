package ch.zombv.co.CosListener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import ch.zombv.co.main.Main;

public class ChestInteract implements Listener {

	private Main plugin;
	
	public ChestInteract(Main main) {
		this.plugin = main;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		
	}

	@EventHandler
	public void onInt(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		ItemStack chest = new ItemStack(Material.CHEST);
		ItemMeta meta = chest.getItemMeta();
		meta.setDisplayName("§aCosmetik Menü");
		chest.setItemMeta(meta);
		
		ItemStack boots = new ItemStack(Material.GOLD_BOOTS);
		ItemMeta meta1 = boots.getItemMeta();
		meta1.setDisplayName("§cBoots");
		boots.setItemMeta(meta1);
		
		if(e.getItem() != null) {
		if(e.getItem().equals(chest)) {
			Inventory y = Bukkit.createInventory(null, 9, "§aExtra Menu");
		    y.setItem(1, boots);
		}
		}
	}
	
}
