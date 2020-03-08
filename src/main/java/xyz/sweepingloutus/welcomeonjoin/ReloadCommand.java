package xyz.sweepingloutus.welcomeonjoin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
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
                player.sendMessage("You do not have permission to use that command!");

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

