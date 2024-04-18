package com.saucedemo.uitests.pages.products;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        int priceComparison = Double.compare(o1.getPrice(), o2.getPrice());
        if (priceComparison != 0) {
            return priceComparison;
        }
        return o1.getProductName().compareTo(o2.getProductName());
    }
}
