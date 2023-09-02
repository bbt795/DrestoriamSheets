package me.billbominecraft.mordsheets.commands;

import me.billbominecraft.mordsheets.classes.CharacterSheet;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

import static me.billbominecraft.mordsheets.MordSheets.tag;
import static me.billbominecraft.mordsheets.utils.CharacterSheetUtil.*;

public class CharacterSheetCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;

            if(!(args.length >= 1)){

                printHelp(player);
                return true;

            }

            switch (args[0]) {

                case "inspect":

                    if (!(args.length == 2)) {

                        player.sendMessage(tag + ChatColor.RED + "To inspect, please do /cs inspect (username)");
                        break;

                    }

                    Player target = Bukkit.getPlayerExact(args[1]);

                    if (target == null) {

                        player.sendMessage(tag + ChatColor.RED + "Please provide the username of a real player");
                        break;

                    }

                    CharacterSheet targetSheet;

                    try {
                        targetSheet = findSheet(target, player);
                    } catch (IOException e) {
                        e.printStackTrace();
                        player.sendMessage(tag + ChatColor.RED + "An internal error has occurred. Please try again.");
                        break;
                    }

                    if (targetSheet != null) {

                        targetSheet.printSheet(player);

                    }

                    break;

                case "me":

                    if (args.length > 1) {

                        player.sendMessage(tag + ChatColor.RED + "To see your character sheet, please do /cs me");

                    }

                    CharacterSheet playerSheet;

                    try {
                        playerSheet = findSheet(player, player);
                    } catch (IOException e) {
                        e.printStackTrace();
                        player.sendMessage(tag + ChatColor.RED + "An internal error has occurred. Please try again.");
                        break;
                    }

                    if(playerSheet != null) {

                        playerSheet.printSheet(player);

                    }

                    break;

                case "create":

                    if (args.length > 1) {

                        player.sendMessage(tag + ChatColor.RED + "To create your character sheet, please do /cs create");
                        break;

                    }

                    try {
                        createSheet(player);
                    } catch (IOException e) {
                        e.printStackTrace();
                        player.sendMessage(tag + ChatColor.RED + "An internal error has occurred. Please try again.");
                    }

                    break;

                case "set":

                    if(args.length < 3){

                        player.sendMessage(tag + ChatColor.RED + "To set a value for a field on your character sheet, please do /cs set <field> <value>");
                        break;

                    }

                    if(args[2] == "race" && !(checkRace())){

                        player.sendMessage(tag + ChatColor.RED + "Please select an approved race. If you believe this is an error, please contact an admin+.");

                    }

                    StringBuilder value = new StringBuilder();
                    for(int i = 2; i < args.length; i++){

                        value.append(args[i]);

                        if(i <= args.length - 1){
                            value.append(" ");
                        }

                    }

                    try {
                        updateSheet(player, args[1], String.valueOf(value));
                    } catch (IOException e) {
                        e.printStackTrace();
                        player.sendMessage(tag + ChatColor.RED + "An internal error has occurred. Please try again.");
                    }

                    break;

                case "help":
                default:
                    printHelp(player);
                    break;

            }

        }

        return true;
    }

    public void printHelp(Player player){

        player.sendMessage(ChatColor.GOLD + "-===--+ MordSheets Help +--===-");
        player.sendMessage(ChatColor.BLUE + "- /cs help");
        player.sendMessage(ChatColor.BLUE + "- /cs inspect (username)");
        player.sendMessage(ChatColor.BLUE + "- /cs me");
        player.sendMessage(ChatColor.BLUE + "- /cs create");
        player.sendMessage(ChatColor.BLUE + "- /cs set (name | age | race | appearance | personality | background | link) (value)");
        player.sendMessage(ChatColor.GOLD + "-===--+++++++++++++++++--===-");

    }

}
