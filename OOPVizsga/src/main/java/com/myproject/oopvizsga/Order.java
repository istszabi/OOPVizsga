/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.oopvizsga;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

/**
 *
 * @author istsz
 */
public class Order extends BaseEntity {

    private String status;
    private String currency;
    private Customer customer;
    private ArrayList<Product> items;

    public Order(String status, String currency, Customer customer, ArrayList<Product> items, String id) {
        super(id);
        this.status = status;
        this.currency = currency;
        this.customer = customer;
        this.items = items;
    }

    public void addItem(Product orderedProduct) {
        items.add(orderedProduct);
    }

    public ArrayList<Product> getItems() {
        return items;
    }

    public double computeTotal() {
        double total = 0;

        for (Product product : items) {
            double lineTotal = product.getLineTotal();

            // GOLD customer extra 5% discount on physical goods
            if (product.isPhysical() && customer.getLoyaltyTier().equalsIgnoreCase("GOLD")) {
                lineTotal *= 0.95;
            }

            total += lineTotal;
        }

        // Add VAT if present (assume 21% default if none)
        double taxRate = 0.21;
        total += total * taxRate;

        return total;
    }
    public void sortItemsByLineTotal() {
    Collections.sort(items, new Comparator<Product>() {
        @Override
        public int compare(Product p1, Product p2) {
            if (p1.getLineTotal() < p2.getLineTotal()) return 1;
            else if (p1.getLineTotal() > p2.getLineTotal()) return -1;
            else return 0;
        }
    });
}

    public void printShippingEligibility() {
        for (Product product : items) {
            if (product.isPhysical()) {
                System.out.println(product.getName() + " is eligible for shipping.");
            } else {
                System.out.println(product.getName() + " does NOT require shipping.");
            }
        }
    }

    public String getStatus() {
        return status;
    }

    
    public Customer getCustomer() {
        return customer;
    }
    @Override
    public String businessKey() {
        return id;
    }

    @Override
    public String toString() {
        return "Order[" + id + ", " + status + ", " + currency + ", Customer=" + customer + ", Items=" + items + "]";
    }
}
