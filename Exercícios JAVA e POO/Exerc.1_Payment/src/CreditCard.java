public class CreditCard implements Payment{

    public void paymentProcess(double value) {
        System.out.format("\nPagamento realizado com Cartão de Crédito no valor de: R$%.2f\n", value);
    }
}
