package me.billbominecraft.mordsheets.commands;

import org.bukkit.Bukkit;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Random;

import static me.billbominecraft.mordsheets.MordSheets.tag;
import static me.billbominecraft.mordsheets.utils.RollUtil.resultMessage;

public class GlobalRollCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;
            List<Player> players = (List<Player>) Bukkit.getOnlinePlayers();

            Random random = new Random();
            int diceroll = random.nextInt(20) + 1;

            if(args.length == 0){

                for(Player onlinePlayers: players){

                    if(onlinePlayers != null){

                        if(diceroll == 8 || diceroll == 11 || diceroll == 18){

                            onlinePlayers.sendMessage(tag + ChatColor.GOLD + player.getName() + " has rolled an " + diceroll + " (" + resultMessage(diceroll) + ")");

                        }else{

                            onlinePlayers.sendMessage(tag + ChatColor.GOLD + player.getName() + " has rolled a " + diceroll + " (" + resultMessage(diceroll) + ")");

                        }

                    }

                }

            } else if(args.length == 1){

                int bonus = Integer.parseInt(args[0]);
                int total = diceroll + bonus;

                for(Player onlinePlayers: players){

                    if(onlinePlayers != null){

                        if(diceroll == 8 || diceroll == 11 || diceroll == 18){

                            onlinePlayers.sendMessage(tag + ChatColor.GOLD + player.getName() + " has rolled an " + diceroll + " + " + bonus + " = " + total + " (" + resultMessage(total) + ")!");

                        }else{

                            onlinePlayers.sendMessage(tag + ChatColor.GOLD + player.getName() + " has rolled a " + diceroll + " + " + bonus + " = " + total + " (" + resultMessage(total) + ")!");

                        }

                    }

                }

            } else {

                player.sendMessage(tag + ChatColor.RED + "Please enter valid arguments. /roll [#]");

            }

        }

        return true;
    }

}
