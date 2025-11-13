package com.pluralsight;

import javax.print.attribute.standard.Sides;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Customer {
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
}

class Order {
    private Customer customer;
    private List<Pizza> pizzas;
    private List<Sides> sides;
    private List<Drinks> drinks;

    public Order(Customer customer) {
        this.customer = customer;
        this.pizzas = new ArrayList<>();
        this.sides = new ArrayList<>();
        this.drinks = new ArrayList<>();
    }

    public void addPizza(Pizza pizza) { pizzas.add(pizza); }
    public void addSide(Sides side) { sides.add(side); }
    public void addDrink(Drinks drink) { drinks.add(drink); }

    public double calculateTotal() {
        double total = 0;
        for (Pizza p : pizzas) total += p.calculateCost();
        for (Sides s : sides) total += s.getPrice();
        for (Drinks d : drinks) total += d.getPrice();
        return total;
    }

    public void printReceipt() {
        System.out.println("\n----- Order Summary -----");
        System.out.println("Customer: " + customer.getName());
        for (Pizza pizza : pizzas) {
            System.out.println(pizza);
        }
        for (Sides side : sides) {
            System.out.println(side.getName() + " - $" + side.getPrice());
        }
        for (Drinks drink : drinks) {
            System.out.println(drink.getName() + " - $" + drink.getPrice());
        }
        System.out.println("Total: $" + calculateTotal());
    }

    public void saveReceipt() {
        try {
            String filename = "receipt_" + LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) + ".txt";
            FileWriter writer = new FileWriter(filename);
            writer.write("Customer: " + customer.getName() + "\n");
            for (Pizza p : pizzas) writer.write(p + "\n");
            for (Sides s : sides) writer.write(s.getName() + " - $" + s.getPrice() + "\n");
            for (Drinks d : drinks) writer.write(d.getName() + " - $" + d.getPrice() + "\n");
            writer.write("Total: $" + calculateTotal() + "\n");
            writer.close();
            System.out.println("Receipt saved as " + filename);
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}

}
