package org;

import java.util.ArrayList;
import java.util.List;

public class StockManager {
   private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        try {
            product.validate();
            products.add(product);
        }
        catch (InvalidNameException | InvalidPriceException | InvalidAmountException e) {
            System.err.println(e.getMessage());
        }

    }

    public void printStock() {
        System.out.println("Products in stock:");
        products.stream().forEach(product -> System.out.println(product));
    }

}
