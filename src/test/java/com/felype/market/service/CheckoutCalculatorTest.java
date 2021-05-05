package com.felype.market.service;

import com.felype.market.model.Product;
import com.felype.market.model.ShoppingCart;
import com.felype.market.model.promotion.FixedPricePromotion;
import com.felype.market.model.promotion.PromotionRequirement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutCalculatorTest {

    private CheckoutCalculator checkoutCalculator;

    private PromotionService promotionService;

    @BeforeEach
    public void setUp() {
        promotionService = new PromotionService();
        checkoutCalculator = new CheckoutCalculator(promotionService);
    }

    @Test
    public void testCalculatePriceForEmptyCart() {
        ShoppingCart shoppingCart = new ShoppingCart(new ArrayList<>());

        assertEquals(0, checkoutCalculator.calculatePrice(shoppingCart));
    }

    @Test
    public void testCalculatePriceWhenThereIsNoPromotions() {
        promotionService.clearPromotions();

        Product productA = new Product('A', 2.0);
        Product productB = new Product('B', 3.0);

        ShoppingCart shoppingCart = new ShoppingCart(Arrays.asList(productA, productB));

        assertEquals(productA.getPrice() + productB.getPrice(),
                checkoutCalculator.calculatePrice(shoppingCart));
    }

    @Test
    public void testCalculatePriceWhenThereArePromotions() {
        Product productA = new Product('A', 2.0);
        Product productB = new Product('B', 3.0);

        PromotionRequirement promotionRequirement = new PromotionRequirement(productA, 2);
        FixedPricePromotion promotion = new FixedPricePromotion(promotionRequirement, 3.0);
        promotionService.addPromotion(promotion);

        ShoppingCart shoppingCart = new ShoppingCart(Arrays.asList(productA, productA, productB));

        assertTrue(productA.getPrice() + productA.getPrice() + productB.getPrice() >
                checkoutCalculator.calculatePrice(shoppingCart));
    }

}
