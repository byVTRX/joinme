package de.vtrx.joinme.util;

import net.md_5.bungee.api.plugin.Plugin;

import java.io.File;

/**
 * Created by thatv on 07.04.2017.
 */
public class Config extends net.craftminecraft.bungee.bungeeyaml.supereasyconfig.Config {
    public Config(Plugin plugin) {
        CONFIG_FILE = new File("plugins//" + "JoinMe", "config.yml");
        CONFIG_HEADER = "JoinMe Configuration file";
    }


    public String System_prefix = "&7[&6Join&5Me&7] &8● &7";
    public boolean System_displayname = true;
    public String System_JoinMeMSG = "&7| &e%player% &7- (&e%server%&7)";
    public String System_cooldown = "&cYou have to wait a moment before sending a JoinMe request again.";
    public String System_noperms = "&cYou are no &eTeammember&7/&5Youtuber.";
    public String System_targetNoTeammember = "&cTarget is not a &eTeammember&7/&5Youtuber.";
    public String System_noOpenJoinMeInvitations = "&cThe target hasn't got any open JoinMe invitations.";
    public String System_sameServer = "&cYou are already connected to this server";
    public String System_connectedMsg = "&aYou are successfully connected to: %server%";
}
