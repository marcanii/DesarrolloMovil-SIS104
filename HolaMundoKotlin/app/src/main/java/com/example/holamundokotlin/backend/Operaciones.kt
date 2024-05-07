package com.example.holamundokotlin.backend

class Operaciones(private var x: Double, private var y: Double) {
    fun suma():Double{
        return this.x + this.y
    }
    fun resta(): Double{
        return this.x - this.y
    }
    fun multiplicacion():Double{
        return this.x * this.y
    }
    fun division(): String{
        if(this.y!=0.0)
            return (this.x / this.y).toString()
        else
            return "No se puede dividir por cero"
    }
    fun setX(x:Double){
        this.x=x
    }
    fun getX():Double{
        return this.x
    }
    fun setY(y:Double){
        this.y=y
    }
    fun getY():String{
        return (this.y).toString()
    }
}