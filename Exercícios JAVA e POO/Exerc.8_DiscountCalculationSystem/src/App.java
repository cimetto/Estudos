public class App {
    public static void main(String[] args) {

        Customer c1 = new Customer("VIP", 999);
        Customer c2 = new Customer("VIP", 99);
        Customer c3 = new Customer("Normal", 999);
        Customer c4 = new Customer("Normal", 99);
        
        Discount discount = new Discount();
        
        System.out.println("Antes do desconto:");
        System.out.println("Cliente 1 (VIP, R$ 999): " + c1.getPurchaseValue());
        System.out.println("Cliente 2 (VIP, R$ 99): " + c2.getPurchaseValue());
        System.out.println("Cliente 3 (Normal, R$ 999): " + c3.getPurchaseValue());
        System.out.println("Cliente 4 (Normal, R$ 99): " + c4.getPurchaseValue());
        
        System.out.println("\nApós o desconto:");
        System.out.println("Novo valor de compra Cliente 1: " + discount.discountCalculate(c1));
        System.out.println("Novo valor de compra Cliente 2: " + discount.discountCalculate(c2));
        System.out.println("Novo valor de compra Cliente 3: " + discount.discountCalculate(c3));
        System.out.println("Novo valor de compra Cliente 4: " + discount.discountCalculate(c4));
    }
}