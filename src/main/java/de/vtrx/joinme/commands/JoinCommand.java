package de.vtrx.joinme.commands;

import de.vtrx.joinme.Main;
import de.vtrx.joinme.util.Config;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

/**
 * Created by thatv on 07.04.2017.
 */
public class JoinCommand extends Command {
    private Config cfg = Main.instance.cfg;

    private String prefix = ChatColor.translateAlternateColorCodes('&', cfg.System_prefix);

    public JoinCommand() {
        super("join6842");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer))
            return;
        else {
            ProxiedPlayer p = (ProxiedPlayer) sender;
            ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);
            if (!target.hasPermission("system.joinme")) {

                    p.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', cfg.System_targetNoTeammember));


            } else {
                if (target.getName().equalsIgnoreCase(p.getName()) || target.getServer().getInfo().getName().equalsIgnoreCase(p.getServer().getInfo().getName())) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', cfg.System_sameServer));
                    return;
                }
                if (!JoinmeCommand.joinme.contains(target)) {
                        p.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', cfg.System_noOpenJoinMeInvitations));

                } else {
                    p.connect(target.getServer().getInfo());
                    p.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', cfg.System_connectedMsg).replace("%server%", target.getServer().getInfo().getName()));
                }
            }


        }


    }
}
