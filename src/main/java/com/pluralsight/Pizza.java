package com.pluralsight;

import java.util.ArrayList;

public class Pizza {
    private String size;
    private String crust;
    private boolean stuffedCrust;
    private List<Topping> toppings;

    public Pizza(String size, String crust, boolean stuffedCrust) {
        this.size = size;
        this.crust = crust;
        this.stuffedCrust = stuffedCrust;
        this.toppings = new ArrayList<>();
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public double calculateCost() {
        double basePrice = switch (size.toLowerCase()) {
            case "personal" -> 8.50;
            case "medium" -> 12.00;
            case "large" -> 16.50;
            default -> 10.00;
        };
        if (stuffedCrust) basePrice += 2.00;
        for (Topping topping : toppings) basePrice += topping.getPrice();
        return basePrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(size).append(" Pizza (").append(crust).append(" crust");
        if (stuffedCrust) sb.append(", stuffed crust");
        sb.append(")\nToppings: ");
        for (Topping topping : toppings) {
            sb.append(topping.getName()).append(", ");
        }
        return sb.toString();
    }
}