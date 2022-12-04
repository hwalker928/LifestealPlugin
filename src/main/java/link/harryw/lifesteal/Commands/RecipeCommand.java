package link.harryw.lifesteal.Commands;

import link.harryw.lifesteal.LifeSteal;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RecipeCommand implements TabExecutor {

    private LifeSteal plugin;

    public RecipeCommand(LifeSteal plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(plugin.Color("&cThis command can only be executed by a player!"));
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage(plugin.Color("&6Please provide an itemname:"));
            sender.sendMessage(plugin.Color("&cheart &bresetcrystal &arespawntotem"));
            return true;
        }

        if (args[0].equalsIgnoreCase("heart")) {
            Player p = (Player) sender;
            Inventory Gui = Bukkit.createInventory(p, 27, plugin.Color("&c&l&oHEART&r Recipe"));
            ItemStack Diamond = new ItemStack(Material.DIAMOND_BLOCK, 1);
            ItemStack Scrap = new ItemStack(Material.NETHERITE_SCRAP, 1);
            ItemStack Totem = new ItemStack(Material.TOTEM_OF_UNDYING, 1);
            ItemStack Back = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
            ItemMeta BackMeta = Back.getItemMeta();
            BackMeta.setDisplayName(" ");
            Back.setItemMeta(BackMeta);
            Gui.setItem(0, Back);
            Gui.setItem(9, Back);
            Gui.setItem(18, Back);
            Gui.setItem(4, Back);
            Gui.setItem(13, Back);
            Gui.setItem(22, Back);
            Gui.setItem(5, Back);
            Gui.setItem(14, Back);
            Gui.setItem(23, Back);
            Gui.setItem(6, Back);
            Gui.setItem(24, Back);
            Gui.setItem(7, Back);
            Gui.setItem(16, Back);
            Gui.setItem(25, Back);
            Gui.setItem(8, Back);
            Gui.setItem(17, Back);
            Gui.setItem(26, Back);
            Gui.setItem(1, Diamond);
            Gui.setItem(2, Scrap);
            Gui.setItem(3, Diamond);
            Gui.setItem(10, Scrap);
            Gui.setItem(11, Totem);
            Gui.setItem(12, Scrap);
            Gui.setItem(19, Diamond);
            Gui.setItem(20, Scrap);
            Gui.setItem(21, Diamond);
            Gui.setItem(15, plugin.GetHeart());
            p.openInventory(Gui);
        } else if (args[0].equalsIgnoreCase("resetcrystal")) {
            Player p = (Player) sender;
            Inventory Gui = Bukkit.createInventory(p, 27, plugin.Color("&b&lRESET CRYSTAL&r Recipe"));
            ItemStack Heart = plugin.GetHeart();
            ItemStack Skull = new ItemStack(Material.WITHER_SKELETON_SKULL, 1);
            ItemStack Soul = new ItemStack(Material.SOUL_SAND, 1);
            ItemStack Back = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
            ItemMeta BackMeta = Back.getItemMeta();
            BackMeta.setDisplayName(" ");
            Back.setItemMeta(BackMeta);
            Gui.setItem(0, Back);
            Gui.setItem(9, Back);
            Gui.setItem(18, Back);
            Gui.setItem(4, Back);
            Gui.setItem(13, Back);
            Gui.setItem(22, Back);
            Gui.setItem(5, Back);
            Gui.setItem(14, Back);
            Gui.setItem(23, Back);
            Gui.setItem(6, Back);
            Gui.setItem(24, Back);
            Gui.setItem(7, Back);
            Gui.setItem(16, Back);
            Gui.setItem(25, Back);
            Gui.setItem(8, Back);
            Gui.setItem(17, Back);
            Gui.setItem(26, Back);
            Gui.setItem(2, Skull);
            Gui.setItem(10, Soul);
            Gui.setItem(11, Soul);
            Gui.setItem(12, Soul);
            Gui.setItem(20, Heart);
            Gui.setItem(15, plugin.GetResetCrystal());
            p.openInventory(Gui);
        } else if (args[0].equalsIgnoreCase("respawntotem")) {
            Player p = (Player) sender;
            Inventory Gui = Bukkit.createInventory(p, 27, plugin.Color("&a&lRESPAWN TOTEM&r Recipe"));
            ItemStack Heart = plugin.GetHeart();
            ItemStack Skull = new ItemStack(Material.WITHER_SKELETON_SKULL, 1);
            ItemStack Soul = new ItemStack(Material.SOUL_SAND, 1);
            ItemStack Back = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
            ItemMeta BackMeta = Back.getItemMeta();
            BackMeta.setDisplayName(" ");
            Back.setItemMeta(BackMeta);
            Gui.setItem(0, Back);
            Gui.setItem(9, Back);
            Gui.setItem(18, Back);
            Gui.setItem(4, Back);
            Gui.setItem(13, Back);
            Gui.setItem(22, Back);
            Gui.setItem(5, Back);
            Gui.setItem(14, Back);
            Gui.setItem(23, Back);
            Gui.setItem(6, Back);
            Gui.setItem(24, Back);
            Gui.setItem(7, Back);
            Gui.setItem(16, Back);
            Gui.setItem(25, Back);
            Gui.setItem(8, Back);
            Gui.setItem(17, Back);
            Gui.setItem(26, Back);
            Gui.setItem(2, Skull);
            Gui.setItem(10, Soul);
            Gui.setItem(11, Soul);
            Gui.setItem(12, Soul);
            Gui.setItem(20, Heart);
            Gui.setItem(15, plugin.GetRespawnTotem());
            p.openInventory(Gui);
        }
        return true;
    }

    private static final String[] COMMANDS = {"heart", "resetcrystal", "respawntotem"};

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        final List<String> completions = new ArrayList<>();
        StringUtil.copyPartialMatches(args[0], Arrays.asList(COMMANDS), completions);
        Collections.sort(completions);
        return completions;
    }
}
