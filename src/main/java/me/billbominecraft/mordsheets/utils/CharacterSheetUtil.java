package me.billbominecraft.mordsheets.utils;

import com.google.gson.Gson;
import me.billbominecraft.mordsheets.MordSheets;
import me.billbominecraft.mordsheets.classes.CharacterSheet;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.io.*;

import static me.billbominecraft.mordsheets.MordSheets.tag;

public class CharacterSheetUtil {

    public static boolean createSheet(Player player) throws IOException {

        CharacterSheet characterSheet = new CharacterSheet(player);

        File file = new File(MordSheets.getPlugin().getDataFolder().getAbsolutePath() + "/" + player.getUniqueId() + ".json");

        if(!file.getParentFile().exists()){

            file.getParentFile().mkdir();

        }

        if(file.exists()){

            player.sendMessage(tag + ChatColor.RED + "You already have a character sheet. Please use /cs set.");
            return false;

        }

        file.createNewFile();
        saveSheet(characterSheet, file);
        player.sendMessage(tag + "Character sheet created. Please do /cs set to add values.");

        return true;
    }

    public static CharacterSheet findSheet(Player player, Player sender) throws IOException {

        File file = new File(MordSheets.getPlugin().getDataFolder().getAbsolutePath() + "/" + player.getUniqueId() + ".json");

        if(!file.exists()){

            sender.sendMessage(tag + ChatColor.RED + "The player provided does not have a character sheet.");
            return null;

        }

        return loadSheet(file);

    }

    public static CharacterSheet updateSheet(Player player, String field, String value) throws IOException {

        File file = new File(MordSheets.getPlugin().getDataFolder().getAbsolutePath() + "/" + player.getUniqueId() + ".json");

        if(!file.exists()){

            player.sendMessage(tag + ChatColor.RED + "You do not have a character sheet. Please create one with /cs create.");
            return null;

        }

        CharacterSheet sheet = loadSheet(file);

        switch (field.toLowerCase()){

            case "name":
                sheet.setRpName(value);
                break;

            case "age":
                sheet.setAge(Integer.parseInt(value));
                break;

            case "race":
                sheet.setRace(value);
                break;

            case "appearance":
                sheet.setAppearance(value);
                break;

            case "personality":
                sheet.setPersonality(value);
                break;

            case "background":
                sheet.setBackground(value);
                break;

            case "link":
                sheet.setBackgroundLink(value);
                break;

            default:
                player.sendMessage(tag + ChatColor.RED + "Please use /cs set (name | age | race | appearance | personality | background | link) (value)");
                return null;
        }

        saveSheet(sheet, file);

        player.sendMessage(tag + ChatColor.GOLD + "Sheet has been successfully updated!");

        return sheet;

    }

    /*public static void deleteSheet(UUID id){

        for(CharacterSheet sheet: sheets){

            if(sheet.getPlayerID().equals(id)){

                sheets.remove(sheet);
                break;

            }

        }

        try {
            saveSheets();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<CharacterSheet> findAllSheets(){

        return sheets;

    }*/

    public static void saveSheet(CharacterSheet sheet, File file) throws IOException {

        Gson gson = new Gson();
        Writer writer = new FileWriter(file, false);
        gson.toJson(sheet, writer);
        writer.flush();
        writer.close();
        System.out.println("[MordSheets] File save complete");

    }

    public static CharacterSheet loadSheet(File file) throws IOException{

        if(file.exists()){

            Gson gson = new Gson();
            Reader reader = new FileReader(file);
            return gson.fromJson(reader, CharacterSheet.class);

        }

        System.out.println("[MordSheets] No file found on load");
        return null;
    }

}
