package me.billbominecraft.mordsheets.classes;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.UUID;

public class CharacterSheet {

    private transient Player player;
    //private UUID playerID = player.getUniqueId();

    private String rpName = "test";
    private int age = 1;
    private String race = "test";
    private String appearance = "test";
    private String personality = "test";
    private String background = "test";
    private String backgroundLink = "test";

    public CharacterSheet(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    //public UUID getPlayerID() {return playerID;}

    //public void setPlayerID(UUID playerID) {this.playerID = playerID;}

    public String getRpName() {
        return rpName;
    }

    public void setRpName(String rpName) {
        this.rpName = rpName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getBackgroundLink() {
        return backgroundLink;
    }

    public void setBackgroundLink(String backgroundLink) {
        this.backgroundLink = backgroundLink;
    }

    public void printSheet(Player player){

        player.sendMessage(ChatColor.GOLD + "-===--+++--===-\n");
        player.sendMessage(ChatColor.BLUE + "Name: " + getRpName() + "\nAge: " + getAge() + "\nRace: " + getRace() + "\nAppearance: " + getAppearance() + "\nPersonality: " + getPersonality() + "\nBrief Background: " + getBackground() + "\nIn-Depth Background Link: " + getBackgroundLink());
        player.sendMessage(ChatColor.GOLD + "-===--+++--===-");

    }
}
