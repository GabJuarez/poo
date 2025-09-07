package org.example;
import org.example.models.*;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona(23);
        persona1.verificar_edad(persona1.getEdad());

        Persona persona2 = new Persona(17);
        persona2.verificar_edad(persona2.getEdad());

        Venta venta = new Venta(12.65F, 6);
        System.out.println(venta.calcular_total());

        Palindromo palindromo = new Palindromo("ala silvio anilina seres gabriel");
        System.out.println(palindromo.verificar_palindromos(palindromo.getFrase()));

    }
}