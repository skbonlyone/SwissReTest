package org.swissre;

public class GenerateReceiptOfOrder {

    private static final String RECEIPT_HEADER = "Charlene's Coffee Corner\n";
    private static final String LINE_SEPARATOR = "-----------------------------------\n";

    public String generateReceipt(CustomerOrder customerOrder, TrackOfBonous trackOfBonous) {
        StringBuilder receipt = new StringBuilder();
        receipt.append(RECEIPT_HEADER).append(LINE_SEPARATOR);

        double total = 0.0;
        boolean hasBeverageAndSnack = customerOrder.hasBeverageAndSnack();
        boolean freeBeverageApplied = false;
        boolean freeExtraApplied = false;

        for (Product product : customerOrder.getItems()) {
            if (product.isBeverage() && !freeBeverageApplied && trackOfBonous.isBeverageFree()) {
                receipt.append(product.getName()).append(" - FREE\n");
                freeBeverageApplied = true;
                continue;
            }

            if (product.isExtra() && hasBeverageAndSnack && !freeExtraApplied) {
                receipt.append(product.getName()).append(" - FREE\n");
                freeExtraApplied = true;
                continue;
            }

            receipt.append(product.getName()).append(" - ")
                    .append(String.format("%.2f CHF", product.getPrice())).append("\n");
            total = total+product.getPrice();
        }

        receipt.append(LINE_SEPARATOR);
        receipt.append("Total: ").append(String.format("%.2f CHF", total)).append("\n");
        return receipt.toString();
    }
}
