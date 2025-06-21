public class DP {
    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PaypalAdapter();
        PaymentProcessor stripeProcessor = new StripeAdapter();

        paypalProcessor.processPayment(100.0);
        stripeProcessor.processPayment(250.0);
    }
}
interface PaymentProcessor {
    void processPayment(double amount);
}
class Paypal {
    void sendPaypalPayment(double amount) {
        System.out.println("Processing Paypal payment of $" + amount);
    }
}

class Stripe {
    void charge(double amount) {
        System.out.println("Charging Stripe payment of $" + amount);
    }
}

class PaypalAdapter implements PaymentProcessor {
    private Paypal paypal = new Paypal();

    public void processPayment(double amount) {
        paypal.sendPaypalPayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private Stripe stripe = new Stripe();

    public void processPayment(double amount) {
        stripe.charge(amount);
    }
}

