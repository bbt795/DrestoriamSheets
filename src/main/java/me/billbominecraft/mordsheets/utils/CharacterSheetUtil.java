package me.billbominecraft.mordsheets.utils;

import com.google.gson.Gson;
import me.billbominecraft.mordsheets.MordSheets;
import me.billbominecraft.mordsheets.classes.CharacterSheet;
import me.billbominecraft.mordsheets.classes.RoleplayStats;
import me.billbominecraft.mordsheets.classes.Wrapper;

import java.io.*;
import java.util.HashMap;
import java.util.List;

public class CharacterSheetUtil {

    private MordSheets plugin;
    private HashMap<String, CharacterSheet> sheetHashMap = new HashMap<>();
    private HashMap<String, RoleplayStats> statMap = new HashMap<>();

    public HashMap<String, CharacterSheet> getSheetHashMap() {return sheetHashMap;}

    public HashMap<String, RoleplayStats> getStatMap() {return statMap;}

    public CharacterSheetUtil(MordSheets plugin){
        this.plugin = plugin;
    }

    public void createSheet(String uuid){

        Wrapper wrapper = new Wrapper();

        Gson gson = new Gson();
        File file = new File(plugin.getDataFolder().getAbsolutePath() + "/"+ uuid + ".json");

        try{

            if(file.createNewFile()){

                Writer writer = new FileWriter(file, false);
                writer.write(gson.toJson(wrapper));
                writer.flush();
                writer.close();
                loadSheet(uuid);
                System.out.println("[MordSheets] Created new player file: " + uuid);

            } else {

                System.out.println("[MordSheets] Failed to create character sheet for user: " + uuid);

            }

        } catch (IOException e){

            throw new RuntimeException(e);

        }

    }

    public void saveSheet(String uuid){

        File file = new File(plugin.getDataFolder().getAbsolutePath() + "/"+ uuid + ".json");
        Gson gson = new Gson();

        if(file.exists()){

            try{

                Writer writer = new FileWriter(file, false);

                Wrapper wrapper = new Wrapper();
                wrapper.setCsheet(sheetHashMap.get(uuid));
                wrapper.setRstats(statMap.get(uuid));
                writer.write(gson.toJson(wrapper));
                writer.flush();
                writer.close();

            } catch (IOException e){

                throw new RuntimeException(e);

            }

        }

    }

    public void loadSheet(String uuid){

        File file = new File(plugin.getDataFolder().getAbsolutePath() + "/"+ uuid + ".json");

        if(file.exists()){

            Gson gson = new Gson();

            try{

                BufferedReader reader = new BufferedReader(new FileReader(file));
                Wrapper wrapper = gson.fromJson(reader, Wrapper.class);
                sheetHashMap.putIfAbsent(uuid, wrapper.getCsheet());
                statMap.putIfAbsent(uuid, wrapper.getRstats());

            } catch (FileNotFoundException e){

                throw new RuntimeException(e);

            }

        } else {

            createSheet(uuid);

        }

    }

    public boolean checkRace(String arg){

        List<String> raceList = plugin.getConfig().getStringList("races");

        for(String race : raceList){

            if(arg.equalsIgnoreCase(race)){

                return true;

            }

        }

        return false;

    }

}
