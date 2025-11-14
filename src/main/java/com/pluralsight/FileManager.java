package com.pluralsight;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileManager {
    public static void saveReceipt(Order order) {
        try {
            Path folder = Path.of("receipts");
            Files.createDirectories(folder);

            String filename = "receipts/receipt_" +
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) +
                    ".txt";

            try (FileWriter writer = new FileWriter(filename)) {
                writer.write("===== ORDER RECEIPT =====\n");
                writer.write("Customer: " + order.getCustomer().getName() + "\n");
                writer.write("Email: " + order.getCustomer().getEmail() + "\n");
                writer.write("-------------------------\n\n");

                for (MenuItem item : order.getItems()) {
                    writer.write(item.toString() + "\n");
                }

                writer.write("\n-------------------------\n");
                writer.write("TOTAL: $" + String.format("%.2f", order.calculateTotal()) + "\n");
                writer.write("=========================\n");
            }

            System.out.println("Receipt saved as: " + filename);
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}