package com.felype.market.service;

import com.felype.market.model.ShoppingCart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PromotionServiceTest {

    private PromotionService promotionService;

    @BeforeEach
    public void setUp() {
        promotionService = new PromotionService();
    }

    @Test
    public void testCalculateDiscountForEmptyCart() {
        assertThrows(UnsupportedOperationException.class,
                () -> promotionService.calculateDiscount(new ShoppingCart(new ArrayList<>())));
    }


}
