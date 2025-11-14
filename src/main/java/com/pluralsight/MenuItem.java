package com.pluralsight;

public abstract class MenuItem {
    protected String name;

    public MenuItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculatePrice();

    @Override
    public abstract String toString();

    public double getPrice() {
        return 0;
    }
}
