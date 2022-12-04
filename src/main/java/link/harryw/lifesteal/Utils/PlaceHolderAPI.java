package link.harryw.lifesteal.Utils;

import link.harryw.lifesteal.LifeSteal;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;

public class PlaceHolderAPI extends PlaceholderExpansion {

    private LifeSteal plugin;

    public PlaceHolderAPI(LifeSteal plugin) {
        this.plugin = plugin;
    }

    @Override
    public String getAuthor() {
        return "harrydev";
    }

    @Override
    public String getIdentifier() {
        return "lifesteal";
    }

    @Override
    public String getVersion() {
        return "2.0.0";
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String onRequest(OfflinePlayer player, String params) {
        if (params.equalsIgnoreCase("hearts")) {
            int PlayerHealth = plugin.getConfig().getInt("PlayerData." + player.getUniqueId() + ".Hearts") / 2;
            return String.valueOf(PlayerHealth);
        }

        return null;
    }
}
