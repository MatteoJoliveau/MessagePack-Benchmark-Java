package com.matteojoliveau.benchmark.msgpack;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
    private String name;
    private String surname;
    private int age;
    private Address address;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", places=" + places +
                '}';
    }

    private Map<String, String> places;

    public Person() {}

    public Person(String name, String surname, int age, Address address, Map<String, String> places) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
        this.places = places;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public Map<String, String> getPlaces() {
        return places;
    }
}
