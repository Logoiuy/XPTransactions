package me.alexander.xptransactions.commands;

import me.alexander.xptransactions.XPTransactions;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import static org.bukkit.potion.PotionEffectType.NIGHT_VISION;

public class GiveNightVision implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if (XPTransactions.instance.autoNightVision) {
            Player p = (Player) sender;
            p.addPotionEffect(new PotionEffect(NIGHT_VISION, Integer.MAX_VALUE, 1, true, false));
            return true;
        }
        return true;
    }
}
