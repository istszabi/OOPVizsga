/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.oopvizsga;

/**
 *
 * @author istsz
 */
public class Product extends BaseEntity implements Identifiable, Billable {

    private String name;
    private double price;
    private static int counter = 0;

    public Product(String id, String name, double price) {
        super(id);
        this.name = name;
        this.price = price;
        counter++;

    }

    public Product(String id, String name) {
        this(id, name, 0.0);
    }

    @Override
    public String businessKey() {
        return id;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return "Product[" + id + ", " + name + ", " + price + "]";
    }

}
