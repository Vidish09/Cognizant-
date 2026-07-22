public class PayPalAdapter implements PaymentProcessor {
    private final PayPalGateway payPalGateway;

    PayPalAdapter(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }

    @Override
    public void processPayment(double amount, String currency) {
        if (!currency.equalsIgnoreCase("USD")) {
            System.out.println("[PayPalAdapter] Note: PayPal gateway here only supports USD in this demo.");
        }
        payPalGateway.makePayPalPayment(amount);
    }
}
