package com.felype.market.model.promotion;

import com.felype.market.model.ShoppingCart;

public interface IPromotion {

    boolean isApplicable(ShoppingCart cart);

    double calculateDiscount(ShoppingCart cart);

}
