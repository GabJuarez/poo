package org.example.models;

public class Persona {
    private int edad;

    public Persona(int edad) {
        setEdad(edad);
    }

    public void setEdad(int edad) {
        if(edad > 1 || edad < 120){
            this.edad = edad;
        }else{
            System.out.println("Edad invalida");
        }

    }

    public int getEdad() {
        return edad;
    }

    public void verificar_edad(int edad){
        if (edad < 18){
            System.out.println("Sos menor de edad");
        }else{
            System.out.println("Sos mayor de edad");
        }
    }
}
