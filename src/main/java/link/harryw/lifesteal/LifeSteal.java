package link.harryw.lifesteal;

import io.th0rgal.oraxen.api.OraxenItems;
import link.harryw.lifesteal.Commands.*;
import link.harryw.lifesteal.Events.*;
import link.harryw.lifesteal.Utils.PlaceHolderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class LifeSteal extends JavaPlugin implements Listener {
    public String Prefix = ChatColor.translateAlternateColorCodes('&', "&c&lLifeSteal&r ");

    public void SetHealth(Player Player, Integer Amount) {
        Player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue((double) Amount);
    }

    public ItemStack GetHeart() {
        return OraxenItems.getItemById("heart_redeem").setAmount(1).build();
    }

    public ItemStack GetResetCrystal() {
        return OraxenItems.getItemById("reset_crystal").setAmount(1).build();
    }

    public ItemStack GetRespawnTotem() {
        return OraxenItems.getItemById("respawn_totem").setAmount(1).build();
    }

    public String Color(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }

    public void onEnable() {
        this.saveDefaultConfig();
        this.getServer().getPluginManager().registerEvents(this, this);

        this.getCommand("hearts").setExecutor(new HeartsCommand(this));
        this.getCommand("lshelp").setExecutor(new HelpCommand(this));
        this.getCommand("recipe").setExecutor(new RecipeCommand(this));
        this.getCommand("lsreload").setExecutor(new ReloadCommand(this));
        this.getCommand("lssethearts").setExecutor(new SetHeartsCommand(this));
        this.getCommand("lsredeemheart").setExecutor(new RedeemHeartCommand(this));
        this.getCommand("lsredeemresetcrystal").setExecutor(new RedeemResetCrystalCommand(this));
        this.getCommand("lsredeemrespawntotem").setExecutor(new RedeemRespawnTotemCommand(this));

        this.getServer().getPluginManager().registerEvents(new HeartClick(this), this);
        this.getServer().getPluginManager().registerEvents(new PlayerDeath(this), this);
        this.getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
        this.getServer().getPluginManager().registerEvents(new PlayerRespawn(this), this);
        this.getServer().getPluginManager().registerEvents(new PhantomSpawn(), this);
        this.getServer().getPluginManager().registerEvents(new TotemPlayerInput(this), this);

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new PlaceHolderAPI(this).register();
            getLogger().info("Registered PlaceHolderAPI");
        }

        if (OraxenItems.exists("non_existant_item")) {
            getLogger().info("Config check failed!");
        } else {
            getLogger().info("Config check passed");
        }

        if (OraxenItems.exists("heart_redeem")) {
            getLogger().info("Found heart_redeem item");
        }
    }
}
