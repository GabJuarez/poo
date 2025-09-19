package com.gj;

import com.gj.models.Animal;
import com.gj.models.Ave;
import com.gj.models.Estudiante;
import com.gj.models.Perro;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante("Silvio", 200, "Ingenieria en sistemas");
        System.out.println(estudiante.introduceYourself());

        Animal animal = new Animal("Sam", 4);
        System.out.println(animal);

        Perro perro = new Perro("Mugi", 4);
        System.out.println(perro);
        System.out.println(perro.hacerSonido());

        Ave ave = new Ave("Lora", 3, true);
        System.out.println(ave);
        System.out.println(ave.hacerSonido());
    }
}
