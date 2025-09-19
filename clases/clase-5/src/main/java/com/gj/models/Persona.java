package com.gj.models;

public class Persona {
    private String name;
    private int age;

    public Persona(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String introduceYourself() {
        return "Hello, my name is " + this.name + " and I am " + this.age + " years old.";
    }
}
