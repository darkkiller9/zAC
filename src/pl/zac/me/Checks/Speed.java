package pl.zac.me.Checks;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import pl.zac.me.Main;
import pl.zac.me.Checks.Levels.CheckType;
import pl.zac.me.Checks.Levels.MaxLevel;
import pl.zac.me.Checks.Notify.Checks;
import pl.zac.me.Utils.Messages;
import pl.zac.me.Utils.Permissions;

public class Speed implements Listener{
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		Player p = e.getPlayer();
		Location to = e.getTo();
		Location From = e.getFrom();
		
		Vector vec = to.toVector().setY(0.0D);
		double i = vec.distance(From.toVector().setY(0.0D));
		if(p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType().equals(Material.SPONGE)){
			return;
		}
		if(p.getGameMode().equals(GameMode.CREATIVE)){
			return;
		}
		if(p.getEntityId() == 100){
			return;
		}
		if(p.getVehicle() !=null){
			return;
		}
		if(p.getAllowFlight() == true){
			return;
		}
		if(From.getY() < to.getY()){
			return;
		}
		
		if(i >= MaxLevel.MAX_SPEED){
			e.setCancelled(true);
			p.teleport(e.getFrom());
			if(Main.getInstance().getConfig().getBoolean("autoban") == true)
			{
				p.kickPlayer("§5§lYou have been banned from the server!\n§c§lBy:\n §5§lzAC \n§c§lReason: §5§lHacking \n§c§lAppeal at: §5§l" + Messages.APPEAL );
				p.setBanned(true);
				for (Player Staff: Bukkit.getOnlinePlayers())
				{
					if(Staff.hasPermission(Permissions.NOTIFY))
					{
						Staff.sendMessage(Messages.PREFIX + "§e§l" + p.getName() + "§7 has been detected for §5§l" + Checks.SPEED.toString() + " §7" + p.getLocation().getX() + " , " + p.getLocation().getY() + " , " + p.getLocation().getZ() + ". §5§lMAX: " + MaxLevel.MAX_SPEED.toString() + "§7, §6§lCheckType: §a§l" + CheckType.DETECTED.toString() + "§7."); 
					}
				}
			}
		}
	}
}
			
		