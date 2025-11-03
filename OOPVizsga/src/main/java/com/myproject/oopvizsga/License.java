/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.oopvizsga;

/**
 *
 * @author istsz
 */
public class License {
    private String key;
    private String expiresAt;

    public License(String key, String expiresAt) {
        this.key = key;
        this.expiresAt = expiresAt;
    }

    @Override
    public String toString() {
        return key + " (expires: " + expiresAt + ")";
    }
}

