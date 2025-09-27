package me.billbominecraft.mordsheets;

import me.billbominecraft.mordsheets.commands.CharacterSheetCommand;
import me.billbominecraft.mordsheets.commands.GlobalRollCommand;
import me.billbominecraft.mordsheets.commands.RoleplayStatsCommand;
import me.billbominecraft.mordsheets.commands.RollCommand;
import me.billbominecraft.mordsheets.events.ConnectionEvents;
import me.billbominecraft.mordsheets.utils.CharacterSheetUtil;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class MordSheets extends JavaPlugin {

    public static String tag = ChatColor.BLUE + "[" + ChatColor.GOLD + "MordSheets" + ChatColor.BLUE + "] ";

    @Override
    public void onEnable() {
        // Plugin startup logic

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        CharacterSheetUtil sheetUtil = new CharacterSheetUtil(this);

        getServer().getPluginManager().registerEvents(new ConnectionEvents(sheetUtil), this);

        getCommand("roll").setExecutor(new RollCommand());
        getCommand("groll").setExecutor(new GlobalRollCommand());
        getCommand("csheet").setExecutor(new CharacterSheetCommand(sheetUtil));
        getCommand("rs").setExecutor(new RoleplayStatsCommand(sheetUtil));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic


    }

}
