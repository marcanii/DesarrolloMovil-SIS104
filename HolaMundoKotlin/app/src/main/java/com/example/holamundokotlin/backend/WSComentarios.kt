package com.example.holamundokotlin.backend

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WSComentarios {
    @SerializedName("id")
    @Expose
    var id: String = ""

    @SerializedName("usuario_id")
    @Expose
    var usuarioId: String = ""

    @SerializedName("producto_id")
    @Expose
    var productoId: String = ""

    @SerializedName("comentario")
    @Expose
    var comentario: String = ""

    @SerializedName("fecha_comentario")
    @Expose
    var fechaComentario: String = ""
}