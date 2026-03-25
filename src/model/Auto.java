package model;

public class Auto {
private String marke;
private String modell;
private String kennzeichen;
private double preisProTag;
private boolean verfuegbar;

    public Auto(String marke, String modell, String kennzeichen, double preisProTag) {
        this.marke = marke;
        this.modell = modell;
        this.kennzeichen = kennzeichen;
        this.preisProTag = preisProTag;
        this.verfuegbar = true;
    }

    public boolean istVerfuegbar() {
        return verfuegbar;
    }
    public void setVerfuegbar(boolean status) {
        this.verfuegbar = status;
    }
    public double getPreisProTag() {
        return preisProTag;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "marke='" + marke + '\'' +
                ", modell='" + modell + '\'' +
                ", kennzeichen='" + kennzeichen + '\'' +
                ", preisProTag=" + preisProTag + " €"+
                '}';
    }
}
