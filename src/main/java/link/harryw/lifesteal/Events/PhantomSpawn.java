package link.harryw.lifesteal.Events;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class PhantomSpawn implements Listener {

    @EventHandler
    public void EntitySpawnEvent(EntitySpawnEvent e) {
        if (e.getEntityType().equals(EntityType.PHANTOM)) {
            e.setCancelled(true);
        }
    }

}
