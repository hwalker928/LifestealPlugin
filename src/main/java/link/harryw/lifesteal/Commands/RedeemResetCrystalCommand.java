package link.harryw.lifesteal.Commands;

import link.harryw.lifesteal.LifeSteal;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RedeemResetCrystalCommand implements CommandExecutor {

    private LifeSteal plugin;

    public RedeemResetCrystalCommand(LifeSteal plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            sender.sendMessage(plugin.Prefix + "Please right-click the item to redeem it.");
            return true;
        }

        if (args.length != 1) {
            sender.sendMessage(plugin.Prefix + "Missing arguments: /lsredeemresetcrystal <Player>");
            return true;
        }

        Player p = plugin.getServer().getPlayer(args[0]);


        plugin.getConfig().set("PlayerData." + p.getUniqueId() + ".Hearts", 20);
        plugin.saveConfig();
        plugin.SetHealth(p, 20);
        p.sendMessage(plugin.Prefix + "Reset Crystal redeemed, you now have 10 hearts");

        return true;
    }
}
