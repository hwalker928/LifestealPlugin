package link.harryw.lifesteal.Events;

import link.harryw.lifesteal.LifeSteal;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;

public class TotemPlayerInput implements Listener {

    private LifeSteal plugin;

    public TotemPlayerInput(LifeSteal plugin) {
        this.plugin = plugin;
    }

    public static ArrayList<Player> waitingForAmountPlayers = new ArrayList<>();

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();

        if (waitingForAmountPlayers.contains(p)) {
            e.setCancelled(true);
            OfflinePlayer revivedPlayer = Bukkit.getOfflinePlayer(e.getMessage());
            plugin.getConfig().set("PlayerData." + revivedPlayer.getUniqueId() + ".Hearts", 8);
            plugin.saveConfig();
            p.sendMessage(plugin.Prefix + ChatColor.GREEN + "Successfully revived " + revivedPlayer.getName());
            waitingForAmountPlayers.remove(p);
        }
    }

}
