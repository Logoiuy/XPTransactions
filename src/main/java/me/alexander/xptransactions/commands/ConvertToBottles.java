package me.alexander.xptransactions.commands;

import me.alexander.xptransactions.XPTransactions;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Collections;

import static me.alexander.xptransactions.commands.givexp.isNumeric;


public class ConvertToBottles implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

            Player p = (Player) sender;
            if(XPTransactions.instance.allowConversion) {
                int levels;
                ItemStack Bottles = new ItemStack(Material.POTION, 1);
                PotionMeta meta = (PotionMeta) Bottles.getItemMeta();
                if (args.length == 0) {
                    if (p.getLevel() > 0) {
                        levels = p.getLevel();
                        meta.addCustomEffect(new PotionEffect(PotionEffectType.GLOWING, levels, 1, false, false, false), true);
                        meta.setColor(Color.LIME);
                        ItemMeta iMeta = meta;
                        iMeta.setDisplayName("Potion of Experience");
                        ArrayList<String> LoreList = new ArrayList<String>();
                        LoreList.add(0, "Contains ");
                        LoreList.add(1, Integer.toString(levels));
                        LoreList.add(2, " levels");
                        iMeta.setLore(LoreList);
                        Bottles.setItemMeta(iMeta);
                        p.setLevel(0);
                        XPTransactions.giveItem(p, Bottles);

                        p.sendMessage("<XPTransactions> Conversion successful!");
                    } else {
                        p.sendMessage("<XPTransactions> You don't have any levels to convert!");
                    }
                } else if (args.length == 1) {
                    if (isNumeric(args[0])) {
                        levels = Integer.parseInt(args[0]);
                        if (p.getLevel() >= levels) {
                            meta.addCustomEffect(new PotionEffect(PotionEffectType.GLOWING, levels, 1, false, false, false), true);
                            meta.setColor(Color.LIME);
                            ItemMeta iMeta = meta;
                            iMeta.setDisplayName("Potion of Experience");
                            ArrayList<String> LoreList = new ArrayList<String>();
                            LoreList.add(0, "Contains ");
                            LoreList.add(1, Integer.toString(levels));
                            LoreList.add(2, " levels");
                            iMeta.setLore(LoreList);
                            Bottles.setItemMeta(iMeta);
                            p.giveExpLevels(-levels);
                            XPTransactions.giveItem(p, Bottles);
                            p.sendMessage("<XPTransactions> Conversion successful!");
                        } else {
                            p.sendMessage("<XPTransactions> You don't have enough levels!");
                            return true;
                        }
                    } else {
                        p.sendMessage("<XPTransactions> You need to use the structure:");
                        return false;
                    }
                } else {
                    p.sendMessage("<XPTransactions> You need to use the structure:");
                    return false;
                }


                return true;
            }
            p.sendMessage("<XPTransactions> Conversion is not allowed");
            return true;
    }
}
