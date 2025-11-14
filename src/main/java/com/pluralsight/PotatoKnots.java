package com.pluralsight;

public class PotatoKnots extends Side {
    private boolean withCheese;

    public PotatoKnots(boolean withCheese) {
        super("Potato Knots" + (withCheese ? " (with cheese)" : ""), 5.00 + (withCheese ? 1.25 : 0.0));
        this.withCheese = withCheese;
    }
}