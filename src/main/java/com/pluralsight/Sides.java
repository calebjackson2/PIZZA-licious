package com.pluralsight;

import java.awt.*;

public abstract class Sides extends MenuItem {

    public Sides(String name, double price) {
        super(name);
    }

    @Override
    public String toString() {
        return getName() + " - $" + String.format("%.2f", getPrice());
    }
}

class GarlicKnots extends Sides {
    public GarlicKnots() {
        super("Garlic Knots", 4.00);
    }

    @Override
    public double calculatePrice() {
        return 0;
    }
}

class PotatoKnots extends Sides {
    public PotatoKnots() {
        super("Potato Knots", 4.50);
    }

    @Override
    public double calculatePrice() {
        return 0;
    }
}

class FreeSides extends Sides {
    public FreeSides(String name) {
        super(name, 0.00);   // free sides
    }

    @Override
    public double calculatePrice() {
        return 0;
    }
}