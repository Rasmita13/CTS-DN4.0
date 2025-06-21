import java.util.HashMap;

class Product {
    String id, name;
    int quantity;
    double price;

    public Product(String id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}

public class Inventory {
    private HashMap<String, Product> inventory = new HashMap<>();

    public void addProduct(Product p) {
        inventory.put(p.id, p);
    }

    public void updateProduct(String id, Product newProduct) {
        inventory.put(id, newProduct);
    }

    public void deleteProduct(String id) {
        inventory.remove(id);
    }

    public void printInventory() {
        for (Product p : inventory.values()) {
            System.out.println(p.id + " | " + p.name + " | Qty: " + p.quantity + " | Price: " + p.price);
        }
    }

    public static void main(String[] args) {
        Inventory inv = new Inventory();
        inv.addProduct(new Product("P101", "Laptop", 5, 999.99));
        inv.addProduct(new Product("P102", "Mouse", 15, 19.99));

        System.out.println("--- After Adding Products ---");
        inv.printInventory();

        inv.updateProduct("P102", new Product("P102", "Mouse", 20, 18.99));

        System.out.println("--- After Updating Mouse Quantity & Price ---");
        inv.printInventory();

        inv.deleteProduct("P101");
        System.out.println("--- After Deleting Laptop ---");
        inv.printInventory();
    }
}
