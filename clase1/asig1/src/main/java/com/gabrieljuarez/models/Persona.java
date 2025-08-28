package com.gabrieljuarez.models;

public class Persona {
    String nombre;
    int edad;

   public Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
  }

  public void mostrar_datos(){
      System.out.println("Nombre: " + this.nombre + " " + "Edad: " + this.edad);
  }

}
