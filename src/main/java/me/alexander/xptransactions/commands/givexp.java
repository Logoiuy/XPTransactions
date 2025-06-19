package me.alexander.xptransactions.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class givexp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        Player p = (Player) sender;

        if (args.length == 2)
        {
            Player t = (Player) Bukkit.getPlayer(args[0]);
            if (isNumeric(args[1]))
            {
                int a = Integer.parseInt(args[1]);
                if (p.getLevel() >= a)
                {
                    t.giveExpLevels(a);
                    p.giveExpLevels(-a);
                    p.sendMessage("<XPTransactions> Transaction successful!");
                    t.sendMessage("<XPTransactions> You received " + args[1] + "level from" + p.getName());

                    return true;
                }
                else
                {
                    p.sendMessage("<XPTransactions> You don't have enough levels!");
                    return true;
                }
            }
            else
            {
                p.sendMessage("<XPTransactions> The second argument needs to be a Number!");
                return true;
            }
        }
        else
        {
            p.sendMessage("<XPTransactions> You need to use the structure:");
            return false;
        }
    }
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Integer d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
