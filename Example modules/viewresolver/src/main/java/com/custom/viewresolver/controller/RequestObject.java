package com.custom.viewresolver.controller;

public class RequestObject {

    private String name;

    private String address;

    private int age;

    // Constructors, getters, and setters
    // Constructors
    public RequestObject() {

    }

    public RequestObject(String name, String address, int age) {

        this.name    = name;
        this.address = address;
        this.age     = age;
    }

    // Getters and Setters
    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {

        this.age = age;
    }

    @Override
    public String toString() {

        return "RequestObject{" + "name='" + name + '\'' + ", address='" + address + '\'' + ", age=" + age + '}';
    }
}