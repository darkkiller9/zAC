package pl.zac.me.Utils;

import org.bukkit.ChatColor;

import pl.zac.me.Main;


public class Messages {
	public static final String NO_PERMISSIONS = "§cAccess denied.";
	public static final String ZAC_MESSAGE = "§ezAC 1.0 by darkkiller9, report any bugs.";
	public static final String PREFIX = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("general.prefix"));

}