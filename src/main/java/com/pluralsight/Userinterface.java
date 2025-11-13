package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);

    public void display() {
        System.out.println("🍕 Welcome to the Pizza Ordering System!");

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        Customer customer = new Customer(name, email);
        Order order = new Order(customer);

        while (true) {
            System.out.println("\n1. Add Pizza\n2. Add Garlic Knots\n3. Add Drink\n4. Complete Order");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> order.addPizza(createPizza());
                case 2 -> order.addSide(new GarlicKnots());
                case 3 -> {
                    System.out.print("Enter drink name: ");
                    order.addDrink(new Drinks(scanner.nextLine()));
                }
                case 4 -> {
                    order.printReceipt();
                    FileManager.saveReceipt(order);
                    return;
                }
                default -> System.out.println("Invalid choice, try again!");
            }
        }
    }

    private Pizza createPizza() {
        System.out.print("Enter pizza size (Personal, Medium, Large): ");
        String size = scanner.nextLine();
        System.out.print("Enter crust type (Thin, Regular, Thick, Cauliflower): ");
        String crust = scanner.nextLine();
        System.out.print("Stuffed crust? (yes/no): ");
        boolean stuffed = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Choose sauce (Tomato, Alfredo, BBQ): ");
        Sauce sauce = new Sauce(scanner.nextLine());

        Pizza pizza = new Pizza(size, crust, stuffed, sauce);

        while (true) {
            System.out.print("Add topping? (yes/no): ");
            if (!scanner.nextLine().equalsIgnoreCase("yes")) break;

            System.out.print("Enter topping name: ");
            String toppingName = scanner.nextLine();
            System.out.print("Is it premium? (meat/cheese/regular): ");
            String type = scanner.nextLine();

            switch (type.toLowerCase()) {
                case "meat" -> pizza.addTopping(new MeatTopping(toppingName));
                case "cheese" -> pizza.addTopping(new CheeseTopping(toppingName));
                default -> pizza.addTopping(new RegularTopping(toppingName));
            }
        }
        return pizza;
    }
    public static void main(String[] args) {
        new UserInterface().display();
    }
}