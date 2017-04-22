package de.vtrx.joinme;

import de.vtrx.joinme.commands.JoinCommand;
import de.vtrx.joinme.commands.JoinmeCommand;
import de.vtrx.joinme.util.Config;
import net.craftminecraft.bungee.bungeeyaml.bukkitapi.InvalidConfigurationException;
import net.md_5.bungee.api.plugin.Plugin;

/**
 * Created by thatv on 21.04.2017.
 */
public class Main extends Plugin{
    public static Main instance;

    public Config cfg;

    @Override
    public void onEnable() {
        instance = this;

        cfg = new Config(this);
        try {
            cfg.init();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }

        getProxy().getPluginManager().registerCommand(this, new JoinmeCommand());
        getProxy().getPluginManager().registerCommand(this, new JoinCommand());
        System.out.println(cfg.System_prefix + "loadet!");
    }

    @Override
    public void onDisable() {
        System.out.println(cfg.System_prefix + "unloadet!");


    }
}
