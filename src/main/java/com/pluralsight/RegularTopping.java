package com.pluralsight;

public class RegularTopping extends Topping {
    public RegularTopping(String name) {
        super(name, 0.00);
    }

    @Override
    public double getPrice() { return 0.00; }
}

