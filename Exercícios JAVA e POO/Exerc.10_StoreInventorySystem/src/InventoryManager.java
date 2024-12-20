import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class InventoryManager {
    private HashMap<String, Product> inventory = new HashMap<>();

    void addProduct(String name, double price, int quantity){
        if (inventory.containsKey(name)){
            Product product = inventory.get(name);
            product.setQuantity(product.getQuantity() + quantity);
        } else {
            Product newProduct = new Product(name, price, quantity);
            inventory.put(name, newProduct);
        }

    }

    void removeProduct(String name){
        inventory.remove(name);
    }

    HashSet<String> getOutOfStockProducts(){
        HashSet<String> h = new HashSet<>();

        for (Map.Entry<String, Product> entry : inventory.entrySet()) {
            Product product = entry.getValue();
            if (product.getQuantity() == 0){
             h.add(entry.getKey());
            }
        }
        return h;
    }

    void updatePrice(String name, double newPrice){
        if (inventory.containsKey(name)){
            Product product = inventory.get(name);
            product.setPrice(newPrice);
        }
    }

    double calculateInventoryValue(){
        double totalValue = 0;

        for (Map.Entry<String, Product> entry : inventory.entrySet()){
            Product product = entry.getValue();

            double productValue = product.getPrice() * product.getQuantity();
            totalValue += productValue;
        }
        return totalValue;
    }

    void displayInventory(){
        System.out.println("\nProducts:");
        for (Product p : inventory.values()) {
            System.out.format("Name: %s | Price: R$%.2f | Quantity: %d\n", p.getName(), p.getPrice(), p.getQuantity());
        }
    }
}
