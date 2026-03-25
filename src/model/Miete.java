package model;

import payment.ZahlungsStrategy;

public class Miete {
public Auto auto;
private Kunde kunde;
private int tage;
private ZahlungsStrategy zahlungsStrategy;

    public Miete(Auto auto, Kunde kunde, int tage, ZahlungsStrategy zahlungsStrategy) {
        this.auto = auto;
        this.kunde = kunde;
        this.tage = tage;
        this.zahlungsStrategy = zahlungsStrategy;
    }
    public double berechnePreis(){
        double preis = auto.getPreisProTag()*tage;

        if (tage>=7){
            preis *=0.9;
        }
        return preis;
    }
    public void bezahlen(){
        double brtrag = berechnePreis();
        zahlungsStrategy.bezahlen(brtrag);
    }

    public void bestaetigen(){
        auto.setVerfuegbar(false);
        System.out.println("Miete bestätigt für " + kunde.getName());
    }
}
