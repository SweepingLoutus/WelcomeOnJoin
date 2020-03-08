package xyz.sweepingloutus.welcomeonjoin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import me.clip.placeholderapi.PlaceholderAPI;

public class JoinListener implements Listener {

    private Plugin main;

    public JoinListener(Plugin mainArg) {
        main = mainArg;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null){
            FileConfiguration config = main.getConfig();
            String ConfigMessage = config.getString(ChatColor.translateAlternateColorCodes('&', config.getString("message-on-join")));
            String joinmessage = PlaceholderAPI.setPlaceholders(e.getPlayer(), ConfigMessage);
            e.setJoinMessage(joinmessage);
        }else{
            FileConfiguration config = main.getConfig();
            String ConfigMessage = config.getString(ChatColor.translateAlternateColorCodes('&', config.getString("message-on-join")));
            e.setJoinMessage(ConfigMessage);
        }
    }  
}
