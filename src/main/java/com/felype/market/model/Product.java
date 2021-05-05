package com.felype.market.model;

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
}
