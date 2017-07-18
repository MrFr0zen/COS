package ch.zombv.co.CosListener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import ch.zombv.co.main.Main;

public class JoinEvent implements Listener {

	
	private Main plugin;
	
	public JoinEvent(Main main) {
		this.plugin = main;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
				String UUID = p.getUniqueId().toString();
		ItemStack invop = new ItemStack(Material.CHEST);
		ItemMeta meta = invop.getItemMeta();
		meta.setDisplayName("§6Cosmetics");
		invop.setItemMeta(meta);
		if(!Main.getInstance().getCoinsapi().existCoinsPlayer(UUID)) {
			Main.getInstance().getCoinsapi().createCoinsPlayer(UUID);
		}
		
		if(!Main.getInstance().getChestapi().existChestPlayer(UUID)) {
			Main.getInstance().getChestapi().createChestPlayer(UUID);
		}
		if(!Main.getInstance().getCosAPI().existCosmeticsPlayer(UUID)) {
			Main.getInstance().getCosAPI().createCosmeticsPlayer(UUID);
		} 
		p.getInventory().setItem(0, invop);
	}
}
