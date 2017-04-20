package de.vtrx.joinme;

import de.vtrx.joinme.util.Config;
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
        System.out.println(cfg.System_prefix + "loadet!");
    }

    @Override
    public void onDisable() {
        System.out.println(cfg.System_prefix + "unloadet!");


    }
}
