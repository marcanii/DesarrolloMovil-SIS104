package com.example.holamundokotlin.backend


class OperacionesBasicas {
    fun suma(a: Int, b: Int): Int {
        return a + b
    }

    fun resta(a: Int, b: Int): Int {
        return a - b
    }

    fun multiplicacion(a: Int, b: Int): Int {
        return a * b
    }

    fun division(a: Int, b: Int): String {
        return if (b == 0) "No se puede dividir por cero" else (a.toDouble() / b).toString()
    }
}