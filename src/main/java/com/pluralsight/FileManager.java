package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileManager {
    public static void saveReceipt(Order order) {
        try {
            String filename = "receipt_" + LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) + ".txt";
            FileWriter writer = new FileWriter(filename);
            writer.write("Customer: " + order.getCustomer().getName() + "\n");
            for (Pizza p : order.getPizzas()) writer.write(p + "\n");
            for (Sides s : order.getSides()) writer.write(s.getName() + " - $" + s.getPrice() + "\n");
            for (Drinks d : order.getDrinks()) writer.write(d.getName() + " - $" + d.getPrice() + "\n");
            writer.write("Total: $" + order.calculateTotal() + "\n");
            writer.close();
            System.out.println("Receipt saved as " + filename);
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}