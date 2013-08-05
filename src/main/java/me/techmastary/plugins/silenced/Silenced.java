import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Silenced extends JavaPlugin implements Listener {
	public static boolean Silence;
	
	@Override
	public void onDisable() {
    	System.out.println("Silencer Disabled");
	}
	
    @Override
	public void onEnable() {
    	System.out.println("Silencer Enabled");
    }
    
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player player = (Player) sender;
		if(commandLabel.equalsIgnoreCase("silence")){
			if (player.hasPermission("Silence.on")) {
		}
			 onPlayerChat(AsyncPlayerChatEvent event) {
				    event.setCancelled(true);
			Bukkit.broadcastMessage(ChatColor.YELLOW + "Chat has been silenced by " + ChatColor.DARK_RED + player.getDisplayName());

		if(commandLabel.equalsIgnoreCase("silence-off")){
			if (player.hasPermission("Silence.off")) {
			}	

			Bukkit.broadcastMessage(ChatColor.YELLOW + "Chat is now enabled ");
			
			}
		
		return true;
}
    }
}
