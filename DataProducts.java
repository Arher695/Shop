package ru.netology;

import java.util.HashMap;
import java.util.Map;

public class DataProducts {
    private Map<Product, Integer> products;

    public DataProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void addProduct(Product product, Integer count) {
        if (products == null) {
            products = new HashMap<>();
        }
        products.put(product, count);


    }
}
