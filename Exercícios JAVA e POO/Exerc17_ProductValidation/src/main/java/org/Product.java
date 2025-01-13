package org;

public class Product {
    private String name;
    private double price;
    private int amount;

    public Product(String name, double price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public void validate(){
        if (name.isEmpty()) {
            throw new InvalidNameException("Error: Name cannot be empty");
        }
        if (price < 0) {
            throw new InvalidPriceException("Error: Price cannot be negative");
        }
        if (amount < 0) {
            throw new InvalidAmountException("Error: Amount cannot be negative");
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Price: " + price + ", Amount: " + amount;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }
}
