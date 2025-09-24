package com.gj.models;

public class Cuadrado extends Figura {
    float lado;

    public Cuadrado(String color, float lado) {
        super(color);
        this.lado = lado;
    }

    @Override
    public float calcularArea() {
        return lado * lado;
    }
}
