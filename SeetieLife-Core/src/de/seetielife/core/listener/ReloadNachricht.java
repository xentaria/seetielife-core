package de.seetielife.core.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import de.seetielife.core.Main;

public class ReloadNachricht implements Listener{

	@EventHandler
	public void onReload(PlayerCommandPreprocessEvent e){
		Player p = e.getPlayer();
		String cmd = e.getMessage();
		
		if(cmd.equalsIgnoreCase("/reload") || cmd.equalsIgnoreCase("/rl")){
			if(!(p.hasPermission("seetielife.reload"))){
				p.sendMessage(Main.noperm);
			} else {
				Bukkit.broadcastMessage(Main.pre + "§4§lAchtung! Der Server wird neu geladen.");
				Bukkit.reload();
				e.setCancelled(true);
				Bukkit.broadcastMessage(Main.pre + "§a§lDer Server wurde neu geladen.");
			}
		}
	}
}
