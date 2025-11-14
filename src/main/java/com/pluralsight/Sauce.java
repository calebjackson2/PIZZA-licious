package com.pluralsight;

public class Sauce {
    private String name;

    public Sauce(String name) {
        this.name = (name == null || name.isBlank()) ? "Tomato" : name;
    }

    public String getName() { return name; }
    public double getPrice() { return 0.0; } // sauce included
}
