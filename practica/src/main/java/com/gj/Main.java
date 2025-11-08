package com.gj;


import com.gj.models.ProgresionGeometrica;

import java.util.ArrayList;
import java.util.Arrays;

import static com.gj.models.Maximo.maximo;
import static com.gj.models.ProgresionGeometrica.progresion;

public class Main {
    public static void main(String[] args) {

        System.out.println(maximo(35,2,4));
        var secuencia = new ArrayList<>(Arrays.asList(5, 15, 45, 135, 405));
        System.out.println(progresion(secuencia));
        var arr = new int[]{2, 4, 8, 10, 20, 22};
        System.out.println(ProgresionGeometrica.alternar(arr));
    }
}
