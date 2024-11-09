public class App {
    public static void main(String[] args) {
        PaymentSystem system = new PaymentSystem();
        
        Payment creditcard = new CreditCard();
        Payment paymentslip = new PaymentSlip();
        
        system.makePayment(creditcard, 100);
        system.makePayment(paymentslip, 200);
    }
}
