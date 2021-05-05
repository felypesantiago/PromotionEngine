package com.felype.market.model;

import java.util.List;

public class ShoppingCart {

    private List<Product> products;

    public ShoppingCart(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }
}
