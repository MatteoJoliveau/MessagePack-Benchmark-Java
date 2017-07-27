package com.matteojoliveau.benchmark.msgpack;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
    private String street;
    private String city;
    private String zipCode;
    private int num;

    public Address() {}

    public Address(String street, String city, String zipCode, int num) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.num = num;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public int getNum() {
        return num;
    }


    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", num=" + num +
                '}';
    }
}
