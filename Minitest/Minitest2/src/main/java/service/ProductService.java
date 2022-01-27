package service;

import model.Product;

import java.util.ArrayList;
import java.util.Comparator;

public class ProductService {
    private final static ArrayList<Product> products;
    private static final ArrayList<Product> productArrayList = new ArrayList<>();

    static {
        products = new ArrayList<>();
        products.add(new Product(1, "Iphone", 100000, 40, "Apple"));
        products.add(new Product(2, "Macbook", 200000, 20, "Apple"));
    }

    public Product getProduct(int id) {
        for (Product product: products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void createProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(int index, Product product) {
        products.set(index, product);
    }

    public void deleteProduct(Product product) {
        products.remove(product);
    }

    public ArrayList<Product> sortProductListAsc() {
        ArrayList<Product> sortIncreaseList = new ArrayList<>(products);
        sortIncreaseList.sort(Comparator.comparingDouble(Product::getPrice));
        return sortIncreaseList;
    }

    public ArrayList<Product> sortProductListDesc() {
        ArrayList<Product> sortDecreaseList = new ArrayList<>(products);
        sortDecreaseList.sort(Comparator.comparing(Product::getPrice).reversed());
        return sortDecreaseList;
    }
}
