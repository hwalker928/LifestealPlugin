package link.harryw.lifesteal.Events;

import link.harryw.lifesteal.LifeSteal;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class HeartClick implements Listener {

    private LifeSteal plugin;

    public HeartClick(LifeSteal plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void OnInventoryClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equalsIgnoreCase(plugin.Color("&a&lRESPAWN TOTEM&r Recipe")) || e.getView().getTitle().equalsIgnoreCase(plugin.Color("&c&l&oHEART&r Recipe")) || e.getView().getTitle().equalsIgnoreCase(plugin.Color("&b&lRESET CRYSTAL&r Recipe"))) {
            e.setCancelled(true);
        }
    }

}
