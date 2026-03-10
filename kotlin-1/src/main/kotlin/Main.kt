package com.gj

fun main() {
    var name = "Kotlin"
    name = "World"
    println("Hello, " + name + "!")

   /* for (i in 1..5) {
        println("i = $i")
    }*/
    val saludo = EjemploFun().saludar()
    val producto = Producto().calcularProducto(5, 10)
    println(producto)

}