package com.ecommerce.model;

import com.ecommerce.utils.Utils;

public class Buyer {
    private String id;
    private String name;
    private Address address;

    public Buyer(String name, Address address) {
        this.id = Utils.getUUID();
        this.name = name;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
