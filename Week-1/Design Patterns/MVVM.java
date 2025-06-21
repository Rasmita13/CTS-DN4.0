
class Product {
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
class ProductViewModel {
    private Product product;

    public ProductViewModel(Product product) {
        this.product = product;
    }

    public String getProductName() {
        return "Product Name: " + product.getName();
    }
}
class ProductView {
    public void displayProduct(String data) {
        System.out.println(data);
    }
}
public class MVVM {
    public static void main(String[] args) {
        Product model = new Product("Laptop");
        ProductViewModel viewModel = new ProductViewModel(model);
        ProductView view = new ProductView();
        view.displayProduct(viewModel.getProductName());
    }
}
