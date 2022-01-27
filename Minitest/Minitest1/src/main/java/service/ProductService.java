package service;

import model.Product;

import java.util.ArrayList;

public class ProductService {
    private final static ArrayList<Product> products;
    private final static ArrayList<String> brands;

    static {
        products = new ArrayList<>();
        products.add(new Product(1, "Iphone", 100000, 40, "Apple"));
        products.add(new Product(2, "Macbook", 200000, 20, "Apple"));
        brands = new ArrayList<>();
        brands.add("Apple");
        brands.add("Samsung");
        brands.add("Dell");
    }

    public ArrayList<String> getBrands() {
        return brands;
    }

    public Product getProduct(int id) {
        for (Product product: products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void createProduct(Product product) {
        products.add(product);
    }

    public void deleteProduct(Product product) {
        products.remove(product);
    }

    public void editProduct(Product product, int index) {
        products.set(index, product);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}