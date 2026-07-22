package week_4.dpp;


public class StripeGateway {
    // Stripe's API works in cents, not dollars
    public void sendPayment(long amountInCents, String currencyCode) {
        System.out.println("[Stripe] Charging " + amountInCents + " cents (" + currencyCode + ")");
    }
}
