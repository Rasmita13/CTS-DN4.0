class Paypal {
    void makePayment(double amount) {
        System.out.println("[Paypal] Payment of $" + amount + " done.");
    }
}

class Stripe {
    void pay(double amount) {
        System.out.println("[Stripe] Payment of $" + amount + " done.");
    }
}
class PaypalAdapter implements PaymentProcessor {
    private Paypal paypal = new Paypal();

    public void processPayment(double amount) {
        paypal.makePayment(amount);
    }
}

class StripeAdapter implements PaymentProcessor {
    private Stripe stripe = new Stripe();

    public void processPayment(double amount) {
        stripe.pay(amount);
    }
}

