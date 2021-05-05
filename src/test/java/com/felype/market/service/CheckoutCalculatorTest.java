package com.felype.market.service;

import com.felype.market.model.ShoppingCart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CheckoutCalculatorTest {

    private CheckoutCalculator checkoutCalculator;

    @BeforeEach
    public void setUp() {
        checkoutCalculator = new CheckoutCalculator();
    }

    @Test
    public void testCalculatePriceForEmptyCart() {
        assertThrows(UnsupportedOperationException.class,
                () -> checkoutCalculator.calculatePrice(new ShoppingCart(new ArrayList<>())));
    }

    @Test
    public void testCalculatePriceForFullCart() {
        assertThrows(UnsupportedOperationException.class,
                () -> checkoutCalculator.calculatePrice(new ShoppingCart(new ArrayList<>())));
    }


}
