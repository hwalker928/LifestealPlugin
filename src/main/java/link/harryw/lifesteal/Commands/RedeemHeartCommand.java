package link.harryw.lifesteal.Commands;

import link.harryw.lifesteal.LifeSteal;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RedeemHeartCommand implements CommandExecutor {

    private LifeSteal plugin;

    public RedeemHeartCommand(LifeSteal plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            sender.sendMessage(plugin.Prefix + "Please right-click the item to redeem it.");
            return true;
        }

        if (args.length != 1) {
            sender.sendMessage(plugin.Prefix + "Missing arguments: /lsredeemheart <Player>");
            return true;
        }

        Player p = plugin.getServer().getPlayer(args[0]);


        int PlayerHealth = plugin.getConfig().getInt("PlayerData." + p.getUniqueId() + ".Hearts");
        plugin.getConfig().set("PlayerData." + p.getUniqueId() + ".Hearts", PlayerHealth + 2);
        plugin.saveConfig();
        plugin.SetHealth(p, PlayerHealth + 2);
        //p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount() - 1);
        String hearts;
        if ((PlayerHealth + 2) / 2 == 1) {
            hearts = " heart";
        } else {
            hearts = " hearts";
        }
        p.sendMessage(plugin.Prefix + "Heart redeemed, you now have " + (PlayerHealth + 2) / 2 + hearts);

        return true;
    }
}
