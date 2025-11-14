package com.pluralsight;

import java.awt.*;

public abstract class Side extends MenuItem {
    protected double price;

    public Side(String name, double price) {
        super(name);
        this.price = price;
    }

    @Override
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return getName() + " - $" + String.format("%.2f", getPrice());
    }
}
