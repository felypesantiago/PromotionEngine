package com.felype.market.service;

import com.felype.market.model.Product;
import com.felype.market.model.ShoppingCart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PromotionServiceTest {

    private PromotionService promotionService;

    @BeforeEach
    public void setUp() {
        promotionService = new PromotionService();
    }

    @Test
    public void testCalculateDiscountForEmptyCart() {
        ShoppingCart shoppingCart = new ShoppingCart(Arrays.asList());

        assertEquals(0.0, promotionService.calculateDiscount(shoppingCart));
    }

    @Test
    public void testCalculateDiscountForEmptyPromotions() {
        Product productA = new Product('A', 2.0);
        Product productB = new Product('B', 3.0);

        ShoppingCart shoppingCart = new ShoppingCart(Arrays.asList(productA, productB));

        assertEquals(0.0, promotionService.calculateDiscount(shoppingCart));
    }

}
