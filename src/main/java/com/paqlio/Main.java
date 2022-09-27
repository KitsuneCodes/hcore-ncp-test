package com.paqlio;

import com.hakan.core.HCore;
import org.bukkit.entity.Egg;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        HCore.initialize(this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
