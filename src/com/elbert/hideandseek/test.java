package com.elbert.hideandseek;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.EulerAngle;

public class test implements Listener{
	static Boolean racea = false;
	static String sulae = "";
	static List<ArmorStand> s = new ArrayList<>();
	List<Material> metriala = new ArrayList<>();
	Random random = new Random();
	@SuppressWarnings("deprecation")
	@EventHandler
	public void changetotrans(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 99999, 25555));
		if (!player.hasPlayedBefore()) {
			for(Material sa : Material.values()) {
				metriala.add(sa);
			}
			Integer a = random.nextInt(metriala.size());
			ItemStack ss = new ItemStack(metriala.get(a), 1);
			Location r = player.getLocation().add(0, -1, 0);
	        ArmorStand as = (ArmorStand) r.getWorld().spawn(r, ArmorStand.class);
	        as.setGravity(false);
	        as.setCanPickupItems(false);
	        as.setCustomName(player.getName()+"test");
	        as.setCustomNameVisible(false);
	        as.setVisible(false);
	        as.setHeadPose(EulerAngle.ZERO);
	        as.setHelmet(ss);
	        as.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 99999, 25555));
	        s.add(as);
		}
		
	}
	@EventHandler
	public void nodamage(EntityDamageEvent e) {
		if (e.getCause() != DamageCause.ENTITY_ATTACK) {
			e.setDamage(0);
		}
	}
	@EventHandler
	public void sulae(EntityDamageByEntityEvent e) {
		racea = race.racea;
		sulae = race.sulae;
		if (racea == false) {
			return;
		}
		Player sr = (Player) e.getDamager();
		if (!sr.getName().equalsIgnoreCase(sulae)) {
			e.setDamage(0);
		}
		Player sg = (Player) e.getDamager();
		for(Player m :Bukkit.getOnlinePlayers()) {
			m.sendMessage(sg.getName()+"´ÔÀÌ Á×¾ú½À´Ï´Ù");
		}
		sg.setGameMode(GameMode.SPECTATOR);
		for(ArmorStand sa : s) {
			if (sa.getName().equalsIgnoreCase(sg.getName())) {
				sa.remove();
			}
		}
	}
	
	@EventHandler
	public void changetotrans(PlayerMoveEvent e) {
		for(ArmorStand sa : s) {
			if (sa.getName().equalsIgnoreCase(e.getPlayer().getName()+"Test")) {
				Location r = e.getPlayer().getLocation();
				sa.teleport(r.add(0,-1,0));
			}
		}
	}
	@EventHandler
	public void nofood(FoodLevelChangeEvent e) {
		e.setFoodLevel(20);
	}
}
