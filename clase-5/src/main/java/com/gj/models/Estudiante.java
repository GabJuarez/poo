package com.gj.models;

public class Estudiante extends Persona{
    private String course;

    public Estudiante(String name, int age, String course) {
        super(name, age);
        this.course = course;
    }

    @Override
    public String introduceYourself() {
        return super.introduceYourself() + " I am studying " + this.course + ".";
    }
}
