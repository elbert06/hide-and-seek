package com.elbert.hideandseek;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

public class race implements CommandExecutor{
	static Boolean racea = false;
	List<String> sf = new ArrayList<String>();
	Random random = new Random();
	static String sulae = "";
	public boolean onCommand( CommandSender sender, Command cmd,String label,String[] args) {
		racea = true;
		Integer s = random.nextInt(Bukkit.getOnlinePlayers().size());
		for(Player sr : Bukkit.getOnlinePlayers()) {
			sf.add(sr.getName());
		}
		sulae = sf.get(s);
		for(Player ss : Bukkit.getOnlinePlayers()) {
			ss.sendMessage(sulae+"님이 술래입니다.");
		}
		List<ArmorStand> saa = test.s;
		for(ArmorStand sm : saa) {
			if (sm.getName().equalsIgnoreCase(sulae +"test")) {
				sm.remove();
			}
		}
		Bukkit.getPlayer(sulae).removePotionEffect(PotionEffectType.INVISIBILITY);
		return false;
	}
}
