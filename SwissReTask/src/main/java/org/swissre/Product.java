package org.swissre;

public class Product {
    private final String name;
    private final double price;
    private final boolean isBeverage;
    private final boolean isExtra;

    public Product(String name, double price, boolean isBeverage, boolean isExtra) {
        this.name = name;
        this.price = price;
        this.isBeverage = isBeverage;
        this.isExtra = isExtra;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public boolean isBeverage() { return isBeverage; }
    public boolean isExtra() { return isExtra; }

}
