package pl.zac.me.AutoBan;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import pl.zac.me.Utils.Messages;

public class Login implements Listener {
	
	@EventHandler (priority = EventPriority.HIGHEST)
	public void onPlayerBanned(PlayerLoginEvent e) {
		if (e.getResult() == Result.KICK_BANNED) {
			e.setKickMessage("§5§lYou have been banned from the server!\n§c§lBy:\n §5§lzAC \n§c§lReason: §5§lHacking \n§c§lAppeal at: §5§l" + Messages.APPEAL );
			System.out.println(e.getPlayer().getName() + " tried to join but banned by zAC");
			Bukkit.getServer().broadcastMessage("§c§l" + e.getPlayer().getName() + "§7 tried to join but banned by §5§lzAC");
			
		}
		
		
	}

}
