package org.swissre;

import java.util.Arrays;
import java.util.List;

public class MainClassCoffeeShop {

    public static void main(String[] args) {
        TrackOfBonous trackOfBonous = new TrackOfBonous();
        CustomerOrder customerOrder = new CustomerOrder();

        List<Product> products = Arrays.asList(
                new Product("Large Coffee", 3.50, true, false),
                new Product("Bacon Roll", 4.50, false, false),
                new Product("Extra Milk", 0.30, false, true)
        );

        products.forEach(customerOrder::addProduct);

        GenerateReceiptOfOrder generateReceiptOfOrder = new GenerateReceiptOfOrder();
        System.out.println(generateReceiptOfOrder.generateReceipt(customerOrder, trackOfBonous));
    }

}
