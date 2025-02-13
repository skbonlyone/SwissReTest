package org.swissre;

import java.util.ArrayList;
import java.util.List;

public class CustomerOrder {
    private List<Product> items = new ArrayList<>();

    public void addProduct(Product product) {
        items.add(product);
    }

    public List<Product> getItems() {
        return items;
    }

    public long getBeverageCount() {
        return items.stream().filter(Product::isBeverage).count();
    }

    public boolean hasBeverageAndSnack() {
        boolean hasBeverage = items.stream().anyMatch(Product::isBeverage);
        boolean hasSnack = items.stream().anyMatch(p -> !p.isBeverage() && !p.isExtra());
        return hasBeverage && hasSnack;
    }

}
