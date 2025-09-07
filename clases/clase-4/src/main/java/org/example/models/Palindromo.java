package org.example.models;
import java.util.Scanner;


public class Palindromo {
    private String frase;

    public Palindromo(String frase) {
        this.frase = frase;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        Scanner sc = new Scanner(System.in);
        this.frase = sc.nextLine().toLowerCase();
    }

    public int verificar_palindromos(String frase) {
        int palindromos = 0;
        String palabras[] = frase.split(" ");
        for(String palabra:palabras){
            StringBuilder stringBuilder = new StringBuilder(palabra);
            String invertida = String.valueOf(stringBuilder.reverse());
            if(palabra.equals(invertida)){
                palindromos++;
            }
        }
        return palindromos;
    }
}
