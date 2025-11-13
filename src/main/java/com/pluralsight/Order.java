package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Order {
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
        System.out.println("\n----- ORDER SUMMARY -----");
        System.out.println("Customer: " + customer.getName());
        for (Pizza pizza : pizzas) System.out.println(pizza);
        for (Sides side : sides) System.out.println(side.getName() + " - $" + side.getPrice());
        for (Drinks drink : drinks) System.out.println(drink.getName() + " - $" + drink.getPrice());
        System.out.println("Total: $" + calculateTotal());
    }

    public Customer getCustomer() { return customer; }
    public List<Pizza> getPizzas() { return pizzas; }
    public List<Sides> getSides() { return sides; }
    public List<Drinks> getDrinks() { return drinks; }
}

class Customer {
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
}
