package me.billbominecraft.drestoriamsheets.classes;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class CharacterSheet {

    private String rpName;
    private int age;
    private String race;
    private String appearance;
    private String personality;
    private String background;
    private String backgroundLink;

    public CharacterSheet() {

        rpName = "default";
        age = 1;
        race = "default";
        appearance = "default";
        personality = "default";
        background = "default";
        backgroundLink = "default";

    }

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
        player.sendMessage(ChatColor.BLUE + "Name: " + getRpName() + "\nAge: " + getAge() + "\nRace: " + getRace() + "\nAppearance: " + getAppearance() + "\nPersonality: " + getPersonality() + "\nBrief Background: " + getBackground() + "\nIn-Depth Background Link: ");

        TextComponent backgroundLinkText = new TextComponent(getBackgroundLink());
        backgroundLinkText.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, getBackgroundLink()));
        backgroundLinkText.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to Visit!").create()));
        backgroundLinkText.setColor(ChatColor.BLUE);
        player.spigot().sendMessage(backgroundLinkText);

        player.sendMessage(ChatColor.GOLD + "-===--+++--===-");

    }
}
