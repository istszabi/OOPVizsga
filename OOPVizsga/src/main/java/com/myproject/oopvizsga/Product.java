/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.oopvizsga;

import java.util.ArrayList;

/**
 *
 * @author istsz
 */
public class Product extends BaseEntity implements Identifiable, Billable {

    private String type;              // PHYSICAL, DIGITAL, SERVICE
    private String sku;
    private String name;
    private int qty;
    private double price;

    private ArrayList<Discount> discounts; // optional
    private Dimensions dimensions;         // for PHYSICAL
    private Weight weight;                 // for PHYSICAL
    private License license;               // for DIGITAL
    private ServiceDetails service;        // for SERVICE

    private static int counter = 0;

    public Product(String type, String sku, String name, int qty, double price) {
        super("P-" + (++counter));
        this.type = type;
        this.sku = sku;
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.discounts = new ArrayList<>();
        this.dimensions = null;
        this.weight = null;
        this.license = null;
        this.service = null;
    }

    // Add a discount
    public void addDiscount(Discount discount) {
        discounts.add(discount);
    }

    public double getLineTotal() {
        double total = price * qty;
        for (Discount discount : discounts) {
            total -= discount.getAmount();
        }
        return Math.max(total, 0);
    }

    public boolean isPhysical() {
        return type.equalsIgnoreCase("PHYSICAL");
    }
    
    public String getName() {
        return name;
    }

    @Override
    public String businessKey() {
        return sku;
    }

    @Override
    public String toString() {
    String lineTotalStr = String.format("%.2f", getLineTotal());
    if (!isValid()) {
        return type + " " + name + " x" + qty + " $" + price 
               + " (LineTotal: " + lineTotalStr + ") [INVALID DATA]";
    }
    return type + " " + name + " x" + qty + " $" + price 
           + " (LineTotal: " + lineTotalStr + ")";
}

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getId() {
        return id;
    }
    public boolean isValid() {
    return sku != null && !sku.isEmpty()
        && name != null && !name.isEmpty()
        && qty > 0
        && price > 0.0;
}
}
