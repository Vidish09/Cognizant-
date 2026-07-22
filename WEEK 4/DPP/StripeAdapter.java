public class StripeAdapter implements PaymentProcessor {
    private final StripeGateway stripeGateway;

    StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    @Override
    public void processPayment(double amount, String currency) {
        long amountInCents = Math.round(amount * 100);
        stripeGateway.charge(amountInCents, currency);
    }
}
