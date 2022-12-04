package link.harryw.lifesteal.Commands;

import link.harryw.lifesteal.LifeSteal;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HeartsCommand implements CommandExecutor {

    private LifeSteal plugin;

    public HeartsCommand(LifeSteal plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(plugin.Color("&cThis command can only be executed by a player!"));
            return true;
        }

        Player p = (Player) sender;
        String hearts;
        if (args.length >= 1) {
            Player Target = plugin.getServer().getPlayer(args[0]);
            int TargetHealth = plugin.getConfig().getInt("PlayerData." + Target.getUniqueId() + ".Hearts");
            if ((TargetHealth / 2) == 1) {
                hearts = " heart";
            } else {
                hearts = " hearts";
            }
            p.sendMessage(plugin.Prefix + Target.getDisplayName() + " has " + TargetHealth / 2 + hearts);
        } else {
            int PlayerHealth = plugin.getConfig().getInt("PlayerData." + p.getUniqueId() + ".Hearts");
            if ((PlayerHealth / 2) == 1) {
                hearts = " heart";
            } else {
                hearts = " hearts";
            }
            p.sendMessage(plugin.Prefix + "You have " + PlayerHealth / 2 + hearts);
        }
        return true;
    }
}
