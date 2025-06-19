package me.alexander.xptransactions;

import me.alexander.xptransactions.commands.*;
import me.alexander.xptransactions.listeners.NightVision;
import me.alexander.xptransactions.listeners.PokeEgg;
import me.alexander.xptransactions.listeners.XpBottles;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class XPTransactions extends JavaPlugin {
    public static XPTransactions instance;
    public boolean autoNightVision;
    public boolean enableExpTeleportation;
    public boolean enableExpLotto;
    public int lottoCooldown;
    public int itemSendCost;
    public int ExpTeleportationCost;
    public boolean allowConversion;
    public int lottoPlayCost;
    public List<String> lottoPrizes = new ArrayList<String>();
    public List<String> lottoRanges = new ArrayList<String>(); // Structure: Prize:Min:Max

//    public int lottoPrizeOne;
//    public int lottoProbabilityOne;
//    public int lottoPrizeTwo;
//    public int lottoProbabilityTwo;
//    public int lottoPrizeThree;
//    public int lottoProbabilityThree;

    FileConfiguration config = getConfig();
    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        getCommand("givexp").setExecutor(new givexp());
        getServer().getPluginManager().registerEvents(new NightVision(), this);
        getServer().getPluginManager().registerEvents(new XpBottles(), this);
        getCommand("nightvision").setExecutor(new GiveNightVision());
        getCommand("tpe").setExecutor(new teleport());
        getCommand("send").setExecutor(new send());
        getCommand("lotto").setExecutor(new lotto());
        getCommand("convert").setExecutor(new ConvertToBottles());

        lottoPrizes.add("5:20");
        lottoPrizes.add("10:3");
        lottoPrizes.add("30:1");

        config.addDefault("autoNightVision", true);
        config.addDefault("ItemSendCost", 0);
        config.addDefault("enableExpTeleportation", true);
        config.addDefault("ExpTeleportationCost", 1);
        config.addDefault("allowConversion", true);
        config.addDefault("enableExpLotto", false);
        config.addDefault("lottoCooldown", 600);
        config.addDefault("lottoPlayCost", 2);
        config.addDefault("lottoPrizes", lottoPrizes);
        config.options().copyDefaults(true);
        saveConfig();

        autoNightVision = config.getBoolean("autoNightVision");
        itemSendCost = config.getInt("ItemSendCost");
        enableExpTeleportation = config.getBoolean("enableExpTeleportation");
        ExpTeleportationCost = config.getInt("ExpTeleportationCost");
        allowConversion = config.getBoolean("allowConversion");
        enableExpLotto = config.getBoolean("enableExpLotto");
        lottoCooldown = config.getInt("lottoCooldown");
        lottoPlayCost = config.getInt("lottoPlayCost");
        lottoPrizes = config.getStringList("lottoPrizes");

        if (enableExpLotto) {
            try {
                float sum = 0;
                for (int i = 0; i < lottoPrizes.size(); i++) {
                    lottoRanges.add(lottoPrizes.get(i).split(":")[0] + ":" + sum + ":" + (sum + Float.parseFloat(lottoPrizes.get(i).split(":")[1])));
                    sum += Float.parseFloat(lottoPrizes.get(i).split(":")[1]);
                }
            } catch (Exception e) {
                getLogger().severe("LOTTO FAILED TO INITIALIZE, probably due to a typo in the config file.");
            }
        }
        getLogger().info("The Plugin is enabled");
    }
    public static XPTransactions getInstance(){
        return instance;
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }
    public void log(String text){
        getLogger().info(text);
    }
    public static void giveItem(Player player, ItemStack items){
        if (player.getInventory().firstEmpty() != -1){
            player.getInventory().addItem(items);
        }
        else {
            player.getWorld().dropItem(player.getLocation(), items);
        }

    }

    public static double getDecimals(double number){
        return number - Math.floor(number);
    }
}
