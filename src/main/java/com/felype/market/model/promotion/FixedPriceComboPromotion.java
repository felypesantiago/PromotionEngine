package com.felype.market.model.promotion;

import com.felype.market.model.Product;
import com.felype.market.model.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class FixedPriceComboPromotion implements IPromotion {

    private List<PromotionRequirement> requirements;
    private double price;

    public FixedPriceComboPromotion(List<PromotionRequirement> requirements, double price) {
        this.requirements = requirements;
        this.price = price;
    }

    @Override
    public boolean isApplicable(ShoppingCart cart) {
        for (PromotionRequirement requirement : requirements) {
            if (cart.getProducts().stream()
                    .filter(product -> product.getSku() == requirement.getProduct().getSku())
                    .count() < requirement.getAmount()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public double calculateDiscount(ShoppingCart cart) {
        double result = 0.0;

        List<Product> products = new ArrayList<>();
        products.addAll(cart.getProducts());

        ShoppingCart tempShoppingCart = new ShoppingCart(products);

        while (isApplicable(tempShoppingCart)) {
            double normalPrice = 0.0;

            for (PromotionRequirement requirement : requirements) {
                removeProduct(products, requirement.getProduct(), requirement.getAmount());

                normalPrice = normalPrice + requirement.getProduct().getPrice() * requirement.getAmount();
            }

            result = result + normalPrice - price;
        }

        return result;
    }

    private void removeProduct(List<Product> products, Product product, int amount) {
        for (int i = 0; i < amount; i++) {
            products.remove(product);
        }
    }

}
