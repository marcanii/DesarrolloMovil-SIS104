package com.example.holamundojava.backend;

public class OperacionesBasicas {

    public OperacionesBasicas(){

    }
    public int suma(int a, int b){
        return a + b;
    }
    public int resta(int a, int b){
        return a - b;
    }
    public int multiplicacion(int a, int b){
        return a * b;
    }
    public String division(int a, int b){
        if(b == 0)
            return "No se puede dividir por cero";
        else
            return String.valueOf((double)a / b);
    }
}
