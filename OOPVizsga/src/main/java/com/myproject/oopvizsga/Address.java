/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.oopvizsga;

/**
 *
 * @author istsz
 */
public class Address {
    private String type;
    private String line1;
    private String city;
    private String country;
    private String zip;

    public Address(String type, String line1, String city, String country, String zip) {
        this.type = type;
        this.line1 = line1;
        this.city = city;
        this.country = country;
        this.zip = zip;
    }
    
    @Override
    public String toString() {
        return type + ": " + line1 + ", " + city + ", " + country + " " + zip;
    }
}
