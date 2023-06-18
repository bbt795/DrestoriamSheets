package me.billbominecraft.mordsheets;

import me.billbominecraft.mordsheets.commands.GlobalRollCommand;
import me.billbominecraft.mordsheets.commands.RollCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class MordSheets extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        System.out.println("MordSheets is now enabled!");

        getCommand("roll").setExecutor(new RollCommand());
        getCommand("groll").setExecutor(new GlobalRollCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
