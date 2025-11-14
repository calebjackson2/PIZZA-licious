package com.pluralsight;

public class MeatTopping extends Topping {
    private String size; // regular, large, xl

    public MeatTopping(String name, String size) {
        super(name, 0.00);
        this.size = (size == null) ? "regular" : size.toLowerCase();
    }

    @Override
    public double getPrice() {
        return switch (size) {
            case "regular" -> 0.50;
            case "large" -> 1.00;
            case "xl", "extra large" -> 1.50;
            default -> 0.50;
        };
    }
    @Override
    public String toString() {
        return name + " (" + size + ") - $" + String.format("%.2f", getPrice());
    }
}
