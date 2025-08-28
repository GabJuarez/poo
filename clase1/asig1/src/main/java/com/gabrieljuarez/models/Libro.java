package com.gabrieljuarez.models;

public class Libro {
    String titulo;
    String autor;
    int num_paginas;

    public Libro(String titulo, String autor, int num_paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.num_paginas = num_paginas;
    }

    public void descripcion(){
        System.out.println("El nombre del libro es: " + this.titulo);
        System.out.println("El libro fue escrito por: " + this.autor);
        System.out.println("El numero de paginas del libro es de: " + this.num_paginas);
    }
}
