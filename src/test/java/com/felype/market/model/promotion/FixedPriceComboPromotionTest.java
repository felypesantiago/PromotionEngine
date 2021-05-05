package com.felype.market.model.promotion;

import com.felype.market.model.Product;
import com.felype.market.model.ShoppingCart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FixedPriceComboPromotionTest {

    private IPromotion promotion;

    private Product productA;
    private Product productB;

    private double fixedPromotionPrice;

    @BeforeEach
    public void setUp() {
        productA = new Product('A', 5.0);
        productB = new Product('B', 10.0);
        fixedPromotionPrice = 12.0;

        PromotionRequirement promotionRequirementA = new PromotionRequirement(productA, 1);
        PromotionRequirement promotionRequirementB = new PromotionRequirement(productB, 1);

        promotion = new FixedPriceComboPromotion(Arrays.asList(promotionRequirementA, promotionRequirementB),
                fixedPromotionPrice);
    }

    @Test
    public void testIsApplicableReturnsTrue() {
        ShoppingCart shoppingCart = new ShoppingCart(Arrays.asList(productA, productB, productB));

        assertTrue(promotion.isApplicable(shoppingCart));
    }

    @Test
    public void testIsApplicableReturnsFalse() {
        ShoppingCart shoppingCart = new ShoppingCart(Arrays.asList(productA, productA));

        assertFalse(promotion.isApplicable(shoppingCart));
    }

    @Test
    public void testCalculateDiscountWhenApplicable() {
        ShoppingCart shoppingCart = new ShoppingCart(Arrays.asList(productA, productB, productA, productB));

        Assertions.assertEquals((productA.getPrice() * 2 + productB.getPrice() * 2) - (fixedPromotionPrice * 2),
                promotion.calculateDiscount(shoppingCart));
    }

    @Test
    public void testCalculateDiscountWhenNotApplicable() {
        ShoppingCart shoppingCart = new ShoppingCart(Arrays.asList(productA, productA));

        Assertions.assertEquals(0.0, promotion.calculateDiscount(shoppingCart));
    }

}
