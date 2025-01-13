package org;

public class Main {
    public static void main(String[] args) {
        StockManager stock = new StockManager();

            stock.addProduct(new Product("Apple", 0.5, 10));
            stock.addProduct(new Product("Banana", 0.3, 20));
            stock.addProduct(new Product("Laptop", 1599.90, 10));
            stock.addProduct(new Product("Fridge", 799.90, 10));
            stock.addProduct(new Product("", -1, 0));
            stock.addProduct(new Product("TV", 1199.90, 10));

        stock.printStock();
    }
}
