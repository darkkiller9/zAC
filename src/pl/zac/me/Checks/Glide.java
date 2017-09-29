package pl.zac.me.Checks;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import pl.zac.me.Main;
import pl.zac.me.Checks.Levels.CheckType;
import pl.zac.me.Checks.Levels.MaxLevel;
import pl.zac.me.Checks.Notify.Checks;
import pl.zac.me.Utils.Messages;
import pl.zac.me.Utils.Permissions;

public class Glide implements Listener {
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		Player p = e.getPlayer();
		if((e.getTo().getY() - e.getFrom().getY() == -0.125D) 
			&& e.getTo().clone().subtract(0.0D, 1.0D, 0.0D).getBlock().getType().equals(Material.AIR)){
			e.setCancelled(true);
			e.getPlayer().teleport(e.getPlayer());
			if(Main.getInstance().getConfig().getBoolean("autoban") == true)
			{
				p.kickPlayer("§5§lYou have been banned from the server!\n§c§lBy:\n §5§lzAC \n§c§lReason: §5§lHacking \n§c§lAppeal at: §5§l" + Messages.APPEAL );
				p.setBanned(true);
				for (Player Staff: Bukkit.getOnlinePlayers())
				{
					if(Staff.hasPermission(Permissions.NOTIFY))
					{
						Staff.sendMessage(Messages.PREFIX + "§e§l" + p.getName() + "§7 has been detected for §5§l" + Checks.GLIDE.toString() + " §7" + p.getLocation().getX() + " , " + p.getLocation().getY() + " , " + p.getLocation().getZ() + ". §5§lMAX: " + MaxLevel.MAX_GLIDE.toString() + "§7, §6§lCheckType: §a§l" + CheckType.FAILED.toString() + "§7."); 
					}
				}
			}
		}
	}
}
				
			
		
