package xyz.sweepingloutus.welcomeonjoin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.logging.Level;
import java.util.logging.Logger;


public class ReloadCommand implements CommandExecutor {
    private Plugin main;

    public ReloadCommand(Plugin mainArg) {
        main = mainArg;
    }

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        FileConfiguration config = main.getConfig();
        Logger logger = main.getLogger();
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            if(player.hasPermission("messageonjoin.reload")){
                try{
                    player.sendMessage("Reloading...");
                    main.reloadConfig();
                    player.sendMessage("Success reloaded config!");
                }catch(Exception e){
                    logger.log(Level.SEVERE,"MessageOnJoin Error reloading config!",e);
                    return true;
                }
            }else {
                player.sendMessage("You don't have permission to use this command!");

            }
        }else{
            try{
                main.reloadConfig();
            }catch(Exception e){
                logger.log(Level.SEVERE,"MessageOnJoin Error reloading config!",e);
            }
        }
        return true;
    }
}

