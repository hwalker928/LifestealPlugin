package link.harryw.lifesteal.Events;

import link.harryw.lifesteal.LifeSteal;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawn implements Listener {

    private LifeSteal plugin;

    public PlayerRespawn(LifeSteal plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void OnRespawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        int PlayerHearts = plugin.getConfig().getInt("PlayerData." + p.getUniqueId() + ".Hearts");
        plugin.SetHealth(p, PlayerHearts);
        if (PlayerHearts <= 0) {
            String KickMsg = plugin.getConfig().getString("kickMessage");
            KickMsg = ChatColor.translateAlternateColorCodes('&', KickMsg);
            p.kickPlayer(KickMsg);
            p.setGameMode(GameMode.SPECTATOR);
        }

    }

}