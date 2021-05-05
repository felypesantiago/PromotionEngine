package com.felype.market.model;

public interface IPromotion {

    boolean isApplicable(ShoppingCart cart);

    double calculateDiscount(ShoppingCart cart);

}
