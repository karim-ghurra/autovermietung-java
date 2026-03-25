package payment;

public class KreditkarteZahlung implements ZahlungsStrategy {
    @Override
    public void bezahlen(double betrag) {
        System.out.println("Bezahlt mit Kreditkarte: " + betrag + "€\"");
    }
}
