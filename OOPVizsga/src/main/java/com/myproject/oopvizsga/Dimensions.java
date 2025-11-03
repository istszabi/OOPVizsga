/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.oopvizsga;

/**
 *
 * @author istsz
 */
public class Dimensions {
    private double w, h, d;
    private String unit;

    public Dimensions(double w, double h, double d, String unit) {
        this.w = w;
        this.h = h;
        this.d = d;
        this.unit = unit;
    }

    @Override
    public String toString() {
        return w + "x" + h + "x" + d + " " + unit;
    }
}
