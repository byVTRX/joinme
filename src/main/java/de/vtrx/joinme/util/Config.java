package de.vtrx.joinme.util;

import net.md_5.bungee.api.plugin.Plugin;

import java.io.File;

/**
 * Created by thatv on 07.04.2017.
 */
public class Config extends net.craftminecraft.bungee.bungeeyaml.supereasyconfig.Config {
    public Config(Plugin plugin) {
        CONFIG_FILE = new File("plugins//" + "BungeeSystem", "config.yml");
        CONFIG_HEADER = "BungeeSystem Configuration file";
    }


    public String System_prefix = "§7[§6Join§5Me§7] §8● §7";
    public String System_lang = "DE";
}
