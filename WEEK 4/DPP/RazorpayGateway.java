package week_4.dpp;


public class RazorpayGateway {
    // Razorpay's API expects amount and currency in a different order, and works in paise
    public void pay(String currency, double amountInRupees) {
        System.out.println("[Razorpay] Paying " + amountInRupees + " " + currency);
    }
}
