package me.billbominecraft.mordsheets.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Random;

public class RollCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String tag = ChatColor.GOLD + "[" + ChatColor.BLUE + "MordSheets" + ChatColor.GOLD + "] ";

        if(sender instanceof Player){

            Player player = (Player) sender;
            List<Entity> entities = player.getNearbyEntities(20,20,20);

            Random random = new Random();
            int diceroll = random.nextInt(20) + 1;

            String result = "";

            if(args.length == 0){

                switch(diceroll){

                    case 1:
                        result = "Catastrophic Penalty";
                        break;

                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        result = "Major Penalty";
                        break;

                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                        result = "Minor Penalty";
                        break;

                    case 11:
                    case 12:
                    case 13:
                    case 14:
                        result = "Neutral Penalty";
                        break;

                    case 15:
                    case 16:
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

                player.sendMessage(tag + ChatColor.BLUE + player.getDisplayName() + "has rolled a " + diceroll + "(" + result + ")");

                for(Entity entity: entities){

                    if(entity instanceof Player){

                        entity.sendMessage(tag + ChatColor.BLUE + player.getDisplayName() + "has rolled a " + diceroll + "(" + result + ")");

                    }

                }

            } else if(args.length == 1){



            } else {

                player.sendMessage(tag + ChatColor.RED + "Please enter valid arguments. /roll [#]");

            }

        }

        return true;
    }

}
