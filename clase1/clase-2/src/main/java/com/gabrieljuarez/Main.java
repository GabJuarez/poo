package com.gabrieljuarez;

import com.gabrieljuarez.models.Carrera;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera();

        carrera.setNombre("Ingenieria en sistemas");
        carrera.setCodigo("Isdi/1");
        carrera.setPrecio(250.00);

        System.out.println(carrera);
        JOptionPane.showMessageDialog(null, carrera);
    }
}
