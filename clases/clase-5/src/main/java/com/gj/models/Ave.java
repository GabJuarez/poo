package com.gj.models;

public class Ave extends Animal {
    private boolean puedeVolar;

    public Ave(String nombre, int edad, boolean puedeVolar) {
        super(nombre, edad);
        this.puedeVolar = puedeVolar;
    }

    @Override
    public String hacerSonido() {
        return "ruuuui";
    }
}
