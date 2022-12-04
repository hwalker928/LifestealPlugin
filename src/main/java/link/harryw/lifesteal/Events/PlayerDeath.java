package link.harryw.lifesteal.Events;

import link.harryw.lifesteal.LifeSteal;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath implements Listener {

    private LifeSteal plugin;

    public PlayerDeath(LifeSteal plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void OnDeath(PlayerDeathEvent e) {
        Player p = e.getEntity().getPlayer();
        Entity Killer = e.getEntity().getKiller();
        if (Killer instanceof Player) {
            if (Killer.getUniqueId() != p.getUniqueId()) {
                int PlayerHearts = plugin.getConfig().getInt("PlayerData." + p.getUniqueId() + ".Hearts");
                int KillerHearts = plugin.getConfig().getInt("PlayerData." + Killer.getUniqueId() + ".Hearts");
                if (KillerHearts != 40) {
                    plugin.getConfig().set("PlayerData." + Killer.getUniqueId() + ".Hearts", KillerHearts + 2);
                }
                plugin.getConfig().set("PlayerData." + p.getUniqueId() + ".Hearts", PlayerHearts - 2);
                plugin.saveConfig();
                plugin.SetHealth((Player) Killer, KillerHearts + 2);
            }
        }
    }

}
