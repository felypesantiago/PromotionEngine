package com.felype.market.service;

import com.felype.market.model.Product;
import com.felype.market.model.ShoppingCart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutCalculatorTest {

    private CheckoutCalculator checkoutCalculator;

    @BeforeEach
    public void setUp() {
        checkoutCalculator = new CheckoutCalculator(new PromotionService());
    }

    @Test
    public void testCalculatePriceForEmptyCart() {
        ShoppingCart shoppingCart = new ShoppingCart(new ArrayList<>());

        assertEquals(0, checkoutCalculator.calculatePrice(shoppingCart));
    }

    @Test
    public void testCalculatePriceWhenThereIsNoPromotions() {
        Product productA = new Product('A', 2.0);
        Product productB = new Product('B', 3.0);

        ShoppingCart shoppingCart = new ShoppingCart(Arrays.asList(productA, productB));

        assertEquals(productA.getPrice() + productB.getPrice(),
                checkoutCalculator.calculatePrice(shoppingCart));
    }

}
