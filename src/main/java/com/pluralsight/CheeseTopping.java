package com.pluralsight;

public class CheeseTopping extends Topping {
    private String size;

    public CheeseTopping(String name, String size) {
        super(name, 0.00);
        this.size = (size == null) ? "regular" : size.toLowerCase();
    }

    @Override
    public double getPrice() {
        return switch (size) {
            case "regular" -> 0.30;
            case "large" -> 0.60;
            case "xl", "extra large" -> 0.90;
            default -> 0.30;
        };
    }

    @Override
    public String toString() {
        return name + " (" + size + ") - $" + String.format("%.2f", getPrice());
    }
}
