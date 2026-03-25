package service;

import model.Auto;
import model.Kunde;
import model.Miete;

import java.util.ArrayList;

public class AutovermietungSystem {

    private ArrayList<Auto> autos = new ArrayList<>();
    private ArrayList<Kunde> kunden = new ArrayList<>();
    private ArrayList<Miete> mieten = new ArrayList<>();

    public void autoHinzufuegen(Auto auto) {
        autos.add(auto);
    }

    public void kundenHinzufuegen(Kunde kunde) {
        kunden.add(kunde);
    }

    public void zeigeAutos() {
        for (int i = 0; i < autos.size(); i++) {
            Auto a = autos.get(i);
            if (a.istVerfuegbar()) {
                System.out.println(i + ": " + a);
            }
        }
    }

    public Auto getAuto(int index) {
        return autos.get(index);
    }

    public void mieteErstellen(Miete miete) {
        mieten.add(miete);
        miete.bestaetigen();
        miete.bezahlen();
    }
}