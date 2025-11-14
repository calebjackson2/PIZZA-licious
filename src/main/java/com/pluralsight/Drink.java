package com.pluralsight;

import java.util.Locale;

public class Drink extends MenuItem {
    private String size;

    public Drink(String name, String size) {
        super(name == null ? "Drink" : name);
        this.size = (size == null) ? "medium" : size;
    }

    public String getSize() {
        return size;
    }

    @Override
    public double getPrice() {
        return switch (size.toLowerCase(Locale.ROOT)) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 2.50;
        };
    }
    @Override
    public String toString() {
        return String.format("%s (%s) - $%.2f", getName(), capitalize(size), getPrice());
    }

    private String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }
}