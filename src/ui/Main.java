package ui;

import model.Auto;
import model.Kunde;
import model.Miete;
import payment.KreditkarteZahlung;
import payment.PayPalZahlung;
import payment.ZahlungsStrategy;
import service.AutovermietungSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        AutovermietungSystem system = new AutovermietungSystem();

        system.autoHinzufuegen(new Auto("BMW", "X5", "W-123", 100));
        system.autoHinzufuegen(new Auto("Audi", "A3", "W-456", 70));

        while (true) {
            System.out.println("\n1. Autos anzeigen");
            System.out.println("2. Auto mieten");
            System.out.println("3. Beenden");

            int auswaehlen = sc.nextInt();
            if (auswaehlen == 1) {
                system.zeigeAutos();
            } else if (auswaehlen == 2) {
                system.zeigeAutos();
                System.out.print("Auto wählen: ");
                int index =sc.nextInt();
                Auto auto = system.getAuto(index);
                if (!auto.istVerfuegbar()){
                    System.out.println("Auto nicht verfügbar!");
                    continue;
                }
                sc.nextLine();
                System.out.print("Name: ");
                String name = sc.nextLine();
                Kunde kunde =new Kunde(name,1);

                System.out.println("Tage:  ");
                int tage = sc.nextInt();

                System.out.println("Zahlung wählen: 1.Kreditkarte 2.PayPal");
                int zahlung = sc.nextInt();

                ZahlungsStrategy strategy;
                if (zahlung == 1) {
                    strategy=new KreditkarteZahlung();
                }else {
                    strategy=new PayPalZahlung();
                }

                Miete miete=new Miete(auto,kunde,tage,strategy);
                system.mieteErstellen(miete);
            }else {
                break;
            }
        }
    }
}
