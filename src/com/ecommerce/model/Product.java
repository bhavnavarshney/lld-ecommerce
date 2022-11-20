package com.ecommerce.model;

import com.ecommerce.utils.Utils;
import com.sun.corba.se.impl.protocol.AddressingDispositionException;

import java.util.Set;

public class Product {
    private String id;
    private String name;
    private String type;
    private int quantity;
    private Address address;

    public Product(String name, String type, int quantity, Address address) {
        this.id = Utils.getUUID();
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
