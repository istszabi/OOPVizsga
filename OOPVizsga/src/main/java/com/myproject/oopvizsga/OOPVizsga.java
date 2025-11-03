/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.myproject.oopvizsga;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import org.json.JSONObject;
import org.json.JSONArray;
import com.myproject.oopvizsga.ReportWriter;

/**
 *
 * @author istsz
 */
public class OOPVizsga {

    public static void main(String[] args) {
        try {
            // Read JSON
            FileReader reader = new FileReader("data.json");
            String jsonText = "";
            int ch;
            while ((ch = reader.read()) != -1) {
                jsonText += (char) ch;
            }
            reader.close();

            // Parse JSON
            JSONObject jsonObject = new JSONObject(jsonText);
            JSONArray ordersArray = jsonObject.getJSONArray("orders");

            ArrayList<Order> orders = new ArrayList<>();

            for (int i = 0; i < ordersArray.length(); i++) {
                JSONObject orderJson = ordersArray.getJSONObject(i);

                // Customer
                JSONObject customerJson = orderJson.getJSONObject("customer");
                JSONObject nameJson = customerJson.getJSONObject("name");
                Customer customer = new Customer(
                        customerJson.optString("customerId", "unknown"),
                        nameJson.optString("first", ""),
                        nameJson.optString("last", ""),
                        customerJson.optString("email", ""),
                        customerJson.optString("loyaltyTier", "")
                );

                JSONArray addressesArray = customerJson.getJSONArray("addresses");
                for (int j = 0; j < addressesArray.length(); j++) {
                    JSONObject addressJson = addressesArray.getJSONObject(j);
                    customer.addAddress(new Address(
                            addressJson.optString("type", ""),
                            addressJson.optString("line1", ""),
                            addressJson.optString("city", ""),
                            addressJson.optString("country", ""),
                            addressJson.optString("zip", "")
                    ));
                }

                // Items
                JSONArray itemsArray = orderJson.getJSONArray("items");
                ArrayList<Product> products = new ArrayList<>();
                for (int j = 0; j < itemsArray.length(); j++) {
                    JSONObject itemJson = itemsArray.getJSONObject(j);
                    Product product = new Product(
                            itemJson.optString("type", ""),
                            itemJson.optString("sku", ""),
                            itemJson.optString("name", ""),
                            itemJson.optInt("qty", 0),
                            itemJson.optDouble("price", 0.0)
                    );
                    products.add(product);
                }

                // Order
                Order order = new Order(
                        orderJson.optString("status", ""),
                        orderJson.optString("currency", ""),
                        customer,
                        products,
                        orderJson.optString("orderId", "unknown")
                );
                orders.add(order);
            }

            // Print 
            for (Order order : orders) {
    System.out.println("\nOrder: " + order.getId() + " | Customer: " + order.getCustomer().getFirstName());
    
    // Sort items by line total
    order.sortItemsByLineTotal();
    
    // Print items
    for (Product p : order.getItems()) {
        System.out.println(p);
    }
    
    // Print shipping eligibility
    order.printShippingEligibility();
    
    // Print total
    System.out.println(String.format(
    "Order Total (with taxes & discounts): $%.2f", 
    order.computeTotal()
));
}
            
ReportWriter.writeReport(orders, "report.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
