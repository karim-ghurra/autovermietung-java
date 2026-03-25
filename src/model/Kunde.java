package model;

public class Kunde {
    private String name;
    public  int kundenID;

    public Kunde(String name, int kundenID) {
        this.name = name;
        this.kundenID = kundenID;
    }

    public String getName() {
        return name;
    }
}
