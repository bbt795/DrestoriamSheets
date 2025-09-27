package me.billbominecraft.drestoriamsheets.commands;

import me.billbominecraft.drestoriamsheets.classes.RoleplayStats;
import me.billbominecraft.drestoriamsheets.utils.CharacterSheetUtil;
import org.bukkit.Bukkit;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.billbominecraft.drestoriamsheets.DrestoriamSheets.tag;

public class RoleplayStatsCommand implements CommandExecutor {

    private final CharacterSheetUtil sheetUtil;

    public RoleplayStatsCommand(CharacterSheetUtil sheetUtil) {

        this.sheetUtil = sheetUtil;

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;
            String playerUUID = player.getUniqueId().toString();

            if(!(args.length >= 1)){

                printHelp(player);
                return true;

            }

            switch(args[0].toLowerCase()){

                case "add":{

                    if(!player.hasPermission("rs.add")){

                        player.sendMessage(tag + ChatColor.RED + "You do not have permission to execute this command.");
                        break;

                    }

                    if(args.length != 4){

                        player.sendMessage(tag + ChatColor.RED + "To add stats, please do /rs add (username) (stat) (amount)");
                        break;

                    }

                    Player target = Bukkit.getPlayerExact(args[1]);

                    if(target == null){

                        player.sendMessage(tag + ChatColor.RED + "Please provide the username of a real player");
                        break;

                    }

                    RoleplayStats targetStats = sheetUtil.getStatMap().get(target.getUniqueId().toString());
                    int statValue = getStats(targetStats, args[2]);

                    if(statValue == -50){

                        player.sendMessage(tag + ChatColor.RED + "Please provide a valid stat name");
                        break;

                    }

                    try {

                        setStats(targetStats, args[2], statValue + Integer.parseInt(args[3]));
                        sheetUtil.saveSheet(playerUUID);

                    } catch (NumberFormatException e){

                        player.sendMessage(tag + ChatColor.RED + "Please use a numerical input for the amount");
                        break;

                    }

                    player.sendMessage(tag + ChatColor.GREEN + "Successfully added!");
                    break;}

                case "remove":{

                    if(!player.hasPermission("rs.remove")){

                        player.sendMessage(tag + ChatColor.RED + "You do not have permission to execute this command.");
                        break;

                    }

                    if(args.length != 4){

                        player.sendMessage(tag + ChatColor.RED + "To add stats, please do /rs remove (username) (stat) (amount)");
                        break;

                    }

                    Player target = Bukkit.getPlayerExact(args[1]);

                    if(target == null){

                        player.sendMessage(tag + ChatColor.RED + "Please provide the username of a real player");
                        break;

                    }

                    RoleplayStats targetStats = sheetUtil.getStatMap().get(target.getUniqueId().toString());
                    int statValue = getStats(targetStats, args[2]);

                    if(statValue == -50){

                        player.sendMessage(tag + ChatColor.RED + "Please provide a valid stat name");
                        break;

                    }


                    try {

                        setStats(targetStats, args[2], statValue - Integer.parseInt(args[3]));
                        sheetUtil.saveSheet(playerUUID);

                    } catch (NumberFormatException e){

                        player.sendMessage(tag + ChatColor.RED + "Please use a numerical input for the amount");
                        break;

                    }

                    player.sendMessage(tag + ChatColor.GREEN + "Successfully removed!");
                    break;}

                case "check":

                    if(args.length == 2){

                        if(!player.hasPermission("rs.check.others")){

                            player.sendMessage(tag + ChatColor.RED + "You do not have permission to execute this command.");
                            break;

                        }

                        Player target = Bukkit.getPlayerExact(args[1]);

                        if(target == null){

                            player.sendMessage(tag + ChatColor.RED + "Please provide the username of a real player");
                            break;

                        }

                        RoleplayStats targetStats = sheetUtil.getStatMap().get(target.getUniqueId().toString());
                        targetStats.printStats(player);

                    } else if (args.length == 1){

                        RoleplayStats playerStats = sheetUtil.getStatMap().get(playerUUID);
                        playerStats.printStats(player);

                    } else {

                        player.sendMessage(tag + ChatColor.RED + "To check stats, please do /rs check");
                        break;

                    }

                    break;

                case "list":

                    String[] statarr = new String[]{"Acrobatics", "Stealth", "Sleight", "Contortion", "Emotional", "Athletics", "Brawn", "Resistance", "Deception", "Intimidation",
                            "Persuasion", "Performance", "Investigation", "Nature", "Religion", "Perception", "Medicine", "Handling", "Insight", "Survival", "Innuendo"};

                    player.sendMessage(ChatColor.GOLD + "-===--+ Stat List +--===-\n");

                    for(String stat: statarr){

                        player.sendMessage(ChatColor.BLUE + "- " + stat);

                    }

                    player.sendMessage(ChatColor.GOLD + "-===--+++++++++++++--===-");

                    break;

                case "help":
                default:

                    printHelp(player);
                    break;

            }

        }

        return true;
    }

    private int getStats(RoleplayStats currentStats, String statName){

        switch (statName.toLowerCase()){

            case "acrobatics":
                return currentStats.getAcrobatics();
            case "stealth":
                return  currentStats.getStealth();
            case "sleight":
                return currentStats.getSleight();
            case "contortion":
                return currentStats.getContortion();
            case "emotional":
                return currentStats.getEmotional();
            case "athletics":
                return currentStats.getAthletics();
            case "brawn":
                return currentStats.getBrawn();
            case "resistance":
                return currentStats.getResistance();
            case "deception":
                return currentStats.getDeception();
            case "intimidation":
                return currentStats.getIntimidation();
            case "persuasion":
                return currentStats.getPersuasion();
            case "performance":
                return currentStats.getPerformance();
            case "investigation":
                return currentStats.getInvestigation();
            case "nature":
                return currentStats.getNature();
            case "religion":
                return currentStats.getReligion();
            case "perception":
                return currentStats.getPerception();
            case "medicine":
                return currentStats.getMedicine();
            case "handling":
                return currentStats.getHandling();
            case "insight":
                return currentStats.getInsight();
            case "survival":
                return currentStats.getSurvival();
            case "innuendo":
                return currentStats.getInnuendo();
            default:
                return -50;

        }

    }

    private void setStats(RoleplayStats currentStats, String statName, int value){

        switch (statName.toLowerCase()){

            case "acrobatics":
                currentStats.setAcrobatics(value);
                return;
            case "stealth":
                currentStats.setStealth(value);
                return;
            case "sleight":
                currentStats.setSleight(value);
                return;
            case "contortion":
                currentStats.setContortion(value);
                return;
            case "emotional":
                currentStats.setEmotional(value);
                return;
            case "athletics":
                currentStats.setAthletics(value);
                return;
            case "brawn":
                currentStats.setBrawn(value);
                return;
            case "resistance":
                currentStats.setResistance(value);
                return;
            case "deception":
                currentStats.setDeception(value);
                return;
            case "intimidation":
                currentStats.setIntimidation(value);
                return;
            case "persuasion":
                currentStats.setPersuasion(value);
                return;
            case "performance":
                currentStats.setPerformance(value);
                return;
            case "investigation":
                currentStats.setInvestigation(value);
                return;
            case "nature":
                currentStats.setNature(value);
                return;
            case "religion":
                currentStats.setReligion(value);
                return;
            case "perception":
                currentStats.setPerception(value);
                return;
            case "medicine":
                currentStats.setMedicine(value);
                return;
            case "handling":
                currentStats.setHandling(value);
                return;
            case "insight":
                currentStats.setInsight(value);
                return;
            case "survival":
                currentStats.setSurvival(value);
                return;
            case "innuendo":
                currentStats.setInnuendo(value);
                return;
            default:
                return;

        }

    }

    private void printHelp(Player player){

        player.sendMessage(ChatColor.GOLD + "-===--+ MordSheets Help +--===-");
        player.sendMessage(ChatColor.BLUE + "- /rs help");
        player.sendMessage(ChatColor.BLUE + "- /rs add (username) (stat) (amount)");
        player.sendMessage(ChatColor.BLUE + "- /rs remove (username) (stat) (amount)");
        player.sendMessage(ChatColor.BLUE + "- /rs check");
        player.sendMessage(ChatColor.BLUE + "- /rs list");
        player.sendMessage(ChatColor.GOLD + "-===--+++++++++++++++++--===-");

    }

}
