package ch.zombv.co.CosListener;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import ch.zombv.co.main.Main;

public class ChestBlockEvent implements Listener {

	private Main plugin;

	public ChestBlockEvent(Main main) {
		this.plugin = main;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {

			if (e.getClickedBlock().getType().equals(Material.CHEST)) {

				Player p = e.getPlayer();

				Location loc = e.getClickedBlock().getLocation();

				loc.setY(loc.getY() - 1);

				Block b = loc.getBlock();

				if (b.getType().equals(Material.HARD_CLAY)) {

					Inventory inv = Bukkit.createInventory(null, 27, "§cBronzechest");

					ItemStack item = new ItemStack(Material.GOLD_INGOT);
					ItemMeta meta = item.getItemMeta();
					meta.setDisplayName("§aKiste kaufen für §61000 §aCoins.");
					item.setItemMeta(meta);
					
					ItemStack c = new ItemStack(Material.PAPER);
					ItemMeta metac = c.getItemMeta();
					metac.setDisplayName("§aDu hast §6" + Main.getInstance().getCoinsapi().getCoins(p.getUniqueId().toString()) + " §aCoins.");
					c.setItemMeta(metac);

					ItemStack items = new ItemStack(Material.CHEST);
					ItemMeta metas = items.getItemMeta();
					List<String> lore = new ArrayList<String>();
					lore.add("§r§7Du besitzt §6" + Main.getInstance().getChestapi().getChests(p.getUniqueId().toString(), "Bronze") + " §cBronzekisten§7.");
					metas.setLore(lore);
					metas.setDisplayName("§cBronzekiste §aöffnen");
					items.setItemMeta(metas);

					inv.setItem(13, items);
					inv.setItem(10, item);
					inv.setItem(16, c);

					e.setCancelled(true);

					p.closeInventory();

					p.openInventory(inv);

				} else if (b.getType().equals(Material.IRON_BLOCK)) {

					Inventory inv = Bukkit.createInventory(null, 27, "Silverchest");

					ItemStack item = new ItemStack(Material.GOLD_INGOT);
					ItemMeta meta = item.getItemMeta();
					meta.setDisplayName("§aKiste kaufen für §62500 §aCoins.");
					item.setItemMeta(meta);
					
					ItemStack c = new ItemStack(Material.PAPER);
					ItemMeta metac = c.getItemMeta();
					metac.setDisplayName("§aDu hast §6" + Main.getInstance().getCoinsapi().getCoins(p.getUniqueId().toString()) + " §aCoins.");
					c.setItemMeta(metac);

					ItemStack items = new ItemStack(Material.CHEST);
					ItemMeta metas = items.getItemMeta();
					List<String> lore = new ArrayList<String>();
					lore.add("§r§7Du besitzt §6" + Main.getInstance().getChestapi().getChests(p.getUniqueId().toString(), "Silver") + " §rSilberkiste(n)§7.");
					metas.setLore(lore);
					metas.setDisplayName("§rSilberkiste §aöffnen");
					items.setItemMeta(metas);

					inv.setItem(13, items);
					inv.setItem(10, item);
					inv.setItem(16, c);

					e.setCancelled(true);

					p.closeInventory();

					p.openInventory(inv);

				} else if (b.getType().equals(Material.GOLD_BLOCK)) {

					Inventory inv = Bukkit.createInventory(null, 27, "§6Goldchest");

					ItemStack item = new ItemStack(Material.PAPER);
					ItemMeta meta = item.getItemMeta();
					meta.setDisplayName("§eKistlein kaufen");
					item.setItemMeta(meta);

					inv.setItem(0, item);

					e.setCancelled(true);

					p.closeInventory();

					p.openInventory(inv);

				} else if (b.getType().equals(Material.EMERALD_BLOCK)) {

					Inventory inv = Bukkit.createInventory(null, 27, "§aSmaragdchest");

					ItemStack item = new ItemStack(Material.PAPER);
					ItemMeta meta = item.getItemMeta();
					meta.setDisplayName("§eKistlein kaufen");
					item.setItemMeta(meta);

					inv.setItem(0, item);

					e.setCancelled(true);

					p.closeInventory();

					p.openInventory(inv);

				} else if (b.getType().equals(Material.DIAMOND_BLOCK)) {

					Inventory inv = Bukkit.createInventory(null, 27, "§bDiamantchest");

					ItemStack item = new ItemStack(Material.PAPER);
					ItemMeta meta = item.getItemMeta();
					meta.setDisplayName("§eKistlein kaufen");
					item.setItemMeta(meta);

					inv.setItem(0, item);

					e.setCancelled(true);

					p.closeInventory();

					p.openInventory(inv);

					 } else if(b.getType().equals(Material.QUARTZ_BLOCK)) {
					
					 Inventory inv = Bukkit.createInventory(null, 27, "§8Platinkiste");
					 e.setCancelled(true);
					 p.closeInventory();
					
					 p.openInventory(inv);

				} else if (b.getType().equals(Material.BEACON)) {

					Inventory inv = Bukkit.createInventory(null, 27, "§dLegendäre Kiste");

					ItemStack item = new ItemStack(Material.PAPER);
					ItemMeta meta = item.getItemMeta();
					meta.setDisplayName("§eKistlein kaufen");
					item.setItemMeta(meta);

					inv.setItem(0, item);

					e.setCancelled(true);

					p.closeInventory();

					p.openInventory(inv);

				}
			}
		}
	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {

		Player p = (Player) e.getWhoClicked();

		if (e.getInventory().getName().equals("§cBronzechest")) {

			ItemStack item = new ItemStack(Material.GOLD_INGOT);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§aKiste kaufen für §61000 §aCoins.");
			item.setItemMeta(meta);
			
			ItemStack c = new ItemStack(Material.PAPER);
			ItemMeta metac = c.getItemMeta();
			metac.setDisplayName("§aDu hast §6" + Main.getInstance().getCoinsapi().getCoins(p.getUniqueId().toString()) + " §aCoins.");
			c.setItemMeta(metac);
			
			ItemStack items = new ItemStack(Material.CHEST);
			ItemMeta metas = items.getItemMeta();
			List<String> lore = new ArrayList<String>();
			lore.add("§r§7Du besitzt §6" + Main.getInstance().getChestapi().getChests(p.getUniqueId().toString(), "Bronze") + " §cBronzekiste(n)§7.");
			metas.setLore(lore);
			metas.setDisplayName("§cBronzekiste §aöffnen");
			items.setItemMeta(metas);
			
			p.closeInventory();
		
			
			if (e.getCurrentItem().equals(item)) {
				
				ItemStack i = new ItemStack(Material.STAINED_CLAY, 1, DyeColor.GREEN.getData());
				ItemMeta m = i.getItemMeta();
				m.setDisplayName("§aOK");
				i.setItemMeta(m);
				
				ItemStack ca = new ItemStack(Material.PAPER);
				ItemMeta metaca = ca.getItemMeta();
				metaca.setDisplayName("§65000 §aCoins");
				ca.setItemMeta(metaca);
				
				ItemStack ite = new ItemStack(Material.STAINED_CLAY, 1, DyeColor.RED.getData());
				ItemMeta me = ite.getItemMeta();
				me.setDisplayName("§cNEIN");
				ite.setItemMeta(me);
				
				Inventory inv = Bukkit.createInventory(null, 27, "§4Kaufbestätigung: §cBronzekiste");
				
				inv.setItem(11, ite);
				inv.setItem(13, ca);
				inv.setItem(15, i);
				
				p.openInventory(inv);
				
				
		 } else if(e.getCurrentItem().equals(items)) {
			 
			 if(Main.getInstance().getChestapi().getChests(p.getUniqueId().toString(), "Bronze") > 0) {
				 int rarityRandom = (int) (Math.random() * 999);
				 
				 if(rarityRandom < 500) {
					 //bronze
					 
				 } else if(rarityRandom > 499 && rarityRandom < 800) {
					  //silver
				 } else if(rarityRandom > 799 && rarityRandom < 900) {
					 //gold
				 } else if(rarityRandom > 899 && rarityRandom < 950) {
					 //smaragd
				 } else if(rarityRandom > 949 && rarityRandom < 975) {
					 //diamant
				 } else if(rarityRandom > 974 && rarityRandom < 990) {
					 //platin
				 } else if(rarityRandom > 989 && rarityRandom < 1000) {
					 //legendary
				 }
			 }
			 p.closeInventory();
			 
		 }
			
			
			} else if(e.getInventory().getName().equals("§4Kaufbestätigung: §cBronzekiste")) {
				
				p.closeInventory();
				
				ItemStack i = new ItemStack(Material.STAINED_CLAY, 1, DyeColor.GREEN.getData());
				ItemMeta m = i.getItemMeta();
				m.setDisplayName("§aOK");
				i.setItemMeta(m);
				
				ItemStack ca = new ItemStack(Material.PAPER);
				ItemMeta metaca = ca.getItemMeta();
				metaca.setDisplayName("§61000 §aCoins");
				ca.setItemMeta(metaca);
				
				ItemStack ite = new ItemStack(Material.STAINED_CLAY, 1, DyeColor.RED.getData());
				ItemMeta me = ite.getItemMeta();
				me.setDisplayName("§cNEIN");
				ite.setItemMeta(me);
				
				  if(e.getCurrentItem().equals(i)) {
						
						
						if(Main.getInstance().getCoinsapi().getCoins(p.getUniqueId().toString()) >= 1000) {
							
							Main.getInstance().getCoinsapi().setCoins(p.getUniqueId().toString(), Main.getInstance().getCoinsapi().getCoins(p.getUniqueId().toString()) - 1000);
							Main.getInstance().getChestapi().addChests(p.getUniqueId().toString(), "Bronze", 1);
							
							p.sendMessage(Main.pr + " §aDu hast eine §cBronzekiste §agekauft.");
							
						} else {
							
							long fehlende = 1000 - Main.getInstance().getCoinsapi().getCoins(p.getUniqueId().toString());
							
							p.sendMessage(Main.pr + " §cDu hast nicht genügend Coins um diese Kiste zu kaufen.");
							p.sendMessage("§cDu besitzt §6" + Main.getInstance().getCoinsapi().getCoins(p.getUniqueId().toString()) + " §cCoin(s), benötigte Coins: §61000§c. Dir fehlen noch §6" + fehlende + " §cCoin(s).");
							
						}
				  }
			} else if (e.getInventory().getName().equals("Silverchest")) {

				ItemStack item = new ItemStack(Material.GOLD_INGOT);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName("§aKiste kaufen für §62500 §aCoins.");
				item.setItemMeta(meta);
				
				ItemStack c = new ItemStack(Material.PAPER);
				ItemMeta metac = c.getItemMeta();
				metac.setDisplayName("§aDu hast §6" + Main.getInstance().getCoinsapi().getCoins(p.getUniqueId().toString()) + " §aCoins.");
				c.setItemMeta(metac);
				
				ItemStack items = new ItemStack(Material.CHEST);
				ItemMeta metas = items.getItemMeta();
				List<String> lore = new ArrayList<String>();
				lore.add("§r§7Du besitzt §6" + Main.getInstance().getChestapi().getChests(p.getUniqueId().toString(), "Silver") + " §rSilberkiste(n)§7.");
				metas.setLore(lore);
				metas.setDisplayName("Silberkiste §aöffnen");
				items.setItemMeta(metas);
				
				p.closeInventory();
			
				
				if (e.getCurrentItem().equals(item)) {
					
					ItemStack i = new ItemStack(Material.STAINED_CLAY, 1, DyeColor.GREEN.getData());
					ItemMeta m = i.getItemMeta();
					m.setDisplayName("§aOK");
					i.setItemMeta(m);
					
					ItemStack ca = new ItemStack(Material.PAPER);
					ItemMeta metaca = ca.getItemMeta();
					metaca.setDisplayName("§62500 §aCoins");
					ca.setItemMeta(metaca);
					
					ItemStack ite = new ItemStack(Material.STAINED_CLAY, 1, DyeColor.RED.getData());
					ItemMeta me = ite.getItemMeta();
					me.setDisplayName("§cNEIN");
					ite.setItemMeta(me);
					
					Inventory inv = Bukkit.createInventory(null, 27, "§4Kaufbestätigung: §rSilberkiste");
					
					inv.setItem(11, ite);
					inv.setItem(13, ca);
					inv.setItem(15, i);
					
					p.openInventory(inv);
					
					
					} 
				} else if(e.getInventory().getName().equals("§4Kaufbestätigung: §rSilberkiste")) {
					
					p.closeInventory();
					
					ItemStack i = new ItemStack(Material.STAINED_CLAY, 1, DyeColor.GREEN.getData());
					ItemMeta m = i.getItemMeta();
					m.setDisplayName("§aOK");
					i.setItemMeta(m);
					
					ItemStack ca = new ItemStack(Material.PAPER);
					ItemMeta metaca = ca.getItemMeta();
					metaca.setDisplayName("§62500 §aCoins");
					ca.setItemMeta(metaca);
					
					ItemStack ite = new ItemStack(Material.STAINED_CLAY, 1, DyeColor.RED.getData());
					ItemMeta me = ite.getItemMeta();
					me.setDisplayName("§cNEIN");
					ite.setItemMeta(me);
					
					  if(e.getCurrentItem().equals(i)) {
							
							
							if(Main.getInstance().getCoinsapi().getCoins(p.getUniqueId().toString()) >= 2500) {
								
								Main.getInstance().getCoinsapi().setCoins(p.getUniqueId().toString(), Main.getInstance().getCoinsapi().getCoins(p.getUniqueId().toString()) - 2500);
								Main.getInstance().getChestapi().addChests(p.getUniqueId().toString(), "Silver", 1);
								
								p.sendMessage(Main.pr + " §aDu hast eine Silberkiste gekauft.");
								
							} else {
								
								long fehlende = 2500 - Main.getInstance().getCoinsapi().getCoins(p.getUniqueId().toString());
								
								p.sendMessage(Main.pr + " §cDu hast nicht genügend Coins um diese Kiste zu kaufen.");
								p.sendMessage("§cDu besitzt §6" + Main.getInstance().getCoinsapi().getCoins(p.getUniqueId().toString()) + " §cCoin(s), benötigte Coins: §62500§c. Dir fehlen noch §6" + fehlende + " §cCoin(s).");
								
							}
							
							
					  } } else if (e.getInventory().getName().equals("Silverchest")) {

							ItemStack item = new ItemStack(Material.GOLD_INGOT);
							ItemMeta meta = item.getItemMeta();
							meta.setDisplayName("§aKiste kaufen für §62500 §aCoins.");
							item.setItemMeta(meta);
							
							ItemStack c = new ItemStack(Material.PAPER);
							ItemMeta metac = c.getItemMeta();
							metac.setDisplayName("§aDu hast §6" + Main.getInstance().getCoinsapi().getCoins(p.getUniqueId().toString()) + " §aCoins.");
							c.setItemMeta(metac);
							
							ItemStack items = new ItemStack(Material.CHEST);
							ItemMeta metas = items.getItemMeta();
							List<String> lore = new ArrayList<String>();
							lore.add("§r§7Du besitzt §6" + Main.getInstance().getChestapi().getChests(p.getUniqueId().toString(), "Silver") + " §rSilberkiste(n)§7.");
							metas.setLore(lore);
							metas.setDisplayName("Silberkiste §aöffnen");
							items.setItemMeta(metas);
							
							p.closeInventory();
						
							
							if (e.getCurrentItem().equals(item)) {
								
								ItemStack i = new ItemStack(Material.STAINED_CLAY, 1, DyeColor.GREEN.getData());
								ItemMeta m = i.getItemMeta();
								m.setDisplayName("§aOK");
								i.setItemMeta(m);
								
								ItemStack ca = new ItemStack(Material.PAPER);
								ItemMeta metaca = ca.getItemMeta();
								metaca.setDisplayName("§62500 §aCoins");
								ca.setItemMeta(metaca);
								
								ItemStack ite = new ItemStack(Material.STAINED_CLAY, 1, DyeColor.RED.getData());
								ItemMeta me = ite.getItemMeta();
								me.setDisplayName("§cNEIN");
								ite.setItemMeta(me);
								
								Inventory inv = Bukkit.createInventory(null, 27, "§4Kaufbestätigung: §rSilberkiste");
								
								inv.setItem(11, ite);
								inv.setItem(13, ca);
								inv.setItem(15, i);
								
								p.openInventory(inv);
								
								
								} 
							} else if(e.getInventory().getName().equals("§4Kaufbestätigung: §rSilberkiste")) {
								
								p.closeInventory();
								
								ItemStack i = new ItemStack(Material.STAINED_CLAY, 1, DyeColor.GREEN.getData());
								ItemMeta m = i.getItemMeta();
								m.setDisplayName("§aOK");
								i.setItemMeta(m);
								
								ItemStack ca = new ItemStack(Material.PAPER);
								ItemMeta metaca = ca.getItemMeta();
								metaca.setDisplayName("§62500 §aCoins");
								ca.setItemMeta(metaca);
								
								ItemStack ite = new ItemStack(Material.STAINED_CLAY, 1, DyeColor.RED.getData());
								ItemMeta me = ite.getItemMeta();
								me.setDisplayName("§cNEIN");
								ite.setItemMeta(me);
								
								  if(e.getCurrentItem().equals(i)) {
										
										
										if(Main.getInstance().getCoinsapi().getCoins(p.getUniqueId().toString()) >= 2500) {
											
											Main.getInstance().getCoinsapi().setCoins(p.getUniqueId().toString(), Main.getInstance().getCoinsapi().getCoins(p.getUniqueId().toString()) - 2500);
											Main.getInstance().getChestapi().addChests(p.getUniqueId().toString(), "Silver", 1);
											
											p.sendMessage(Main.pr + " §aDu hast eine Silberkiste gekauft.");
											
										} else {
											
											long fehlende = 2500 - Main.getInstance().getCoinsapi().getCoins(p.getUniqueId().toString());
											
											p.sendMessage(Main.pr + " §cDu hast nicht genügend Coins um diese Kiste zu kaufen.");
											p.sendMessage("§cDu besitzt §6" + Main.getInstance().getCoinsapi().getCoins(p.getUniqueId().toString()) + " §cCoin(s), benötigte Coins: §62500§c. Dir fehlen noch §6" + fehlende + " §cCoin(s).");
											
										}
								  }
								  
							}
				 

			e.setCancelled(true);

		}

	}

//if(Main.getInstance().getCoinsapi().getCoins(p.getUniqueId().toString()) >= 1000) {
//	
//	Main.getInstance().getCoinsapi().setCoins(p.getUniqueId().toString(), Main.getInstance().getCoinsapi().getCoins(p.getUniqueId().toString()) - 1000);
//	Main.getInstance().getChestapi().addChests(p.getUniqueId().toString(), "Bronze", 1);
//	
//	p.sendMessage(Main.pr + "§aDu hast eine §cBronzekiste §agekauft.");
//	
//} else {
//	
//	long fehlende = 1000 - Main.getInstance().getCoinsapi().getCoins(p.getUniqueId().toString());
//	
//	p.sendMessage(Main.pr + " §cDu hast nicht genügend Coins um diese Kiste zu kaufen.");
//	p.sendMessage("§cDu besitzt §6" + Main.getInstance().getCoinsapi().getCoins(p.getUniqueId().toString()) + " §cCoin(s), benötigte Coins: §61000§c. Dir fehlen noch §6" + fehlende + " §cCoin(s).");
//	
//}