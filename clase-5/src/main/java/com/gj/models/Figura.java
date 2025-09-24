package com.gj.models;

public abstract class Figura {
    String color;

    public Figura(String color) {
        this.color = color;
    }

    public abstract float calcularArea();

    public String mostrarColor() {
        return "El color es: " + this.color;

    }
}
