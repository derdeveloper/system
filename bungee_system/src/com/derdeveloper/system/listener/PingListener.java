package com.derdeveloper.system.listener;

import com.derdeveloper.system.Main;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.util.UUID;

public class PingListener implements Listener {

    private Main plugin;

    public PingListener(Main plugin) {
        this.plugin = plugin;
        BungeeCord.getInstance().pluginManager.registerListener(plugin, this);
    }

    @EventHandler
    public void handlePingEvent(ProxyPingEvent event) {
        ServerPing ping = event.getResponse();
        ServerPing.Players player = ping.getPlayers();
        ServerPing.Protocol version = ping.getVersion();
        version.setName("§4Wartungsarbeiten!");
        version.setProtocol(0);
        player.setSample(new ServerPing.PlayerInfo[] {new ServerPing.PlayerInfo("§7Der Server befindet sich in Wartungsarbeiten", UUID.randomUUID())});
        event.getResponse().
    }

    @EventHandler
    public void handlePing2Event()

}
