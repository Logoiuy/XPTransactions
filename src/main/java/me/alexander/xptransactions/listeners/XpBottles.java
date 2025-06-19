package me.alexander.xptransactions.listeners;

import me.alexander.xptransactions.XPTransactions;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExpBottleEvent;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffectType;

import java.text.NumberFormat;
import java.text.ParseException;

public class XpBottles implements Listener {
    @EventHandler
    public void OnBottleLand(PlayerItemConsumeEvent e) throws ParseException {
        if (e.getItem().getItemMeta().getLore() == null){return;}
        if (e.getItem().getType().equals(Material.POTION) & e.getItem().getItemMeta().getLore().toString().contains("Contains")) {
            PotionMeta meta = (PotionMeta) e.getItem().getItemMeta();

            if (meta.hasCustomEffect(PotionEffectType.GLOWING)) {


                Integer levels = Integer.parseInt(e.getItem().getItemMeta().getLore().get(1));
                e.getPlayer().giveExpLevels(levels);

                if (e.getItem().getType() == Material.POTION) {
                    Bukkit.getServer().getScheduler().runTaskLaterAsynchronously(XPTransactions.instance, new Runnable() {
                        public void run() {
                            e.getPlayer().setItemInHand(new ItemStack(Material.AIR));
                        }
                    }, 1L);

                }
            }
        }
    }
}
