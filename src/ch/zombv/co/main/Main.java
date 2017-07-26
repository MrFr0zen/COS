package ch.zombv.co.main;


import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import ch.zombv.co.CosListener.ChestBlockEvent;
import ch.zombv.co.CosListener.ChestInteract;
import ch.zombv.co.CosListener.ISVillagerInteractEvent;
import ch.zombv.co.CosListener.JoinEvent;
import ch.zombv.co.CosListener.MenuOpenInt;
import ch.zombv.co.commands.CMDaddcoins;
import ch.zombv.co.commands.CMDcoins;
import ch.zombv.co.commands.ForceNPCSpawn;
import ch.zombv.co.commands.SetVillagerSpawn;

public class Main extends JavaPlugin {
	
	
	private static Main instance;
	private MySQL mysql;
	private CoinsAPI coinsApi;
	private ChestAPI chestApi;
	private CosAPI cosApi;
	private KitAPI kitApi;

	public static final String pr = "§5Loopmc §7>>";

	public int sBronze = 500;
	public int sSilver = 1250;
	public int sGold = 2500;
	public int sSmaragd = 5000;
	public int sDiamant = 12500;
	public int sPlatin = 50000;
	public int sLegendary = 125000;
	
	public int bBronze = 1000;
	public int bSilver = 2500;
	public int bGold = 5000;
	public int bSmaragd = 10000;
	public int bDiamant = 25000;
	public int bPlatin = 100000;
	public int bLegendary = 250000;

	  public void log(String log) {
		    Bukkit.getConsoleSender().sendMessage(log);
		  }


		  public MySQL getMysql() {
		    return this.mysql;
		  }
		  public  CoinsAPI getCoinsapi() { 
				return this.coinsApi;
			}
		  public  ChestAPI getChestapi() { 
				return this.chestApi;
			}
		  public CosAPI getCosAPI() {
			  return this.cosApi;
		  }
		  public KitAPI getKitAPI() {
			  return this.kitApi;
		  }
	
	public void onEnable(){
		System.out.println("[Cosmetics] Das Plugin wurde gestarted");
		
		instance = this; 
		
		registerEvents();
		registerCommands();
		loadMountDetails();
	    mysql = new MySQL();
	    mysql.connect();
	    mysql.CreateCosTable();
	    mysql.createCoinsTable();
	    mysql.createChestsTable();
	    mysql.createKitTable();
	    coinsApi = new CoinsAPI();
	    coinsApi.setMysql(mysql);
	    chestApi = new ChestAPI();
	    chestApi.setMysql(mysql);
	    cosApi = new CosAPI();
	    cosApi.setMysql(mysql);
	    kitApi = new KitAPI();
	    kitApi.setMysql(mysql);

	    
	}


	private void registerEvents() {
		new ChestInteract(this);
		new ISVillagerInteractEvent(this);
		new MenuOpenInt(this);
		new JoinEvent(this);
		new ChestBlockEvent(this);
	}
	
	public void registerCommands() {

		CMDcoins cCMDcoins = new CMDcoins(this);
	    getCommand("Coins").setExecutor(cCMDcoins);

		CMDaddcoins cCMDaddcoins = new CMDaddcoins(this);
	    getCommand("addCoins").setExecutor(cCMDaddcoins);
	    
	    SetVillagerSpawn cSetVillagerSpawn = new SetVillagerSpawn(this);
	    getCommand("SetVSpawn").setExecutor(cSetVillagerSpawn);
	    
	    ForceNPCSpawn cForceNPCSpawn = new ForceNPCSpawn(this);
	    getCommand("ForceNPCSpawn").setExecutor(cForceNPCSpawn);

        
	}
	
	
	
	
	
	// Methoden
	
	
	
	public void setStuff(ItemStack IS, String rarity, int SellPrice) {
		
		getConfig().set("Cosmetics." + "Items." + IS.getItemMeta().getDisplayName().replace("§", "&") + ".Seltenheit", rarity);
		getConfig().set("Cosmetics." + "Items." + IS.getItemMeta().getDisplayName().replace("§", "&") + ".Verkaufspreis", SellPrice);
		saveConfig();
		
	}
	
	public void getRarity(ItemStack IS, ItemMeta meta) {
		
			ArrayList<String> lore = new ArrayList<String>();
			
			if(!(getConfig().getString("Cosmetics." + "Items." + meta.getDisplayName().replace("§", "&") + ".Seltenheit") == null)) {
				
			String s = getConfig().getString("Cosmetics." + "Items." + meta.getDisplayName().replace("§", "&") + ".Seltenheit");
			
			lore.add("§r§7" + s.replace("&", "§"));
			meta.setLore(lore);
			IS.setItemMeta(meta);
			
			}
	}
	
	public void addItemToPlayer(Player p, ItemStack IS) {
		
		getConfig().set("Cosmetics." + "PlayerItems." + p.getName() + "." + IS.getItemMeta().getDisplayName().replace("§", "&") + ".RepPreis", 0);
		
	}
	
	public void getRepPrice(Player p, ItemStack IS) {
		getConfig().getInt("Cosmetics." + "PlayerItems." + p.getName() + "." + IS.getItemMeta().getDisplayName().replace("§", "&") + ".RepPreis");
	}
	
	public void setRepPrice(Player p, ItemStack IS, int repKosten) {
		getConfig().set("Cosmetics." + "PlayerItems." + p.getName() + "." + IS.getItemMeta().getDisplayName().replace("§", "&") + ".RepPreis", repKosten);
	}
	
	
	
	
	//Items:
	//Mounts:
	
public void setMount(Inventory inv, int item, int slot) {
		
	//1
		ItemStack edragon = new ItemStack(Material.EYE_OF_ENDER);         
		ItemMeta edragonmeta = edragon.getItemMeta();		
		edragonmeta.setDisplayName("§aEnderdragon");
		getRarity(edragon, edragonmeta);
		edragon.setItemMeta(edragonmeta);
		setStuff(edragon, "Platin", 50000);
		
		//2
		ItemStack horse = new ItemStack(Material.SADDLE);
		ItemMeta hmeta = horse.getItemMeta();		
		hmeta.setDisplayName("§aHorse");
		getRarity(horse, hmeta);
		horse.setItemMeta(hmeta);
		setStuff(horse, "Gold", 2500);
		
		//2
		ItemStack carrotstickpig = new ItemStack(Material.CARROT_STICK);
		ItemMeta cpigmeta = carrotstickpig.getItemMeta();
		cpigmeta.setDisplayName("§aPig");
		getRarity(carrotstickpig, cpigmeta);
		carrotstickpig.setItemMeta(cpigmeta);
		setStuff(carrotstickpig, "Smaragd", 5000);
//		3
		ItemStack blaze = new ItemStack(Material.BLAZE_ROD);
		ItemMeta blazemeta = blaze.getItemMeta();	
		blazemeta.setDisplayName("§aBlaze");
		getRarity(blaze, blazemeta);
		blaze.setItemMeta(blazemeta);
		setStuff(blaze, "Smaragd", 5000);
//		4
		ItemStack huhn = new ItemStack(Material.EGG);
		ItemMeta huhnmeta = huhn.getItemMeta();	
		huhnmeta.setDisplayName("§aChicken");
		getRarity(huhn, huhnmeta);
		huhn.setItemMeta(huhnmeta);
		setStuff(huhn, "Silver", 1250);
		//5
		ItemStack spider = new ItemStack(Material.WEB);
		ItemMeta spidermeta = spider.getItemMeta();	
		spidermeta.setDisplayName("§aSpider");
		getRarity(spider, spidermeta);
		spider.setItemMeta(spidermeta);
		setStuff(spider, "Gold", 2500);
//		6
		ItemStack guard = new ItemStack(Material.PRISMARINE_SHARD);
		ItemMeta guardmeta = guard.getItemMeta();	
		guardmeta.setDisplayName("§aGuardian");
		getRarity(guard, guardmeta);
		guard.setItemMeta(guardmeta);
		setStuff(guard, "Platin", 50000);
//		7
		ItemStack cart = new ItemStack(Material.MINECART);
		ItemMeta cartmeta = cart.getItemMeta();	
		cartmeta.setDisplayName("§aCart");
		getRarity(cart, cartmeta);
		cart.setItemMeta(cartmeta);
		setStuff(cart, "Smaragd", 5000);
//		8
		ItemStack boat = new ItemStack(Material.BOAT);
		ItemMeta boatmeta = boat.getItemMeta();
		boatmeta.setDisplayName("§aBoat");
		getRarity(boat, boatmeta);
		boat.setItemMeta(boatmeta);
		setStuff(boat, "Smaragd", 5000);
		
		ItemStack ep = new ItemStack(Material.ENDER_PEARL);
		ItemMeta epm = ep.getItemMeta();
		epm.setDisplayName("§aEnderpearl");
		getRarity(ep, epm);
		ep.setItemMeta(epm);
		setStuff(ep, "Smaragd", sSmaragd);
		
		if(item == 1) {
			inv.setItem(slot, edragon);
		}
		if(item == 2) {
			inv.setItem(slot, horse);
		}
		if(item == 3) {
			inv.setItem(slot, carrotstickpig);
		}
		if(item == 4) {
			inv.setItem(slot, huhn);
		}
		if(item == 5) {
			inv.setItem(slot, spider);
		}
		if(item == 6) {
			inv.setItem(slot, guard);
		}
		if(item == 7) {
			inv.setItem(slot, cart);	
		}
		if(item == 8) {
			inv.setItem(slot, boat);
		}
		
		if(item == 9) {
			inv.setItem(slot, ep);
		}
		
	}

	public void setPet(Inventory inv, int item, int slot) {
		
		ItemStack cat = new ItemStack(Material.ANVIL);
		ItemMeta catm = cat.getItemMeta();
		catm.setDisplayName("§bKatze");
		getRarity(cat, catm);
		cat.setItemMeta(catm);
		setStuff(cat, "Silber", sSilver);
		
	}

	public void loadMountDetails() {
		
		//1
			ItemStack edragon = new ItemStack(Material.EYE_OF_ENDER);         
			ItemMeta edragonmeta = edragon.getItemMeta();		
			edragonmeta.setDisplayName("§aEnderdragon");
//			getRarity(edragon);
			edragon.setItemMeta(edragonmeta);
			setStuff(edragon, "Platin", 50000);
			
			//2
			ItemStack horse = new ItemStack(Material.SADDLE);
			ItemMeta hmeta = horse.getItemMeta();		
			hmeta.setDisplayName("§aHorse");
			horse.setItemMeta(hmeta);
			setStuff(horse, "Gold", 2500);
			
			//2
			ItemStack carrotstickpig = new ItemStack(Material.CARROT_STICK);
			ItemMeta cpigmeta = carrotstickpig.getItemMeta();
			cpigmeta.setDisplayName("§aPig");
			carrotstickpig.setItemMeta(cpigmeta);
			setStuff(carrotstickpig, "Smaragd", 5000);
//			3
			ItemStack blaze = new ItemStack(Material.BLAZE_ROD);
			ItemMeta blazemeta = blaze.getItemMeta();	
			blazemeta.setDisplayName("§aBlaze");
			blaze.setItemMeta(blazemeta);
			setStuff(blaze, "Smaragd", 5000);
//			4
			ItemStack huhn = new ItemStack(Material.EGG);
			ItemMeta huhnmeta = huhn.getItemMeta();	
			huhnmeta.setDisplayName("§aChicken");
			huhn.setItemMeta(huhnmeta);
			setStuff(huhn, "Silver", 1250);
			//5
			ItemStack spider = new ItemStack(Material.WEB);
			ItemMeta spidermeta = spider.getItemMeta();	
			spidermeta.setDisplayName("§aSpider");
			spider.setItemMeta(spidermeta);
			setStuff(spider, "Gold", 2500);
//			6
			ItemStack guard = new ItemStack(Material.PRISMARINE_SHARD);
			ItemMeta guardmeta = guard.getItemMeta();	
			guardmeta.setDisplayName("§aGuardian");
			guard.setItemMeta(guardmeta);
			setStuff(guard, "Platin", 50000);
//			7
			ItemStack cart = new ItemStack(Material.MINECART);
			ItemMeta cartmeta = cart.getItemMeta();	
			cartmeta.setDisplayName("§aCart");
			cart.setItemMeta(cartmeta);
			setStuff(cart, "Smaragd", 5000);
//			8
			ItemStack boat = new ItemStack(Material.BOAT);
			ItemMeta boatmeta = boat.getItemMeta();
			boatmeta.setDisplayName("§aBoat");
			boat.setItemMeta(boatmeta);
			setStuff(boat, "Smaragd", 5000);
			
			ItemStack ep = new ItemStack(Material.ENDER_PEARL);
			ItemMeta epm = ep.getItemMeta();
			epm.setDisplayName("§aEnderpearl");
			ep.setItemMeta(epm);
			setStuff(ep, "Smaragd", sSmaragd);
	
	}

		public void loadPetDetails() {
			
			
			
		}
	
	public static Main getInstance() {
		return instance;
	}
	
}





