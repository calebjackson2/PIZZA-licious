package com.pluralsight;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Customer customer;
    private List<MenuItem> items;

    public Order(Customer customer) {
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public double calculateTotal() {
        return items.stream()
                .mapToDouble(MenuItem::getPrice)
                .sum();
    }

    public void printReceipt() {
        System.out.println("\n----- ORDER SUMMARY -----");
        System.out.println("Customer: " + customer.getName());
        System.out.println("-------------------------");

        for (MenuItem item : items) {
            System.out.println(" - " + item);
        }

        System.out.println("\nTOTAL: $" + String.format("%.2f", calculateTotal()));
        System.out.println("-------------------------");
    }

    public Customer getCustomer() { return customer; }
    public List<MenuItem> getItems() { return items; }

    public void addPizza(Pizza pizza) {
    }

    public void addSide(GarlicKnots garlicKnots) {
    }

    public void addDrink(Drink drink) {
    }
}