package org.swissre;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestCase {

    @Test
    public void testBeverageBonus() {
        TrackOfBonous trackOfBonous = new TrackOfBonous();
        CustomerOrder customerOrder = new CustomerOrder();
        GenerateReceiptOfOrder generateReceiptOfOrder = new GenerateReceiptOfOrder();

        Product coffee = new Product("Large Coffee", 3.50, true, false);
        for (int i = 0; i < 5; i++) {
            customerOrder.addProduct(coffee);
        }

        String receipt = generateReceiptOfOrder.generateReceipt(customerOrder, trackOfBonous);
        assertTrue("5th beverage should be free", receipt.contains("Large Coffee - FREE"));
    }

    @Test
    public void testSnackAndExtraBonus() {
        CustomerOrder customerOrder = new CustomerOrder();
        GenerateReceiptOfOrder generateReceiptOfOrder = new GenerateReceiptOfOrder();

        Product coffee = new Product("Medium Coffee", 3.00, true, false);
        Product baconRoll = new Product("Bacon Roll", 4.50, false, false);
        Product extraMilk = new Product("Extra Milk", 0.30, false, true);

        customerOrder.addProduct(coffee);
        customerOrder.addProduct(baconRoll);
        customerOrder.addProduct(extraMilk);

        String receipt = generateReceiptOfOrder.generateReceipt(customerOrder, new TrackOfBonous());
        assertTrue("Extra should be free when a snack and beverage are purchased",
                receipt.contains("Extra Milk - FREE"));
    }

}
