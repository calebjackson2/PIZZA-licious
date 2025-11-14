package com.pluralsight;

import java.awt.*;
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

            writer.write("Customer: " + order.getCustomer().getName() + "\n\n");
            writer.write("----- ITEMS -----\n");

            for (MenuItem item : order.getItems()) {
                writer.write(item.getName() + " - $" +
                        String.format("%.2f", item.getPrice()) + "\n");
            }

            writer.write("\n----- TOTAL -----\n");
            writer.write("Total: $" + String.format("%.2f", order.calculateTotal()) + "\n");

            writer.close();
            System.out.println("Receipt saved as " + filename);

        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}