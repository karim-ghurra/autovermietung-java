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
            System.out.println("\n===== AUTOVERMIETUNG =====");
            System.out.println("1. Autos anzeigen");
            System.out.println("2. Auto mieten");
            System.out.println("3. Beenden");

            int auswaehlen;

            try {
                auswaehlen = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Ungültige Eingabe! Bitte Zahl eingeben.");
                sc.nextLine();
                continue;
            }

            if (auswaehlen == 1) {

                System.out.println("1. Verfügbare Autos");
                System.out.println("2. Alle Autos");

                int option;

                try {
                    option = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Ungültige Eingabe!");
                    sc.nextLine();
                    continue;
                }

                if (option == 1) {
                    system.zeigeAutos(true);
                } else if (option == 2) {
                    system.zeigeAutos(false);
                } else {
                    System.out.println("Ungültige Auswahl!");
                }

            } else if (auswaehlen == 2) {

                system.zeigeAutos(true);

                System.out.print("Auto wählen: ");
                int index;

                try {
                    index = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Ungültige Eingabe!");
                    sc.nextLine();
                    continue;
                }

                Auto auto = system.getAuto(index);

                if (auto == null) {
                    System.out.println("Auto existiert nicht!");
                    continue;
                }

                if (!auto.istVerfuegbar()) {
                    System.out.println("Auto nicht verfügbar!");
                    continue;
                }

                sc.nextLine();

                System.out.print("Name: ");
                String name = sc.nextLine();
                Kunde kunde = new Kunde(name, 1);

                System.out.print("Tage: ");
                int tage;

                try {
                    tage = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Ungültige Eingabe!");
                    sc.nextLine();
                    continue;
                }

                System.out.println("Zahlung wählen: 1.Kreditkarte 2.PayPal");
                int zahlung;

                try {
                    zahlung = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Ungültige Eingabe!");
                    sc.nextLine();
                    continue;
                }

                ZahlungsStrategy strategy;

                if (zahlung == 1) {
                    strategy = new KreditkarteZahlung();
                } else if (zahlung == 2) {
                    strategy = new PayPalZahlung();
                } else {
                    System.out.println("Ungültige Auswahl!");
                    continue;
                }

                Miete miete = new Miete(auto, kunde, tage, strategy);
                system.mieteErstellen(miete);

            } else if (auswaehlen == 3) {
                System.out.println("Programm beendet.");
                break;
            } else {
                System.out.println("Ungültige Auswahl!");
            }
        }
    }
}