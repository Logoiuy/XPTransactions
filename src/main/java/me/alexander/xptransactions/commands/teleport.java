package me.alexander.xptransactions.commands;

import me.alexander.xptransactions.XPTransactions;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.alexander.xptransactions.commands.givexp.isNumeric;

public class teleport implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (XPTransactions.instance.enableExpTeleportation) {
            Player p = (Player) sender;
            if (args.length == 3) {
                if (isNumeric(args[0]) & isNumeric(args[1]) & isNumeric(args[2])) {
                    if (p.getLevel() >= XPTransactions.instance.ExpTeleportationCost) {
                        int x = Integer.parseInt(args[0]);
                        int y = Integer.parseInt(args[1]);
                        int z = Integer.parseInt(args[2]);
                        Location location = new Location(p.getWorld(), x, y, z);
                        p.giveExpLevels(-XPTransactions.instance.ExpTeleportationCost);
                        p.teleport(location);
                        p.sendMessage("<XPTransactions> Successfully teleported!");
                        return true;
                    } else {
                        p.sendMessage("<XPTransactions> You don't have enough levels!");
                        return true;
                    }
                } else {
                    p.sendMessage("<XPTransactions> The Coordinates have to be Numbers!");
                    return true;
                }
            } else {
                p.sendMessage("<XPTransactions> You need to use the structure:");
                return false;
            }
        }
        return true;
    }
}
