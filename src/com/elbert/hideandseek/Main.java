package com.elbert.hideandseek;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
        getCommand("race").setExecutor(new race());
		Bukkit.getPluginManager().registerEvents(new test(), this);
	}
	@Override
	public void onDisable() {
		
	}
}
