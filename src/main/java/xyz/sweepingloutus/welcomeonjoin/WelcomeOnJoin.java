package xyz.sweepingloutus.welcomeonjoin;

import org.bukkit.plugin.java.JavaPlugin;

public class WelcomeOnJoin extends JavaPlugin {
    @Override
    public void onEnable(){
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        getCommand("wojreload") .setExecutor(new ReloadCommand(this));

    }
    @Override
    public void onDisable(){

    }

}
