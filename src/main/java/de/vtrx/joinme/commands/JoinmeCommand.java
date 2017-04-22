package de.vtrx.joinme.commands;

import de.vtrx.joinme.Main;
import de.vtrx.joinme.util.Config;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by thatv on 07.04.2017.
 */
public class JoinmeCommand extends Command {
    public static ArrayList<ProxiedPlayer> joinme = new ArrayList<>();
    private Config cfg = Main.instance.cfg;
    private String prefix = ChatColor.translateAlternateColorCodes('&', cfg.System_prefix);

    public JoinmeCommand() {
        super("joinme");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage("");
            return;
        } else {
            ProxiedPlayer p = (ProxiedPlayer) sender;
            if (p.hasPermission("system.joinme")) {
                if (joinme.contains(p)) {

                        p.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', cfg.System_cooldown));

                    return;
                }


                for (ProxiedPlayer all : ProxyServer.getInstance().getPlayers()) {
                    TextComponent msg = new TextComponent(ChatColor.translateAlternateColorCodes('&', cfg.System_JoinMeMSG)
                            .replace("%player%", (cfg.System_displayname ? p.getDisplayName() : "§e" + p.getName()))
                            .replace("%server%", p.getServer().getInfo().getName()));
                    msg.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/join6842 " + p.getName()));

                    ProxyServer server = ProxyServer.getInstance();

                    server.broadcast("§7|---------- §6JoinMe §7----------|");
                    server.broadcast("§7|");
                    server.broadcast("§7|");
                    server.broadcast("§7|");
                    server.broadcast("§7|");
                    server.broadcast(msg);
                    server.broadcast("§7|");
                    server.broadcast("§7|");
                    server.broadcast("§7|");
                    server.broadcast("§7|---------- §6JoinMe §7----------|");

                    joinme.add(p);
                    clearList(p);
                }

            } else {

                    p.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', cfg.System_noperms));

            }
        }

    }

    public void clearList(ProxiedPlayer p) {
        ProxyServer.getInstance().getScheduler().schedule(Main.instance, new Runnable() {
            @Override
            public void run() {
                joinme.remove(p);
            }
        }, 20, TimeUnit.SECONDS);


    }


}
