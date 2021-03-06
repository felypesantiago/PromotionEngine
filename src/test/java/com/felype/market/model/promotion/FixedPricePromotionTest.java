package com.felype.market.model.promotion;

import com.felype.market.model.Product;
import com.felype.market.model.ShoppingCart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FixedPricePromotionTest {

    private IPromotion promotion;

    private Product product;

    private double fixedPromotionPrice;

    @BeforeEach
    public void setUp() {
        product = new Product('A', 5.0);
        fixedPromotionPrice = 12.0;

        PromotionRequirement promotionRequirement = new PromotionRequirement(product, 3);
        promotion = new FixedPricePromotion(promotionRequirement, fixedPromotionPrice);
    }

    @Test
    public void testIsApplicableReturnsTrue() {
        ShoppingCart shoppingCart = new ShoppingCart(Arrays.asList(product, product, product));

        assertTrue(promotion.isApplicable(shoppingCart));
    }

    @Test
    public void testIsApplicableReturnsFalse() {
        ShoppingCart shoppingCart = new ShoppingCart(Arrays.asList(product, product));

        assertFalse(promotion.isApplicable(shoppingCart));
    }

    @Test
    public void testCalculateDiscountWhenApplicable() {
        ShoppingCart shoppingCart = new ShoppingCart(Arrays.asList(product, product, product));

        Assertions.assertEquals(product.getPrice() * 3 - fixedPromotionPrice,
                promotion.calculateDiscount(shoppingCart));
    }

    @Test
    public void testCalculateDiscountWhenNotApplicable() {
        ShoppingCart shoppingCart = new ShoppingCart(Arrays.asList(product, product));

        Assertions.assertEquals(0.0, promotion.calculateDiscount(shoppingCart));
    }

}
