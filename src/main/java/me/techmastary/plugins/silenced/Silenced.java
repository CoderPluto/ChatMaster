package me.techmastary.plugins.silenced;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Silenced extends JavaPlugin implements Listener {
	public static boolean Silence;
	public void onDisable() {
	}

	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void OnPlayerJoin(PlayerJoinEvent event) {
	}
	
	@EventHandler
	public void OnPlayerChat(AsyncPlayerChatEvent event) {
		if (!event.getPlayer().hasPermission("silenced.admin") && (Silence)) {
			event.setCancelled(true);
			event.getPlayer().sendMessage(ChatColor.GRAY + "The chat is currently disabled.");
		}
	}

}
