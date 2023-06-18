package me.billbominecraft.mordsheets.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Random;

public class GlobalRollCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String tag = ChatColor.GOLD + "[" + ChatColor.BLUE + "MordSheets" + ChatColor.GOLD + "] ";

        if(sender instanceof Player){

            Player player = (Player) sender;
            List<Player> players = (List<Player>) Bukkit.getOnlinePlayers();

            Random random = new Random();
            int diceroll = random.nextInt(20) + 1;

            if(args.length == 0){

                player.sendMessage(tag + ChatColor.GOLD + player.getDisplayName() + "has rolled a " + diceroll + " (" + resultMessage(diceroll) + ")");

                for(Player onlinePlayers: players){

                    if(onlinePlayers instanceof Player){

                        onlinePlayers.sendMessage(tag + ChatColor.GOLD + player.getDisplayName() + "has rolled a " + diceroll + " (" + resultMessage(diceroll) + ")!");

                    }

                }

            } else if(args.length == 1){

                int bonus = Integer.parseInt(args[0]);
                int total = diceroll + bonus;


                player.sendMessage(tag + ChatColor.GOLD + player.getDisplayName() + "has rolled a " + diceroll + " + " + bonus + " = " + total + " (" + resultMessage(total) + ")!");

                for(Player onlinePlayers: players){

                    if(onlinePlayers instanceof Player){

                        onlinePlayers.sendMessage(tag + ChatColor.GOLD + player.getDisplayName() + "has rolled a " + diceroll + " + " + bonus + " = " + total + " (" + resultMessage(total) + ")!");

                    }

                }

            } else {

                player.sendMessage(tag + ChatColor.RED + "Please enter valid arguments. /roll [#]");

            }

        }

        return true;
    }

    String resultMessage(int diceroll){

        String result;

        switch(diceroll){

            case 1:
            case 2:
            case 3:
            case 4:
                result = "Catastrophic Penalty";
                break;

            case 5:
            case 6:
            case 7:
            case 8:
                result = "Major Penalty";
                break;

            case 9:
            case 10:
            case 11:
            case 12:
                result = "Minor Penalty";
                break;

            case 13:
            case 14:
            case 15:
            case 16:
                result = "Neutral Penalty";
                break;

            case 17:
            case 18:
            case 19:
            case 20:
                result = "No Penalty";
                break;

            default:
                result = "ERROR";
                break;

        }

        return result;

    }

}
