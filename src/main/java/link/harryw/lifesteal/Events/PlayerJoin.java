package link.harryw.lifesteal.Events;

import link.harryw.lifesteal.LifeSteal;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    private LifeSteal plugin;

    public PlayerJoin(LifeSteal plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void OnJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        plugin.getConfig().set("PlayerData." + p.getUniqueId() + ".Username", e.getPlayer().getDisplayName());
        boolean Setup = plugin.getConfig().getBoolean("PlayerData." + p.getUniqueId() + ".Setup");
        if (!Setup) {
            plugin.getConfig().set("PlayerData." + p.getUniqueId() + ".Setup", true);
            plugin.getConfig().set("PlayerData." + p.getUniqueId() + ".Hearts", 20);
        }

        plugin.saveConfig();
        int PlayerHearts = plugin.getConfig().getInt("PlayerData." + p.getUniqueId() + ".Hearts");
        plugin.SetHealth(p, PlayerHearts);

        if (!p.isOp()) {
            if (PlayerHearts <= 0) {
                p.setGameMode(GameMode.SPECTATOR);
            } else {
                p.setGameMode(GameMode.SURVIVAL);
            }
        }
    }

}
