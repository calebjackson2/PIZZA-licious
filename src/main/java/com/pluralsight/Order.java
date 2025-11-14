package com.pluralsight;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private Customer customer;
    private List<MenuItem> items;

    public Order(Customer customer) {
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        if (item != null) items.add(item);
    }

    public double calculateTotal() {
        return Math.round(items.stream().mapToDouble(MenuItem::getPrice).sum() * 100.0) / 100.0;
    }

    public List<MenuItem> getItemsNewestFirst() {
        List<MenuItem> copy = new ArrayList<>(items);
        Collections.reverse(copy);
        return copy;
    }

    public List<MenuItem> getItems() { return items; }
    public Customer getCustomer() { return customer; }

    public void printReceiptToConsole() {
        System.out.println("\n----- ORDER SUMMARY -----");
        System.out.println("Customer: " + customer.getName() + " | " + customer.getEmail());
        System.out.println("-------------------------");
        for (MenuItem item : items) {
            System.out.println(" - " + item);
        }
        System.out.println("-------------------------");
        System.out.println("TOTAL: $" + String.format("%.2f", calculateTotal()));
        System.out.println("-------------------------");
    }
}