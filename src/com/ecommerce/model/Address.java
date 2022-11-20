package com.ecommerce.model;

public class Address {
    private String address;
    private String city;
    private String country;
    private String pincode;

    public Address(String address, String city, String country, String pincode) {
        this.address = address;
        this.city = city;
        this.country = country;
        this.pincode = pincode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String  getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
