package com.gj.models;
import javax.naming.directory.InvalidAttributeValueException;
import java.util.ArrayList;

public class EstadisticaTexto {
    private static String palabras[];

    public static String[] getPalabras() {
        return palabras;
    }

    public static void setPalabras(String palabras[]) throws InvalidAttributeValueException {
        if (palabras == null) {
            throw new InvalidAttributeValueException();
        }

        for (String palabra : palabras) {
            for (char caracter : palabra.toCharArray()) {
                if (!Character.isAlphabetic(caracter)) {
                    throw new InvalidAttributeValueException();
                }
            }
        }

        EstadisticaTexto.palabras = palabras;
    }

    public static int contar_palabras(String palabras[]) {
        return palabras.length;
    }

    public static ArrayList<String> palabras_unicas(String palabras[]) {
        ArrayList<String> palabrasUnicas = new ArrayList<>();
        ArrayList<String> palabrasRepetidas = new ArrayList<>();

        for (int i = 0; i < palabras.length - 1; i++) {
            for (int j = i + 1; j < palabras.length; j++) {
                if (palabras[i].equals(palabras[j])) {
                    palabrasRepetidas.add(palabras[i]);
                }
            }
        }

        for (String palabra : palabras) {
            if (!palabrasRepetidas.contains(palabra)) {
                palabrasUnicas.add(palabra);
            }
        }

        return palabrasUnicas;
    }

    public static String palabra_mas_corta(String palabras[]) {
        String palabraCorta = palabras[0];
        for (String palabra : palabras) {
            if (palabra.length() < palabraCorta.length()) {
                palabraCorta = palabra;
            }
        }
        return palabraCorta;
    }

    public static String palabra_mas_larga(String palabras[]) {
        String palabraLarga = palabras[0];
        for (String palabra : palabras) {
            if (palabra.length() > palabraLarga.length()) {
                palabraLarga = palabra;
            }
        }
        return palabraLarga;
    }
}
