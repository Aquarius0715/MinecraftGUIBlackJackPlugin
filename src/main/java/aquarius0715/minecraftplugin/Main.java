package aquarius0715.minecraftplugin;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {




    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new BlackJackGameSystem(), this);
        this.getCommand("blackjack").setExecutor(new BlackJackCommand());


        // Plugin startup logic

    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }







}