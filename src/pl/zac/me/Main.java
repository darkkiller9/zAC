package pl.zac.me;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import pl.zac.me.AutoBan.Login;
import pl.zac.me.Checks.Flight;
import pl.zac.me.Checks.Glide;
import pl.zac.me.Checks.Speed;
import pl.zac.me.Checks.WaterWalk;
import pl.zac.me.commands.ZAC;


public class Main extends JavaPlugin implements Listener {
	
	private static Main instance;

	public static FileConfiguration config;

	public static File conf;
	
	public void onEnable(){
		instance = this;
		config = getConfig();
		config.options().copyDefaults(true);
		conf = new  File(getDataFolder(), "config.yml");
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		saveConfig();
		saveDefaultConfig();
		
		//register commands here:
		
		getCommand("zac").setExecutor(new ZAC());
		
		//register events here:
		
		Bukkit.getServer().getPluginManager().registerEvents(new Flight(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Speed(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new WaterWalk(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Glide(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Login(), this);
		
	}
	public static Main getInstance(){
    	return instance;
	}

}
