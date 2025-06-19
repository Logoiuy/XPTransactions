package me.alexander.xptransactions.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import me.alexander.xptransactions.XPTransactions;

public class send implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        Player p = (Player) sender;
        if (args.length == 1){
            if (p.getLevel() >= XPTransactions.instance.itemSendCost) {
                Player t = (Player) Bukkit.getPlayer(args[0]);
                ItemStack i = (ItemStack) p.getItemInHand();
                p.setItemInHand(null);
                p.giveExpLevels(-XPTransactions.instance.itemSendCost);
                XPTransactions.giveItem(t, i);
                p.sendMessage("<XPTransactions> Successfully sent " + i + " to " + t.getName());
                t.sendMessage("<XPTransactions> Successfully received " + i + " from " + p.getName());
                return true;
            }else {
                p.sendMessage("<XPTransactions> You don't have enough levels! You Geringverdiener!");
                return true;
            }
        }
        p.sendMessage("<XPTransactions> You need to use the Structure:");
        return false;
    }
}
