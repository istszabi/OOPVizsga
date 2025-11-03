/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.oopvizsga;

/**
 *
 * @author istsz
 */
public class Weight {
    private double value;
    private String unit;

    public Weight(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
    
}
