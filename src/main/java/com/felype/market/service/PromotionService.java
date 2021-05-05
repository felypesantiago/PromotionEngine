package com.felype.market.service;

import com.felype.market.model.ShoppingCart;
import com.felype.market.model.promotion.IPromotion;

import java.util.ArrayList;
import java.util.List;

public class PromotionService {

    private List<IPromotion> promotions;

    public PromotionService() {
        this.promotions = new ArrayList<>();
    }

    public double calculateDiscount(ShoppingCart shoppingCart) {
        return promotions.stream()
                .filter(promotion -> promotion.isApplicable(shoppingCart))
                .map(promo -> promo.calculateDiscount(shoppingCart))
                .reduce(0.0, (a, b) -> a + b);
    }

    public void addPromotion(IPromotion promotion) {
        promotions.add(promotion);
    }

    public void clearPromotions() {
        promotions.clear();
    }

}
