package com.example.holamundokotlin.backend

import io.reactivex.Observable
import retrofit2.http.GET

interface WebServiceAPI {
    @GET("WSComentarios.php")
    fun getComentariosObservable(): Observable<List<WSComentarios>>

    @GET("WSPedidos.php")
    fun getPedidosObservable(): Observable<List<WSPedidos>>

    @GET("WSProductos.php")
    fun getProductosObservable(): Observable<List<WSProductos>>

    @GET("WSUsuarios.php")
    fun getUsuariosObservable(): Observable<List<WSUsuarios>>
}