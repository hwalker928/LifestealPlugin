package link.harryw.lifesteal.Commands;

import link.harryw.lifesteal.Events.TotemPlayerInput;
import link.harryw.lifesteal.LifeSteal;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RedeemRespawnTotemCommand implements CommandExecutor {

    private LifeSteal plugin;

    public RedeemRespawnTotemCommand(LifeSteal plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            sender.sendMessage(plugin.Prefix + "Please right-click the item to redeem it.");
            return true;
        }

        if (args.length != 1) {
            sender.sendMessage(plugin.Prefix + "Missing arguments: /lsredeemrespawntotem <Player>");
            return true;
        }

        Player p = plugin.getServer().getPlayer(args[0]);

        p.sendMessage(plugin.Prefix + ChatColor.GREEN + "Please enter the username of the player to revive:");
        TotemPlayerInput.waitingForAmountPlayers.add(p);

        return true;
    }
}
