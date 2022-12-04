package link.harryw.lifesteal.Commands;

import link.harryw.lifesteal.LifeSteal;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HelpCommand implements CommandExecutor {

    private LifeSteal plugin;

    public HelpCommand(LifeSteal plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(plugin.Color("&c------[ " + plugin.Prefix + "&c]-----"));
        sender.sendMessage(plugin.Color("&c1:&f help &7: Shows this message"));
        sender.sendMessage(plugin.Color("&c2:&f recipe &7: Shows the heart recipe"));
        sender.sendMessage(plugin.Color("&c3:&f hearts &7: Shows heart count"));
        sender.sendMessage(plugin.Color("&c4:&f sethearts &7: Set a player's hearts"));
        sender.sendMessage(plugin.Color("&c5:&f reload &7: Reload the config"));
        sender.sendMessage(plugin.Color("&c------[ " + plugin.Prefix + "&c]-----"));
        return true;
    }
}
