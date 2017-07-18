package ch.zombv.co.CosListener;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Guardian;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.entity.Spider;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import ch.zombv.co.main.Main;

public class MenuOpenInt implements Listener {

	private Main plugin;
	
	public MenuOpenInt(Main main) {
		this.plugin = main;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		
	}
	
	@EventHandler
	public void onInt(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		
		
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {

			ItemStack invop = new ItemStack(Material.CHEST);
			ItemMeta meta = invop.getItemMeta();
			meta.setDisplayName("§6Cosmetics");
			invop.setItemMeta(meta);
			
			if(e.getItem() != null) {
			if(e.getItem().equals(invop)) {
				e.setCancelled(true);
				
				ItemStack mounts = new ItemStack(Material.SADDLE);
				ItemMeta mmeta = mounts.getItemMeta();
				mmeta.setDisplayName("§4Mounts");
				mounts.setItemMeta(mmeta);
				
				Inventory inv = Bukkit.createInventory(null, 27, "§6Cosmetics");
				ItemStack boots = new ItemStack(Material.GOLD_BOOTS);
				ItemMeta meta1 = boots.getItemMeta();
				meta1.setDisplayName("§cBoots");
				boots.setItemMeta(meta1);
			 
				inv.setItem(2, boots);
				inv.setItem(1, mounts);
				p.openInventory(inv);
			}
			}
		}
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Inventory inv = e.getClickedInventory();
		Player p = (Player) e.getWhoClicked();
		ItemStack i = e.getCurrentItem();
		
		
		ItemStack mounts = new ItemStack(Material.SADDLE);
		ItemMeta mmeta = mounts.getItemMeta();
		mmeta.setDisplayName("§4Mounts");
		mounts.setItemMeta(mmeta);
		
		ItemStack boots = new ItemStack(Material.GOLD_BOOTS);
		ItemMeta meta1 = boots.getItemMeta();
		meta1.setDisplayName("§cBoots");
		boots.setItemMeta(meta1);
		
		Inventory inv2 = Bukkit.createInventory(null, 9, "§4Mounts");
		if(inv.getName().equals("§6Cosmetics") || inv.getName().equals("§4Mounts") || inv.getName().equals("§cBoots")) {
			e.setCancelled(true);
			
			if(i.equals(mounts)) {
				
			
			p.closeInventory();
			
			Main.getInstance().setMount(inv2, 1, 0);
			Main.getInstance().setMount(inv2, 2, 1);
			Main.getInstance().setMount(inv2, 3, 2);
			Main.getInstance().setMount(inv2, 4, 3);
			Main.getInstance().setMount(inv2, 9, 4);
			Main.getInstance().setMount(inv2, 5, 5);
			Main.getInstance().setMount(inv2, 6, 6);
			Main.getInstance().setMount(inv2, 7, 7);
			Main.getInstance().setMount(inv2, 8, 8);
			
			p.openInventory(inv2);
			
			} else if(i.equals(boots)) {
				

				
				Inventory invi = Bukkit.createInventory(null, 9, "§cBoots"); 
				
				ItemStack isi = new ItemStack(Material.LEATHER_BOOTS);
				LeatherArmorMeta meta = (LeatherArmorMeta) isi.getItemMeta();
				meta.setColor(Color.RED);
				meta.setDisplayName("§4Loveboots");
				List<String> lore = new ArrayList<String>();
				lore.add("nope");
				meta.setLore(lore);
				isi.setItemMeta(meta);
				
				p.closeInventory();
				
				invi.setItem(0, isi);
				
				p.openInventory(invi);
				
				
			}
		}
		
		if(inv.getName().equals("§4Mounts")) {
			
			e.setCancelled(true);
			
//			if(!(plugin.getConfig().getString("Cosmetics." + "Items." + i.getItemMeta().getDisplayName().replace("&", "§") + ".Seltenheit") == null)) {
//				
//				String s = plugin.getConfig().getString("Cosmetics." + "Items." + i.getItemMeta().getDisplayName().replace("&", "§"));
				

			if(i.getItemMeta().getDisplayName().equals("§aEnderdragon")) {
				

				EnderDragon ed = (EnderDragon) p.getWorld().spawnEntity(p.getLocation(), EntityType.ENDER_DRAGON);
				
				ed.setPassenger(p);
			}
			
			else	if(i.getItemMeta().getDisplayName().equals("§aHorse")) {
				

				Horse ed = (Horse) p.getWorld().spawnEntity(p.getLocation(), EntityType.HORSE);
				
				ed.setPassenger(p);
			}
			
			else	if(i.getItemMeta().getDisplayName().equals("§aPig")) {
				

				Pig ed = (Pig) p.getWorld().spawnEntity(p.getLocation(), EntityType.PIG);
				
				ed.setSaddle(true);
				
				ed.setPassenger(p);
				
				p.getInventory().setItem(2, new ItemStack(Material.CARROT_STICK));
			}
			
			else	if(i.getItemMeta().getDisplayName().equals("§aBlaze")) {
				

				Blaze ed = (Blaze) p.getWorld().spawnEntity(p.getLocation(), EntityType.BLAZE);
				
				ed.setPassenger(p);
			}
			
			else	if(i.getItemMeta().getDisplayName().equals("§aChicken")) {
		
	
				Chicken ed = (Chicken) p.getWorld().spawnEntity(p.getLocation(), EntityType.CHICKEN);
		
				ed.setPassenger(p);
			}

			else	if(i.getItemMeta().getDisplayName().equals("§aSpider")) {
				

				Spider ed = (Spider) p.getWorld().spawnEntity(p.getLocation(), EntityType.SPIDER);
				
				ed.setPassenger(p);
			}
			

			else	if(i.getItemMeta().getDisplayName().equals("§aGuardian")) {
				

				Guardian ed = (Guardian) p.getWorld().spawnEntity(p.getLocation(), EntityType.GUARDIAN);
				
				ed.setPassenger(p);
			}


			else	if(i.getItemMeta().getDisplayName().equals("§aCart")) {
				

				Minecart ed = (Minecart) p.getWorld().spawnEntity(p.getLocation(), EntityType.MINECART);
				
				ed.setPassenger(p);
			}
			


			else	if(i.getItemMeta().getDisplayName().equals("§aBoat")) {
				

				Boat ed = (Boat) p.getWorld().spawnEntity(p.getLocation(), EntityType.BOAT);
				
				ed.setPassenger(p);
			}
			

			else	if(i.getItemMeta().getDisplayName().equals("§aEnderpearl")) {
				

				EnderPearl ed = (EnderPearl) p.getWorld().spawnEntity(p.getLocation(), EntityType.ENDER_PEARL);
				
				ed.setPassenger(p);
			}
			
		}
	}
}













