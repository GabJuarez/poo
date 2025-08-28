package com.gabrieljuarez.models;

public class Carro {
    String marca;
    String modelo;
    int anio;

    public Carro(String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    public void mostrar_info(){
        System.out.println("Marca: " + this.marca + ", Modelo: " + this.modelo + ", Anio: " + this.anio);
    }
}
