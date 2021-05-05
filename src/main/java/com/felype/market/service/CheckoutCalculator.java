package com.felype.market.service;

import com.felype.market.model.Product;
import com.felype.market.model.ShoppingCart;

public class CheckoutCalculator {

    private PromotionService promotionService;

    public CheckoutCalculator(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    public double calculatePrice(ShoppingCart shoppingCart) {
        double total = shoppingCart.getProducts().stream()
                .map(Product::getPrice)
                .reduce(0.0, (a, b) -> a + b);

        double discount = promotionService.calculateDiscount(shoppingCart);

        return total - discount;
    }

}
