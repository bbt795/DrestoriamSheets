package me.billbominecraft.mordsheets.commands;

import me.billbominecraft.mordsheets.classes.CharacterSheet;
import me.billbominecraft.mordsheets.utils.CharacterSheetUtil;
import org.bukkit.Bukkit;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.billbominecraft.mordsheets.MordSheets.tag;

public class CharacterSheetCommand implements CommandExecutor {

    private final CharacterSheetUtil sheetUtil;

    public CharacterSheetCommand (CharacterSheetUtil sheetUtil){

        this.sheetUtil = sheetUtil;

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;

            if(!(args.length >= 1)){

                printHelp(player);
                return true;

            }

            String playerUUID = player.getUniqueId().toString();

            switch (args[0].toLowerCase()) {

                case "inspect":

                    if (args.length != 2) {

                        player.sendMessage(tag + ChatColor.RED + "To inspect, please do /cs inspect (username)");
                        break;

                    }

                    Player target = Bukkit.getPlayerExact(args[1]);

                    if (target == null) {

                        player.sendMessage(tag + ChatColor.RED + "Please provide the username of a real player");
                        break;

                    }

                    CharacterSheet targetSheet = sheetUtil.getSheetHashMap().get(target.getUniqueId().toString());
                    targetSheet.printSheet(player);

                    break;

                case "me":

                    if (args.length > 1) {

                        player.sendMessage(tag + ChatColor.RED + "To see your character sheet, please do /cs me");

                    }

                    CharacterSheet playerSheet = sheetUtil.getSheetHashMap().get(playerUUID);
                    playerSheet.printSheet(player);

                    break;

                case "set":

                    if(args.length < 3){

                        player.sendMessage(tag + ChatColor.RED + "To set a value for a field on your character sheet, please do /cs set <field> <value>");
                        break;

                    }

                    //Doesn't appropriately check race category
                    if(args[1].equalsIgnoreCase("race") && !(sheetUtil.checkRace(args[2]))){

                        player.sendMessage(tag + ChatColor.RED + "Please select an approved race. If you believe this is an error, please contact an admin+.");
                        break;

                    }

                    StringBuilder value = new StringBuilder();
                    for(int i = 2; i < args.length; i++){

                        value.append(args[i]);

                        if(i <= args.length - 1){
                            value.append(" ");
                        }

                    }

                    switch (args[1].toLowerCase()){

                        case "name":

                            sheetUtil.getSheetHashMap().get(playerUUID).setRpName(value.toString());
                            sheetUtil.saveSheet(playerUUID);

                            break;

                        case "age":

                            sheetUtil.getSheetHashMap().get(playerUUID).setAge(Integer.parseInt(value.toString().trim()));
                            sheetUtil.saveSheet(playerUUID);

                            break;

                        case "race":

                            sheetUtil.getSheetHashMap().get(playerUUID).setRace(value.toString());
                            sheetUtil.saveSheet(playerUUID);

                            break;

                        case "appearance":

                            sheetUtil.getSheetHashMap().get(playerUUID).setAppearance(value.toString());
                            sheetUtil.saveSheet(playerUUID);

                            break;

                        case "personality":

                            sheetUtil.getSheetHashMap().get(playerUUID).setPersonality(value.toString());
                            sheetUtil.saveSheet(playerUUID);

                            break;

                        case "background":

                            sheetUtil.getSheetHashMap().get(playerUUID).setBackground(value.toString());
                            sheetUtil.saveSheet(playerUUID);

                            break;

                        case "link":

                            sheetUtil.getSheetHashMap().get(playerUUID).setBackgroundLink(value.toString());
                            sheetUtil.saveSheet(playerUUID);

                            break;

                        default:

                            player.sendMessage(tag + ChatColor.RED + "Error: Please use one of the listed categories.");

                            break;
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

    private void printHelp(Player player){

        player.sendMessage(ChatColor.GOLD + "-===--+ MordSheets Help +--===-");
        player.sendMessage(ChatColor.BLUE + "- /cs help");
        player.sendMessage(ChatColor.BLUE + "- /cs inspect (username)");
        player.sendMessage(ChatColor.BLUE + "- /cs me");
        player.sendMessage(ChatColor.BLUE + "- /cs create");
        player.sendMessage(ChatColor.BLUE + "- /cs set (name | age | race | appearance | personality | background | link) (value)");
        player.sendMessage(ChatColor.GOLD + "-===--+++++++++++++++++--===-");

    }

}
