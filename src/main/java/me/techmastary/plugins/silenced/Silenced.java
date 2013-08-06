package me.techmastary.plugins.silenced;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Silenced extends JavaPlugin implements Listener {
	public static boolean Silence;

	@Override
	public void onDisable() {
		System.out.println("Disabled Silenced.");
	}

	@Override
	public void onEnable() {
		System.out.println("Enabled Silenced.");
		Silence = false;
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void OnPlayerChat(AsyncPlayerChatEvent event) {
		if (!event.getPlayer().hasPermission("silenced.speak") && (Silence == true) || !event.getPlayer().hasPermission("silenced.admin")) {
			event.setCancelled(true);
			event.getPlayer().sendMessage(ChatColor.RED + "Global chat is currently disabled.");
		} else {
			event.setCancelled(false);
		}
	}

	@EventHandler
	public void OnPlayerJoin(PlayerJoinEvent event) {
		if (Silence == true) {
			event.getPlayer().sendMessage(ChatColor.GRAY + "Global chat is currently disabled.");
			if (event.getPlayer().hasPermission("silenced.admin")) {
				event.getPlayer().sendMessage(ChatColor.GRAY + "You have permission to talk.");
			}

		}
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("silence")) {
			if (sender.hasPermission("silenced.admin") && (Silence == false)) {
				Silence = true;
				sender.sendMessage(ChatColor.GRAY + "You silenced global chat.");
				Bukkit.broadcastMessage(ChatColor.GRAY + "" + sender.getName() + " disabled global chat.");
			}
			if (sender.hasPermission("silenced.admin") && (Silence == true)) {
				Silence = false;
				sender.sendMessage(ChatColor.GRAY + "You have resumed global chat.");
				Bukkit.broadcastMessage(ChatColor.GRAY + "" + sender.getName() + " resumed global chat.");
			}
		}
		if (label.equalsIgnoreCase("chatstatus")) {
			if (sender.hasPermission("silenced.admin") && (Silence == true)) {
				sender.sendMessage(ChatColor.GRAY + "Global chat is currently" + ChatColor.RED + " DISABLED" + ChatColor.GRAY + ".");
			}
			if (sender.hasPermission("silenced.admin") && (Silence == false)) {
				sender.sendMessage(ChatColor.GRAY + "Global chat is currently" + ChatColor.RED + " ENABLED" + ChatColor.GRAY + ".");

			}
		}
		return true;
	}

}