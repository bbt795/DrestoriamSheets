package me.billbominecraft.drestoriamsheets;

import me.billbominecraft.drestoriamsheets.commands.CharacterSheetCommand;
import me.billbominecraft.drestoriamsheets.commands.GlobalRollCommand;
import me.billbominecraft.drestoriamsheets.commands.RoleplayStatsCommand;
import me.billbominecraft.drestoriamsheets.commands.RollCommand;
import me.billbominecraft.drestoriamsheets.events.ConnectionEvents;
import me.billbominecraft.drestoriamsheets.utils.CharacterSheetUtil;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class DrestoriamSheets extends JavaPlugin {

    public static String tag = ChatColor.BLUE + "[" + ChatColor.GOLD + "DrestoriamSheets" + ChatColor.BLUE + "] ";

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
