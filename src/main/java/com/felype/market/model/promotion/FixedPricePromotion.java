package com.felype.market.model.promotion;

import com.felype.market.model.ShoppingCart;

public class FixedPricePromotion implements IPromotion {

    private PromotionRequirement requirement;
    private double price;

    public FixedPricePromotion(PromotionRequirement requirement, double price) {
        this.requirement = requirement;
        this.price = price;
    }

    @Override
    public boolean isApplicable(ShoppingCart cart) {
        return cart.getProducts().stream()
                .filter(product -> product.getSku() == requirement.getProduct().getSku())
                .count() >= requirement.getAmount();
    }

    @Override
    public double calculateDiscount(ShoppingCart cart) {
        long count = cart.getProducts().stream()
                .filter(product -> product.getSku() == requirement.getProduct().getSku())
                .count();

        double normalPrice = count * requirement.getProduct().getPrice();
        double discountPrice = (count / requirement.getAmount()) * price
                + (count % requirement.getAmount()) * requirement.getProduct().getPrice();

        return normalPrice - discountPrice;
    }

}
