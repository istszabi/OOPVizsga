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

    // Set optional fields
    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public void setService(ServiceDetails service) {
        this.service = service;
    }

    // Business key for equals
    @Override
    public String businessKey() {
        return sku;
    }

    // To string prints type-specific info
    @Override
    public String toString() {
        String result = type + " " + name + " x" + qty + " [" + sku + "] $" + price;
        if (!discounts.isEmpty()) {
            result += " Discounts: " + discounts;
        }
        if (dimensions != null) {
            result += " Dim: " + dimensions;
        }
        if (weight != null) {
            result += " Wt: " + weight;
        }
        if (license != null) {
            result += " License: " + license;
        }
        if (service != null) {
            result += " Service: " + service;
        }
        return result;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getId() {
        return id;
    }
}
