package com.felype.market.model;

import java.util.Objects;

public class Product {

    private char sku;
    private double price;

    public Product(char sku, double price) {
        this.sku = sku;
        this.price = price;
    }

    public char getSku() {
        return sku;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return sku == product.sku;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku);
    }
}
