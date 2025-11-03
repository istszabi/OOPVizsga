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

    @Override
    public String businessKey() {
        return id;
    }

    @Override
    public String toString() {
        return "Order[" + id + ", " + status + ", " + currency + ", Customer=" + customer + ", Items=" + items + "]";
    }
}
