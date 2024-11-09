public class PaymentSlip implements Payment{

    public void paymentProcess(double value) {
        System.out.format("\nPagamento realizado com Boleto Bancário no valor de: R$%.2f\n", value);
    }
    
}
