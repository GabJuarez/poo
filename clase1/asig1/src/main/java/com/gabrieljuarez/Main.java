package com.gabrieljuarez;
import com.gabrieljuarez.models.*;

public class Main {

  public static void main(String[] args) {
      Persona persona = new Persona("Gabriel", 18);
      persona.mostrar_datos();
      System.out.println();

      Carro carro = new Carro("Ford", "mustang", 1964);
      carro.mostrar_info();
      System.out.println();

      Libro libro = new Libro("El arte de la guerra", "Sun Tzu", 93938);
      libro.descripcion();
      System.out.println();

      Cuenta_bancaria cuenta = new Cuenta_bancaria("Silvio Mejia", 76.87);
      cuenta.depositar(78);
      cuenta.retirar(16);
      cuenta.mostrar_datos_cuenta();
      System.out.println();

      Estudiante estudiante = new Estudiante("Andres", "esp-937", 87.9 );
      estudiante.imprimir_datos();

    }  

 }
