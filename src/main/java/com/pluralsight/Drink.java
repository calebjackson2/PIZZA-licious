package com.pluralsight;

import java.awt.*;

public class Drink extends MenuItem {
    private String size;

    public Drink(String name, String size) {
        super(name);
        this.size = size;
    }
    public String getSize() { return size; }

    public double getPrice() {
        return switch (size.toLowerCase()) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 2.00;
        };
    }

    @Override
    public String toString() {
        return size + " " + getName() + " - $" + String.format("%.2f", getPrice());
    }
}