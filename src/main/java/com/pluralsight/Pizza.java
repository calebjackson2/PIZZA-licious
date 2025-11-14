package com.pluralsight;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Pizza extends MenuItem {
    private String size;
    private String crust;
    private boolean stuffedCrust;
    private Sauce sauce;
    private List<Topping> toppings;

    public Pizza(String size, String crust, boolean stuffedCrust, Sauce sauce) {
        super(size + " Pizza");
        this.size = size;
        this.crust = crust;
        this.stuffedCrust = stuffedCrust;
        this.sauce = sauce;
        this.toppings = new ArrayList<>();
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    @Override
    public double getPrice() {
        double basePrice = switch (size.toLowerCase()) {
            case "personal" -> 8.50;
            case "medium"   -> 12.00;
            case "large"    -> 16.50;
            default -> throw new IllegalStateException("Unexpected value: " + size.toLowerCase());
        };

        if (stuffedCrust) basePrice += 2.00;

        for (Topping topping : toppings) {
            basePrice += topping.getPrice();
        }

        return basePrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(size).append(" Pizza (")
                .append(crust).append(" crust");

        if (stuffedCrust) sb.append(", stuffed crust");

        sb.append(") with ").append(sauce.getName()).append(" sauce")
                .append("\nToppings: ");

        if (toppings.isEmpty()) {
            sb.append("none");
        } else {
            for (Topping topping : toppings) {
                sb.append(topping.getName())
                        .append(" ($")
                        .append(String.format("%.2f", topping.getPrice()))
                        .append("), ");
            }
            sb.setLength(sb.length() - 2); 
        }

        sb.append("\nTotal Price: $").append(String.format("%.2f", getPrice()));

        return sb.toString();
    }
}