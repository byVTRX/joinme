package de.vtrx.joinme.commands;

import de.vtrx.joinme.Main;
import de.vtrx.joinme.util.Config;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

/**
 * Created by thatv on 07.04.2017.
 */
public class JoinCommand extends Command {
    private Config cfg = Main.instance.cfg;

    private String prefix = cfg.System_prefix;
    private String lang = cfg.System_lang;

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
                if (lang.equalsIgnoreCase("DE")) {
                    p.sendMessage(prefix + "§cDer Spieler ist kein §5Youtuber§c/§eTeammitglied§c!");
                    return;
                } else if (lang.equalsIgnoreCase("EN")) {
                    p.sendMessage(prefix + "§cThe player is no §5Youtuber§c/§eTeammitglied§c!");
                    return;
                }


            } else {
                if (target.getName().equalsIgnoreCase(p.getName())) {
                    return;
                }
                if (!JoinmeCommand.joinme.contains(target)) {
                    if (lang.equalsIgnoreCase("DE")) {
                        p.sendMessage(prefix + "§cDie Joinmeanfrage von diesem Spieler ist bereits abgelaufen!");
                        return;
                    } else if (lang.equalsIgnoreCase("EN")) {
                        p.sendMessage(prefix + "§cThe player hasn't got any open joinme invitations!");
                    } else {
                        p.sendMessage(prefix + "§cThere seems to be a problem with your config.yml. §cPlease set §cthe §clanguage §ceither §cto 'DE' or 'EN'.");
                    }
                } else {
                    p.connect(target.getServer().getInfo());
                    p.sendMessage(prefix + "§aDu bist nun auf §e" + target.getServer().getInfo().getName());
                }
            }


        }


    }
}
