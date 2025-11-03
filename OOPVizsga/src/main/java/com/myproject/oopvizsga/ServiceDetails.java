/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.oopvizsga;

/**
 *
 * @author istsz
 */
public class ServiceDetails {
    private String provider;
    private int termsMonths;

    public ServiceDetails(String provider, int termsMonths) {
        this.provider = provider;
        this.termsMonths = termsMonths;
    }

    @Override
    public String toString() {
        return provider + " (" + termsMonths + " months)";
    }
}

