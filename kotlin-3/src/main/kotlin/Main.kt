package com.gj

fun main(){

    fun calcular(a: Int, b: Int, op: String) : Int {
        var result: Int = 0;
        when(op) {
            "+" -> result = a + b
            "-" -> result = a - b
            "*" -> result = a * b
            "/" -> result = a / b
            else -> result = 0
        }
        return result
    }
}
