public class PaymentSystem{
    public void makePayment(Payment method, double value){
        method.paymentProcess(value);
    }
}
