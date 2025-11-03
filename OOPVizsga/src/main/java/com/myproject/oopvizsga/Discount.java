/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.oopvizsga;

/**
 *
 * @author istsz
 */
public class Discount {
    private String code;
    private double amount;

    public Discount(String code, double amount) {
        this.code = code;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return code + "(-" + amount + ")";
    }

    public double getAmount() {
        return amount;
    }
    
    
    
}
