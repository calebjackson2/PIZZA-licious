package com.pluralsight;

public abstract class MenuItem {
    protected String name;

    public MenuItem(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public abstract double getPrice();

    @Override
    public String toString() {
        return name + " - $" + String.format("%.2f", getPrice());
    }
}
