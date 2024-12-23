public class Discount {
    final static double DISCOUNT_VIP = 0.1;
    final static double DISCOUNT_NORMAL = 0.05;
    final static double PURCHASE_LIMIT = 100;
    
    public String discountCalculate(Customer customer){
        double discount = 0;

        if (customer.getPurchaseValue() < PURCHASE_LIMIT) {
            return "Valor indisponível para aplicação de desconto!";
        }

        if (customer.getCustomerType().equals("VIP")) {
            discount = customer.getPurchaseValue() * DISCOUNT_VIP;
        } else if (customer.getCustomerType().equals("Normal")) {
            discount = customer.getPurchaseValue() * DISCOUNT_NORMAL;
        }

        double newPurchaseValue = customer.getPurchaseValue() - discount;
        customer.setPurchaseValue(newPurchaseValue);
        
        return String.format("R$ %.2f", newPurchaseValue);
    }
}
