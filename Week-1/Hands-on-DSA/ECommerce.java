class Product {
    String id, name, category;

    public Product(String id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }
}

public class ECommerce {
    public static Product linearSearch(Product[] products, String id) {
        for (Product p : products) {
            if (p.id.equals(id))
                return p;
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String id) {
        int low = 0, high = products.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (products[mid].id.equals(id))
                return products[mid];
            else if (products[mid].id.compareTo(id) < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product("P001", "Laptop", "Electronics"),
            new Product("P002", "Smartphone", "Electronics"),
            new Product("P003", "Headphones", "Accessories")
        };
        Product result = linearSearch(products, "P002");
        System.out.println(result != null ? "Found: " + result.name : "Not Found");
        result = binarySearch(products, "P003");
        System.out.println(result != null ? "Found: " + result.name : "Not Found");
    }
}
