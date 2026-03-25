package payment;

public class PayPalZahlung implements ZahlungsStrategy {
    @Override
    public void bezahlen(double betrag) {
        System.out.println("Bezahlt mit PayPal: " + betrag + "€");
    }
}
