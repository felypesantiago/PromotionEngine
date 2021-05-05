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

    private FixedPricePromotion fixedPricePromotion;

    private Product product = new Product('A', 5.0);

    private double fixedPromotionPrice = 12.0;

    @BeforeEach
    public void setUp() {
        product = new Product('A', 5.0);

        PromotionRequirement promotionRequirement = new PromotionRequirement(product, 3);
        fixedPricePromotion = new FixedPricePromotion(promotionRequirement, fixedPromotionPrice);
    }

    @Test
    public void testIsApplicableReturnsTrue() {
        ShoppingCart shoppingCart = new ShoppingCart(Arrays.asList(product, product, product));

        assertTrue(fixedPricePromotion.isApplicable(shoppingCart));
    }

    @Test
    public void testIsApplicableReturnsFalse() {
        ShoppingCart shoppingCart = new ShoppingCart(Arrays.asList(product, product));

        assertFalse(fixedPricePromotion.isApplicable(shoppingCart));
    }

    @Test
    public void testCalculateDiscountWhenApplicable() {
        ShoppingCart shoppingCart = new ShoppingCart(Arrays.asList(product, product, product));

        Assertions.assertEquals(product.getPrice() * 3 - fixedPromotionPrice,
                fixedPricePromotion.calculateDiscount(shoppingCart));
    }

    @Test
    public void testCalculateDiscountWhenNotApplicable() {
        ShoppingCart shoppingCart = new ShoppingCart(Arrays.asList(product, product));

        Assertions.assertEquals(0.0, fixedPricePromotion.calculateDiscount(shoppingCart));
    }

}
