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
public class Customer extends BaseEntity implements Identifiable {

    private String firstName;
    private String lastName;
    private String email;
    private String loyaltyTier;
    private ArrayList<Address> addresses;

     public Customer(String id, String firstName, String lastName, String email, String loyaltyTier) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.loyaltyTier = loyaltyTier;
        this.addresses = new ArrayList<Address>();
    }
     public void addAddress(Address customerAddress) {
        addresses.add(customerAddress);
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    @Override
    public String businessKey() {
        return id;
    }

    @Override
    public String toString() {
        return "Customer[" + id + ", " + firstName + " " + lastName + ", " + email + ", " + loyaltyTier + "]";
    }
}
