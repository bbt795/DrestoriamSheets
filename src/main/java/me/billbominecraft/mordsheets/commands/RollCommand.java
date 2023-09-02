package me.billbominecraft.mordsheets.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Random;

import static me.billbominecraft.mordsheets.MordSheets.tag;
import static me.billbominecraft.mordsheets.utils.RollUtil.resultMessage;

public class RollCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;
            List<Entity> entities = player.getNearbyEntities(20,20,20);

            Random random = new Random();
            int diceroll = random.nextInt(20) + 1;

            if(args.length == 0){

                player.sendMessage(tag + ChatColor.GOLD + player.getDisplayName() + " has rolled a " + diceroll + " (" + resultMessage(diceroll) + ")");

                for(Entity entity: entities){

                    if(entity instanceof Player){

                        entity.sendMessage(tag + ChatColor.GOLD + player.getDisplayName() + " has rolled a " + diceroll + " (" + resultMessage(diceroll) + ")!");

                    }

                }

            } else if(args.length == 1){

                int bonus = Integer.parseInt(args[0]);
                int total = diceroll + bonus;


                player.sendMessage(tag + ChatColor.GOLD + player.getDisplayName() + " has rolled a " + diceroll + " + " + bonus + " = " + total + " (" + resultMessage(total) + ")!");

                for(Entity entity: entities){

                    if(entity instanceof Player){

                        entity.sendMessage(tag + ChatColor.GOLD + player.getDisplayName() + " has rolled a " + diceroll + " + " + bonus + " = " + total + " (" + resultMessage(total) + ")!");

                    }

                }

            } else {

                player.sendMessage(tag + ChatColor.RED + "Please enter valid arguments. /roll [#]");

            }

        }

        return true;
    }

}
