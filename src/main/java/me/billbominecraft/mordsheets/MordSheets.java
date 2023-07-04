package me.billbominecraft.mordsheets;

import me.billbominecraft.mordsheets.commands.CharacterSheetCommand;
import me.billbominecraft.mordsheets.commands.GlobalRollCommand;
import me.billbominecraft.mordsheets.commands.RollCommand;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class MordSheets extends JavaPlugin {

    private static MordSheets plugin;
    public static String tag = ChatColor.BLUE + "[" + ChatColor.GOLD + "MordSheets" + ChatColor.BLUE + "] ";

    @Override
    public void onEnable() {
        // Plugin startup logic

        System.out.println("MordSheets is now enabled!");

        plugin = this;

        getCommand("roll").setExecutor(new RollCommand());
        getCommand("groll").setExecutor(new GlobalRollCommand());
        getCommand("cs").setExecutor(new CharacterSheetCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Plugin getPlugin() {

        return plugin;

    }

}
