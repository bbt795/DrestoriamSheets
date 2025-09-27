package me.billbominecraft.drestoriamsheets.classes;

public class Wrapper {

    private CharacterSheet csheet;
    private RoleplayStats rstats;

    public Wrapper() {
        csheet = new CharacterSheet();
        rstats = new RoleplayStats();
    }

    public CharacterSheet getCsheet() {
        return csheet;
    }

    public void setCsheet(CharacterSheet csheet) {
        this.csheet = csheet;
    }

    public RoleplayStats getRstats() {
        return rstats;
    }

    public void setRstats(RoleplayStats rstats) {
        this.rstats = rstats;
    }
}
