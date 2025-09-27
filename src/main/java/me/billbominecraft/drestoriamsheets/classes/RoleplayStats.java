package me.billbominecraft.drestoriamsheets.classes;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;

public class RoleplayStats {

    private int acrobatics;
    private int stealth;
    private int sleight;
    private int contortion;

    private int emotional;
    private int athletics;
    private int brawn;
    private int resistance;

    private int deception;
    private int intimidation;
    private int persuasion;
    private int performance;

    private int investigation;
    private int nature;
    private int religion;
    private int perception;
    private int medicine;

    private int handling;
    private int insight;
    private int survival;
    private int innuendo;

    public RoleplayStats(){

        acrobatics = 0;
        stealth = 0;
        sleight = 0;
        contortion = 0;

        emotional = 0;
        athletics = 0;
        brawn = 0;
        resistance = 0;

        deception = 0;
        intimidation = 0;
        persuasion = 0;
        performance = 0;

        investigation = 0;
        nature = 0;
        religion = 0;
        perception = 0;
        medicine = 0;

        handling = 0;
        insight = 0;
        survival = 0;
        innuendo = 0;

    }

    public int getAcrobatics() {return acrobatics;}

    public void setAcrobatics(int acrobatics) {this.acrobatics = acrobatics;}

    public int getStealth() {return stealth;}

    public void setStealth(int stealth) {this.stealth = stealth;}

    public int getSleight() {return sleight;}

    public void setSleight(int sleight) {this.sleight = sleight;}

    public int getContortion() {return contortion;}

    public void setContortion(int contortion) {this.contortion = contortion;}

    public int getEmotional() {return emotional;}

    public void setEmotional(int emotional) {this.emotional = emotional;}

    public int getAthletics() {return athletics;}

    public void setAthletics(int athletics) {this.athletics = athletics;}

    public int getBrawn() {return brawn;}

    public void setBrawn(int brawn) {this.brawn = brawn;}

    public int getResistance() {return resistance;}

    public void setResistance(int resistance) {this.resistance = resistance;}

    public int getDeception() {return deception;}

    public void setDeception(int deception) {this.deception = deception;}

    public int getIntimidation() {return intimidation;}

    public void setIntimidation(int intimidation) {this.intimidation = intimidation;}

    public int getPersuasion() {return persuasion;}

    public void setPersuasion(int persuasion) {this.persuasion = persuasion;}

    public int getPerformance() {return performance;}

    public void setPerformance(int performance) {this.performance = performance;}

    public int getInvestigation() {return investigation;}

    public void setInvestigation(int investigation) {this.investigation = investigation;}

    public int getNature() {return nature;}

    public void setNature(int nature) {this.nature = nature;}

    public int getReligion() {return religion;}

    public void setReligion(int religion) {this.religion = religion;}

    public int getPerception() {return perception;}

    public void setPerception(int perception) {this.perception = perception;}

    public int getMedicine() {return medicine;}

    public void setMedicine(int medicine) {this.medicine = medicine;}

    public int getHandling() {return handling;}

    public void setHandling(int handling) {this.handling = handling;}

    public int getInsight() {return insight;}

    public void setInsight(int insight) {this.insight = insight;}

    public int getSurvival() {return survival;}

    public void setSurvival(int survival) {this.survival = survival;}

    public int getInnuendo() {return innuendo;}

    public void setInnuendo(int innuendo) {this.innuendo = innuendo;}

    public void printStats(Player player){

        int dexterity = getAcrobatics() + getStealth() + getSleight() + getContortion();
        int strength = getEmotional() + getAthletics() + getBrawn() + getResistance();
        int charisma = getDeception() + getIntimidation() + getPersuasion() + getPerformance();
        int intelligence = getInvestigation() + getNature() + getReligion() + getPerception() + getMedicine();
        int wisdom = getHandling() + getInsight() + getSurvival() + getInnuendo();

        player.sendMessage(ChatColor.BLUE + "-===--+++--===-\n");

        player.sendMessage(ChatColor.GOLD + "\nDexterity - " + dexterity + "\n");

        player.sendMessage(ChatColor.BLUE + "\nAcrobatics: " + getAcrobatics() + "\nStealth: " + getStealth() + "\nSleight of Hand: " + getSleight() + "\nContortion: " + getContortion() + "\n");

        player.sendMessage(ChatColor.GOLD + "\nStrength - " + strength + "\n");

        player.sendMessage(ChatColor.BLUE + "\nEmotional: " + getEmotional() + "\nAthletics: " + getAthletics() + "\nBrawn: " + getBrawn() + "\nResistance: " + getResistance() + "\n");

        player.sendMessage(ChatColor.GOLD + "\nCharisma - " + charisma + "\n");

        player.sendMessage(ChatColor.BLUE + "\nDeception: " + getDeception() + "\nIntimidation: " + getIntimidation() + "\nPersuasion: " + getPersuasion() + "\nPerformance: " + getPerformance() + "\n");

        player.sendMessage(ChatColor.GOLD + "\nIntelligence - " + intelligence + "\n");

        player.sendMessage(ChatColor.BLUE + "\nInvestigation: " + getInvestigation() + "\nNature: " + getNature() + "\nReligion: " + getReligion() + "\nPerception: " + getPerception() + "\nMedicine: " + getMedicine() + "\n");

        player.sendMessage(ChatColor.GOLD + "\nWisdom - " + wisdom + "\n");

        player.sendMessage(ChatColor.BLUE + "\nAnimal Handling: " + getHandling() + "\nInsight: " + getInsight() + "\nSurvival: " + getSurvival() + "\nInnuendo: " + getInnuendo() + "\n");

        player.sendMessage(ChatColor.GOLD + "-===--+++--===-");

    }

}
