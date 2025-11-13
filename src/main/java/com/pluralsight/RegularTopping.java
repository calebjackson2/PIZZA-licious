package com.pluralsight;

public class RegularTopping extends Topping {
    public RegularTopping(String name) {
        super(name, 0.00);  // Regular toppings free
    }
}
 class MeatTopping extends Topping {
    private String size;

    public MeatTopping(String name, String size) {
        super(name, 0.00);  // Base price unused
        this.size = size.toLowerCase();
    }
    @Override
    public double getPrice() {
        return switch (size) {
            case "regular" -> 0.50;
            case "large" -> 1.00;
            case "xl", "extra large" -> 1.50;
            default -> 0.00;
        };
    }
    @Override
    public String toString() {
        return name + " (" + size + ") - $" + String.format("%.2f", getPrice());
    }
}
class CheeseTopping extends Topping {
    private String size;

    public CheeseTopping(String name, String size) {
        super(name, 0.00);  // Base price unused
        this.size = size.toLowerCase();
    }
    @Override
    public double getPrice() {
        return switch (size) {
            case "regular" -> 0.30;
            case "large" -> 0.60;
            case "xl", "extra large" -> 0.90;
            default -> 0.00;
        };
    }
    @Override
    public String toString() {
        return name + " (" + size + ") - $" + String.format("%.2f", getPrice());
    }
}