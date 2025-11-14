package com.pluralsight;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public abstract class Pizza extends MenuItem {
    protected String size;
    protected String crust;
    protected boolean stuffedCrust;
    protected Sauce sauce;
    protected List<Topping> toppings;

    public Pizza(String size, String crust, boolean stuffedCrust, Sauce sauce) {
        super((size == null ? "Pizza" : size + " Pizza"));
        this.size = size == null ? "medium" : size;
        this.crust = crust == null ? "regular" : crust;
        this.stuffedCrust = stuffedCrust;
        this.sauce = sauce == null ? new Sauce("Tomato") : sauce;
        this.toppings = new ArrayList<>();
    }

    public void addTopping(Topping topping) {
        if (topping != null) toppings.add(topping);
    }

    @Override
    public double getPrice() {
        String s = (size == null) ? "" : size.toLowerCase(Locale.ROOT);
        double basePrice = switch (s) {
            case "personal" -> 8.50;
            case "medium" -> 12.00;
            case "large" -> 16.50;
            default -> 12.00;
        };

        if (stuffedCrust) basePrice += 2.00;

        for (Topping t : toppings) basePrice += t.getPrice();

        return Math.round(basePrice * 100.0) / 100.0;
    }

    public String toppingsSummary() {
        if (toppings.isEmpty()) return "none";
        StringBuilder sb = new StringBuilder();
        for (Topping t : toppings) {
            sb.append(t.toString()).append(", ");
        }
        sb.setLength(sb.length() - 2);
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.format("%s Pizza (%s crust%s) with %s sauce\nToppings: %s\nPrice: $%.2f",
                capitalize(size), crust, (stuffedCrust ? ", stuffed crust" : ""),
                sauce.getName(), toppingsSummary(), getPrice());
    }

    private String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }
}