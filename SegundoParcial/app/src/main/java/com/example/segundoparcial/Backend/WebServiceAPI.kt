package com.example.segundoparcial.Backend

import retrofit2.Call

import retrofit2.http.GET

interface WebServiceAPI {
    @GET("Puntos.php")
    fun getPuntos():Call<List<Puntos>>
}