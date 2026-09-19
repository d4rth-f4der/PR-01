package lesson_1;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
    private List<Product> products;

    public ProductCatalog() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    public List<Product> getProductsByName(String query) {
        if (query == null || query.isBlank()) {
            return List.of();
        }
        String q = query.toLowerCase().trim();
        return products.stream()
                .filter(p -> p.getName() != null && p.getName().toLowerCase().contains(q))
                .toList();
    }

    public List<Product> getProductsByCategory(String query) {
        if (query == null || query.isBlank()) {
            return List.of();
        }
        String q = query.toLowerCase().trim();
        return products.stream()
                .filter(p -> p.getCategory() != null &&
                             p.getCategory().getName() != null &&
                             p.getCategory().getName().toLowerCase().contains(q))
                .toList();
    }

    public List<Product> searchProducts(String query) {
        if (query == null || query.isBlank()) {
            return List.of();
        }
        String q = query.toLowerCase().trim();
        return products.stream()
                .filter(p -> (p.getName() != null && p.getName().toLowerCase().contains(q)) ||
                             (p.getCategory() != null &&
                              p.getCategory().getName() != null &&
                              p.getCategory().getName().toLowerCase().contains(q)))
                .toList();
    }
}
