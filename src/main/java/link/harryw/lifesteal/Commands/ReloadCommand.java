package link.harryw.lifesteal.Commands;

import link.harryw.lifesteal.LifeSteal;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor {

    private LifeSteal plugin;

    public ReloadCommand(LifeSteal plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player && !sender.isOp()) {
            sender.sendMessage(plugin.Prefix + "No permission.");
            return true;
        }

        plugin.reloadConfig();
        sender.sendMessage(plugin.Prefix + plugin.Color("&aConfig Reloaded"));
        return true;
    }
}
