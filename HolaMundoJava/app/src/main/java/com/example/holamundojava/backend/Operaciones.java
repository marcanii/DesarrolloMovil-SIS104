package com.example.holamundojava.backend;

public class Operaciones {
    private int x;
    private int y;

    public Operaciones(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int suma(){
        return this.x + this.y;
    }
    public int resta(){
        return this.x - this.y;
    }
    public int multiplicacion(){
        return this.x * this.y;
    }
    public String division(){
        if(this.y == 0)
            return "No se puede dividir por cero";
        else
            return String.valueOf((double)this.x / this.y);
    }
}

