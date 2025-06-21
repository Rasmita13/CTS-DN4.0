public class AP {
    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PaypalAdapter();
        PaymentProcessor stripeProcessor = new StripeAdapter();

        paypalProcessor.processPayment(100.0);
        stripeProcessor.processPayment(250.0);
    }
}

