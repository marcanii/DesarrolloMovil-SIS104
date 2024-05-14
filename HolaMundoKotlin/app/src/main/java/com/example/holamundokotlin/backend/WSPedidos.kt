package com.example.holamundokotlin.backend

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class WSPedidos {
    @SerializedName("id")
    @Expose
    var id: String = ""

    @SerializedName("usuario_id")
    @Expose
    var usuarioId: String = ""

    @SerializedName("producto_id")
    @Expose
    var productoId: String = ""

    @SerializedName("cantidad")
    @Expose
    var cantidad: String = ""

    @SerializedName("fecha_pedido")
    @Expose
    var fechaPedido: String = ""
}