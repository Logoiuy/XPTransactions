package me.alexander.xptransactions.listeners;

import me.alexander.xptransactions.XPTransactions;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;

import static org.bukkit.Bukkit.getLogger;
import static org.bukkit.potion.PotionEffectType.NIGHT_VISION;

public class NightVision implements Listener {
    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (p.getName() != "ChaosBlub01" & XPTransactions.instance.autoNightVision) {
            p.addPotionEffect(new PotionEffect(NIGHT_VISION, Integer.MAX_VALUE, 1, true, false));
        }
    }
    @EventHandler
    public void OnPlayerRespawn(PlayerRespawnEvent e) {
        Bukkit.getScheduler().runTaskLater(XPTransactions.getInstance(), task -> {
            Player p = e.getPlayer();
            if (p.getName() != "ChaosBlub01") {
                p.addPotionEffect(new PotionEffect(NIGHT_VISION, Integer.MAX_VALUE, 1, true, false));
            }

        }, 5L);
    }
}
