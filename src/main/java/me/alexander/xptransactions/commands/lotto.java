package me.alexander.xptransactions.commands;

import me.alexander.xptransactions.XPTransactions;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class lotto implements CommandExecutor {
    public HashMap<String, Long> cooldowns = new HashMap<String, Long>();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        Player p = (Player) sender;
        if (XPTransactions.instance.enableExpLotto) {

            int cost = XPTransactions.instance.lottoPlayCost;
            int cooldownTime = XPTransactions.instance.lottoCooldown;
            List<String> ranges = XPTransactions.instance.lottoRanges;

            if (cooldowns.containsKey(p.getName())) {
                long secondsLeft = ((cooldowns.get(p.getName()) / 1000) + cooldownTime) - (System.currentTimeMillis() / 1000);
                int minutesLeft = (int) secondsLeft / 60;
                if (secondsLeft > 0) {
                    // Still cooling down
                    if (secondsLeft > 60) {
                        p.sendMessage("<XPTransactions> You cant use /lotto for another " + minutesLeft + " minutes!");
                        return true;
                    } else {
                        p.sendMessage("<XPTransactions> You cant use /lotto for another " + secondsLeft + " seconds!");
                        return true;
                    }
                }
            }
            // No cooldown found or cooldown has expired, save new cooldown
            cooldowns.put(p.getName(), System.currentTimeMillis());
            if (p.getLevel() >= cost) {
                p.giveExpLevels(-cost);
                float random = new Random().nextFloat() * 100;
                boolean won = false;
                for (int i = 0; i < ranges.size(); i++){
                    String range = ranges.get(i);
                    int prize = Integer.parseInt(range.split(":")[0]);
                    float min = Float.parseFloat(range.split(":")[1]);
                    float max = Float.parseFloat(range.split(":")[2]);

                    if (random < max && random >= min){
                        p.giveExpLevels(prize);
                        p.sendMessage("You won " + prize + " levels!");
                        won = true;
                        break;
                    }
                }
                if (!won) {
                    p.sendMessage("You haven't won anything. Good luck next time!");
                }
                return true;
            } else {
                p.sendMessage("You don't have enough levels! Geringverdiener!");
                return false;
            }
        }
        else {
            p.sendMessage("Lotto has been disabled by the admin.");
        }
        return true;
    }
}
