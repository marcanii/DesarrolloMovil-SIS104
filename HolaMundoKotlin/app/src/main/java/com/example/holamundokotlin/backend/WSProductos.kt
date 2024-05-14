package com.example.holamundokotlin.backend

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WSProductos {
    @SerializedName("id")
    @Expose
    var id: String = ""

    @SerializedName("nombre")
    @Expose
    var nombre: String = ""

    @SerializedName("precio")
    @Expose
    var precio: String = ""

    @SerializedName("descripcion")
    @Expose
    var descripcion: String = ""

    @SerializedName("categoria")
    @Expose
    var categoria: String = ""
}