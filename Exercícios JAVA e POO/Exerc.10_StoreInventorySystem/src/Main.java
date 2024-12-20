public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();

        inventoryManager.addProduct("Barra de Chocolate", 6, 50);
        inventoryManager.addProduct("Chocotone", 8.50, 35);
        inventoryManager.addProduct("Peru", 27.9, 20);
        inventoryManager.addProduct("Café Preto", 9.9, 45);

        inventoryManager.displayInventory();

        inventoryManager.updatePrice("Barra de Chocolate", 8.25);
        inventoryManager.removeProduct("Peru");

        inventoryManager.getOutOfStockProducts();
        inventoryManager.calculateInventoryValue();

        inventoryManager.displayInventory();
    }
}