/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.oopvizsga;

/**
 *
 * @author istsz
 */
public abstract class BaseEntity {
    protected String id;

    public BaseEntity(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    
    
    public abstract String businessKey();
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BaseEntity)) return false;
        return businessKey().equals(((BaseEntity)obj).businessKey());
    }
    
}
