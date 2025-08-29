package com.gabrieljuarez.models;

public class Estudiante {
    String nombre;
    String matricula;
    double promedio;

    public Estudiante(String nombre, String matricula, double promedio) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.promedio = promedio;
    }

    public void imprimir_datos(){
        if(this.promedio >= 70){
            System.out.println("El estudiante: " + this.nombre + " " + "y de matricula " + this.matricula + " " + "aprobo con un promedio de " + this.promedio);
        }else{
            System.out.println("El estudiante: " + this.nombre + " " + "y de matricula " + this.matricula + " " + "reprobo con un promedio de " + this.promedio);
        }
    }
}
