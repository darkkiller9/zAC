package pl.zac.me.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import pl.zac.me.Utils.Messages;
import pl.zac.me.Utils.Permissions;

public class ZAC implements CommandExecutor 
{
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
 
        if (label.equalsIgnoreCase("zac"))
        {
        	
        	if(!sender.hasPermission(Permissions.ZAC_COMMAND))
        	{
        		
        		sender.sendMessage(Messages.NO_PERMISSIONS);
        		return true;
        	}
        	sender.sendMessage(Messages.ZAC_MESSAGE);
        	return true;
        }
		return false;
	}
        	

}
