package me.alexander.xptransactions.listeners;

import me.alexander.xptransactions.XPTransactions;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class PokeEgg implements Listener {
    public Entity PokeMob;
    @EventHandler
    public void OnMobHit(ProjectileHitEvent e){
        XPTransactions.instance.log("A Mob got Hit");
        if (e.getEntity() instanceof Egg & e.getHitEntity() instanceof Mob){
            PokeMob = e.getHitEntity();
            XPTransactions.instance.log("by an Egg");
            World world = PokeMob.getWorld();
            Location loc = PokeMob.getLocation();
            ItemStack egg = Egg(PokeMob);
            PokeMob.remove();
            world.dropItemNaturally(loc, egg);
            XPTransactions.instance.log("and dropped " + egg);
        }
    }
    public ItemStack Egg(Entity Mob){
        if (Mob.getType() == EntityType.ALLAY){
            return new ItemStack(Material.ALLAY_SPAWN_EGG);
        }
        else if (Mob.getType() == EntityType.AXOLOTL){
            return new ItemStack(Material.AXOLOTL_SPAWN_EGG);
        }
        else if (Mob.getType() == EntityType.BAT){
            return new ItemStack(Material.BAT_SPAWN_EGG);
        }
        else if (Mob.getType() == EntityType.BEE){
            return new ItemStack(Material.BEE_SPAWN_EGG);
        }
        else if (Mob.getType() == EntityType.CAT){
            return new ItemStack(Material.CAT_SPAWN_EGG);
        }
        else if (Mob.getType() == EntityType.CAVE_SPIDER){
            return new ItemStack(Material.CAVE_SPIDER_SPAWN_EGG);
        }
        else if (Mob.getType() == EntityType.BLAZE){
            return new ItemStack(Material.BLAZE_SPAWN_EGG);
        }
        else if (Mob.getType() == EntityType.CHICKEN){
            return new ItemStack(Material.CHICKEN_SPAWN_EGG);
        }
        else if (Mob.getType() == EntityType.COD){
            return new ItemStack(Material.COD_SPAWN_EGG);
        }
        else if (Mob.getType() == EntityType.COW){
            return new ItemStack(Material.COW_SPAWN_EGG);
        }
        else if (Mob.getType() == EntityType.CREEPER){
            return new ItemStack(Material.CREEPER_SPAWN_EGG);
        }
        else if (Mob.getType() == EntityType.DOLPHIN){
            return new ItemStack(Material.DOLPHIN_SPAWN_EGG);
        }
        else if (Mob.getType() == EntityType.DONKEY){
            return new ItemStack(Material.DONKEY_SPAWN_EGG);
        }
        else if (Mob.getType() == EntityType.DROWNED){
            return new ItemStack(Material.DROWNED_SPAWN_EGG);
        }
        else if (Mob.getType() == EntityType.ELDER_GUARDIAN){
            return new ItemStack(Material.ELDER_GUARDIAN_SPAWN_EGG);
        }
        else if (Mob.getType() == EntityType.ENDERMAN){
            return new ItemStack(Material.ENDERMAN_SPAWN_EGG);
        }
        else if (Mob.getType() == EntityType.ENDERMITE){
            return new ItemStack(Material.ENDERMITE_SPAWN_EGG);
        }
        else if (Mob.getType() == EntityType.EVOKER){
            return new ItemStack(Material.EVOKER_SPAWN_EGG);
        }
        else if (Mob.getType() == EntityType.FOX){
            return new ItemStack(Material.FOX_SPAWN_EGG);
        }
        else if (Mob.getType() == EntityType.FROG){
            return new ItemStack(Material.FROG_SPAWN_EGG);
        }
        else if (Mob.getType() == EntityType.GHAST){
            return new ItemStack(Material.GHAST_SPAWN_EGG);
        }
        else if (Mob.getType() == EntityType.GLOW_SQUID){
            return new ItemStack(Material.GLOW_SQUID_SPAWN_EGG);
        }
        else if (Mob.getType() == EntityType.GOAT){
            return new ItemStack(Material.GOAT_SPAWN_EGG);
        }
        else if (Mob.getType() == EntityType.GUARDIAN){
            return new ItemStack(Material.GUARDIAN_SPAWN_EGG);
        }
        else if (Mob.getType() == EntityType.HOGLIN){
            return new ItemStack(Material.HOGLIN_SPAWN_EGG);
        }
        else if (Mob.getType() == EntityType.HORSE){
            return new ItemStack(Material.HORSE_SPAWN_EGG);
        }
        else if (Mob.getType() == EntityType.HUSK){
            return new ItemStack(Material.HUSK_SPAWN_EGG);
        }
        else if (Mob.getType() == EntityType.IRON_GOLEM){
            return new ItemStack(Material.IRON_GOLEM_SPAWN_EGG);
        }
        else if (Mob.getType() == EntityType.LLAMA){
            return new ItemStack(Material.LLAMA_SPAWN_EGG);
        }
        else if (Mob.getType() == EntityType.MAGMA_CUBE){
            return new ItemStack(Material.MAGMA_CUBE_SPAWN_EGG);
        }
        else if (Mob.getType() == EntityType.MULE){
            return new ItemStack(Material.MULE_SPAWN_EGG);
        }
        else if (Mob.getType() == EntityType.MUSHROOM_COW){
            return new ItemStack(Material.MOOSHROOM_SPAWN_EGG);
        }


        return null;
    }
}
