package me.minikuma._02_structual_patterns._08_composite._01_before;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private final List<Product> productList = new ArrayList<>();

    public void add(Product product) {
        productList.add(product);
    }

    public List<Product> getProducts() {
        return productList;
    }
}
