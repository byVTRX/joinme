package de.vtrx.joinme.listener;

import de.vtrx.joinme.commands.JoinmeCommand;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerSwitchEvent;
import net.md_5.bungee.event.EventHandler;

/**
 * Created by thatv on 22.04.2017.
 */
public class Listener implements net.md_5.bungee.api.plugin.Listener {


    @EventHandler
    public void onServerSwitch(ServerSwitchEvent e){
        ProxiedPlayer p = e.getPlayer();

        if(JoinmeCommand.joinme.contains(p)){
            JoinmeCommand.joinme.remove(p);
        }

    }





}
