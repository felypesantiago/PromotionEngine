package com.felype.market.model.promotion;

import com.felype.market.model.Product;

public class PromotionRequirement {

    private Product product;
    private int amount;

    public PromotionRequirement(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

}
