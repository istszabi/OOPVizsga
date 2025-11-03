/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.oopvizsga;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author istsz
 */
public class ReportWriter {
    public static void writeReport(ArrayList<Order> orders, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {

            for (Order order : orders) {
                writer.write("Order ID: " + order.getId() + "\n");
                writer.write("Customer: " + order.getCustomer() + "\n");
                writer.write("Status: " + order.getStatus() + "\n");
                writer.write("Items:\n");
                for (Product product : order.getItems()) {
                    writer.write("  - " + product + " | Line Total: $" 
                                 + String.format("%.2f", product.getLineTotal()) + "\n");
                }
                writer.write(String.format(
                    "Order Total (with taxes & discounts): $%.2f\n", 
                    order.computeTotal()
                ));
                writer.write("-------------------------------------------------\n");
            }

            System.out.println("\n\n\nReport successfully written to " + filename);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
