package link.harryw.lifesteal.Commands;

import link.harryw.lifesteal.LifeSteal;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetHeartsCommand implements CommandExecutor {

    private LifeSteal plugin;

    public SetHeartsCommand(LifeSteal plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player && !sender.isOp()) {
            sender.sendMessage(plugin.Prefix + "No permission.");
            return true;
        }

        if (args.length != 2) {
            sender.sendMessage(plugin.Prefix + "Missing arguments: /sethearts <Player> <Amount>");
        }

        Player p = plugin.getServer().getPlayer(args[0]);
        try {
            plugin.getConfig().set("PlayerData." + p.getUniqueId() + ".Hearts", Integer.parseInt(args[1]) * 2);

            plugin.SetHealth(p, Integer.parseInt(args[1]) * 2);
            sender.sendMessage(plugin.Prefix + "Set " + p.getDisplayName() + "'s hearts to " + args[1]);
            plugin.saveConfig();
            return true;
        } catch (NumberFormatException exception) {
            sender.sendMessage(plugin.Prefix + "Could not set hearts, invalid number.");
        }

        return false;
    }
}
