package com.example.holamundokotlin.backend

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WSUsuarios {
    @SerializedName("id")
    @Expose
    var id: String = ""

    @SerializedName("nombre")
    @Expose
    var nombre: String = ""

    @SerializedName("edad")
    @Expose
    var edad: String = ""

    @SerializedName("email")
    @Expose
    var email: String = ""

    @SerializedName("direccion")
    @Expose
    var direccion: String = ""
}