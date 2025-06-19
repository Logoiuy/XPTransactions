package me.alexander.xptransactions.listeners;

import org.bukkit.Material;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

public class DropHeads implements Listener {
    @EventHandler
    public void OnPlayerDie(PlayerDeathEvent e){
        Player p = e.getPlayer();

    }
}
