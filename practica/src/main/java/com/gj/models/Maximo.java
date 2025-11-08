package com.gj.models;

public class Maximo {
    public static int maximo(int a, int b, int c){
        int maximo = a;
        if (maximo < b){
            maximo = b;
        }
        if(maximo < c){
            maximo = c;
        }
        return maximo;
    }
}
