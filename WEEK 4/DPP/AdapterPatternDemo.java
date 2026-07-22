

import java.util.ArrayList;
import java.util.List;

interface PaymentProcessor {
    void processPayment(double amount, String currency);
}

class PayPalGateway {
    void sendPayment(double amount, String currency) {
        System.out.println("PayPal processed payment of " + amount + " " + currency);
    }
}

class StripeGateway {
    void createCharge(double amount, String currency) {
        System.out.println("Stripe processed payment of " + amount + " " + currency);
    }
}

class RazorpayGateway {
    void makePayment(double amount, String currency) {
        System.out.println("Razorpay processed payment of " + amount + " " + currency);
    }
}

class PayPalAdapter implements PaymentProcessor {
    private final PayPalGateway gateway;

    PayPalAdapter(PayPalGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void processPayment(double amount, String currency) {
        gateway.sendPayment(amount, currency);
    }
}

class StripeAdapter implements PaymentProcessor {
    private final StripeGateway gateway;

    StripeAdapter(StripeGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void processPayment(double amount, String currency) {
        gateway.createCharge(amount, currency);
    }
}

class RazorpayAdapter implements PaymentProcessor {
    private final RazorpayGateway gateway;

    RazorpayAdapter(RazorpayGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void processPayment(double amount, String currency) {
        gateway.makePayment(amount, currency);
    }
}

public class AdapterPatternDemo {
    public static void main(String[] args) {
        List<PaymentProcessor> processors = new ArrayList<>();

        // Wrap each gateway's own object inside its adapter
        processors.add(new PayPalAdapter(new PayPalGateway()));
        processors.add(new StripeAdapter(new StripeGateway()));
        processors.add(new RazorpayAdapter(new RazorpayGateway()));

        for (PaymentProcessor processor : processors) {
            processor.processPayment(49.99, "USD");
            System.out.println("--------------------------------------------------");
        }
    }
}
