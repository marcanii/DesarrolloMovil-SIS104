package com.example.segundoparcial.Backend
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Puntos {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("x1")
    @Expose
    var x1: String? = null

    @SerializedName("y1")
    @Expose
    var y1: String? = null

    @SerializedName("x2")
    @Expose
    var x2: String? = null

    @SerializedName("y2")
    @Expose
    var y2: String? = null
}