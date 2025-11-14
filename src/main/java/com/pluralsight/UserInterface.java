package com.pluralsight;

import java.util.Locale;
import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner = new Scanner(System.in);

    public void displayHome() {
        boolean running = true;
        while (running) {
            System.out.println("\n==== HOME ====");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Select: ");
            String input = scanner.nextLine().trim();
            switch (input) {
                case "1" -> startNewOrder();
                case "0" -> {
                    System.out.println("Exiting. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void startNewOrder() {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter customer email: ");
        String email = scanner.nextLine().trim();
        Customer customer = new Customer(name, email);
        Order order = new Order(customer);

        boolean ordering = true;
        while (ordering) {
            showOrderScreen(order);
            System.out.print("Select: ");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> order.addItem(addPizza());
                case "2" -> order.addItem(addDrink());
                case "3" -> {
                    order.addItem(addGarlicKnots());
                    System.out.println("Garlic Knots added.");
                }
                case "4" -> {
                    order.addItem(addPotatoKnots());
                    System.out.println("Potato Knots added.");
                }
                case "5" -> {
                    order.addItem(addSeasonedKnots());
                    System.out.println("Seasoned Knots added.");
                }
                case "6" -> {
                    boolean confirmed = checkout(order);
                    if (confirmed) {
                        ordering = false;
                    }
                }
                case "0" -> {
                    System.out.println("Order canceled and returning to home.");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void showOrderScreen(Order order) {
        System.out.println("\n==== ORDER SCREEN ====");
        System.out.println("Current items (newest first):");
        var items = order.getItemsNewestFirst();
        if (items.isEmpty()) System.out.println("  (no items)");
        else {
            int i = 1;
            for (MenuItem mi : items) {
                System.out.println(i++ + ") " + mi.toString());
            }
        }
        System.out.println("\n1) Add Pizza");
        System.out.println("2) Add Drink");
        System.out.println("3) Add Garlic Knots");
        System.out.println("4) Add Potato Knots");
        System.out.println("5) Add Seasoned Knots");
        System.out.println("6) Checkout");
        System.out.println("0) Cancel Order");
    }

    private MenuItem addPizza() {
        System.out.println("\n--- ADD PIZZA ---");
        System.out.print("Pizza size (Personal, Medium, Large): ");
        String size = scanner.nextLine().trim();
        System.out.print("Crust (Thin, Regular, Thick, Cauliflower): ");
        String crust = scanner.nextLine().trim();
        System.out.print("Stuffed crust? (yes/no): ");
        boolean stuffed = scanner.nextLine().trim().toLowerCase(Locale.ROOT).startsWith("y");

        System.out.print("Choose sauce (Tomato, Alfredo, BBQ). Press Enter for Tomato: ");
        String sauceName = scanner.nextLine().trim();
        if (sauceName.isEmpty()) sauceName = "Tomato";
        Sauce sauce = new Sauce(sauceName);

        SimplePizza pizza = new SimplePizza(size, crust, stuffed, sauce);

        boolean adding = true;
        while (adding) {
            System.out.println("\nAdd topping? (yes/no)");
            if (!scanner.nextLine().trim().equalsIgnoreCase("yes")) break;

            System.out.println("Select topping type:");
            System.out.println("1) Meat");
            System.out.println("2) Cheese");
            System.out.println("3) Other (regular)");
            System.out.print("Choice: ");
            String tchoice = scanner.nextLine().trim();

            switch (tchoice) {
                case "1" -> {
                    System.out.print("Enter meat name (e.g., Pepperoni): ");
                    String meatName = scanner.nextLine().trim();
                    System.out.print("Size for meat (regular/large/xl): ");
                    String msize = scanner.nextLine().trim();
                    pizza.addTopping(new MeatTopping(meatName, msize));
                    System.out.println("Added meat: " + meatName + " (" + msize + ")");
                }
                case "2" -> {
                    System.out.print("Enter cheese name (e.g., Extra Cheese): ");
                    String cheeseName = scanner.nextLine().trim();
                    System.out.print("Size for cheese (regular/large/xl): ");
                    String csize = scanner.nextLine().trim();
                    pizza.addTopping(new CheeseTopping(cheeseName, csize));
                    System.out.println("Added cheese: " + cheeseName + " (" + csize + ")");
                }
                case "3" -> {
                    System.out.print("Enter topping name (e.g., Olives): ");
                    String other = scanner.nextLine().trim();
                    pizza.addTopping(new RegularTopping(other));
                    System.out.println("Added topping: " + other);
                }
                default -> System.out.println("Invalid topping type.");
            }
        }

        System.out.println("Pizza added:\n" + pizza);
        return pizza;
    }

    private MenuItem addDrink() {
        System.out.println("\n--- ADD DRINK ---");
        System.out.print("Enter drink name (e.g., Coke): ");
        String name = scanner.nextLine().trim();
        System.out.print("Size (small/medium/large): ");
        String size = scanner.nextLine().trim();
        Drink drink = new Drink(name, size);
        System.out.println("Added " + drink);
        return drink;
    }

    private MenuItem addGarlicKnots() {
        System.out.println("\n--- ADD GARLIC KNOTS ---");
        return new GarlicKnots();
    }

    private MenuItem addPotatoKnots() {
        System.out.println("\n--- ADD POTATO KNOTS ---");
        System.out.print("Would you like cheese on them? (yes/no): ");
        boolean withCheese = scanner.nextLine().trim().equalsIgnoreCase("yes");
        return new PotatoKnots(withCheese);
    }

    private MenuItem addSeasonedKnots() {
        System.out.println("\n--- ADD SEASONED KNOTS ---");
        return new SeasonedKnots();
    }

    private boolean checkout(Order order) {
        System.out.println("\n--- CHECKOUT ---");
        order.printReceiptToConsole();
        System.out.println("1) Confirm (create receipt and return to home)");
        System.out.println("0) Cancel (delete order and return to home)");
        System.out.print("Choice: ");
        String choice = scanner.nextLine().trim();
        if ("1".equals(choice)) {
            FileManager.saveReceipt(order);
            System.out.println("Order completed. Returning to home.");
            return true;
        } else {
            System.out.println("Checkout canceled. Order discarded.");
            return false;
        }
    }
}