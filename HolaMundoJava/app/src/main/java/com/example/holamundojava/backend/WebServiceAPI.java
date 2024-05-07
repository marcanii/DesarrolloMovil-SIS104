package com.example.holamundojava.backend;

import java.util.List;

import io.reactivex.Observable;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebServiceAPI {
    @GET("albums")
    Call<List<WSAlbums>> getAlbums();

    @GET("users")
    Call<List<WSUsers>> getUsers();

    @GET("photos")
    Call<List<WSPhotos>> getPhotos();

    @GET("WSPrimer.php")
    Call<List<WSLugares>> getLugares();

    @GET("WSComentarios.php")
    Call<List<WSComentarios>> getComentarios();

    @GET("WSPedidos.php")
    Call<List<WSPedidos>> getPedidos();

    @GET("WSProductos.php")
    Call<List<WSProductos>> getProductos();

    @GET("WSUsuarios.php")
    Call<List<WSUsuarios>> getUsuarios();

    //@GET("viewContenidos/id/{id_asignatura}")
    //Observable<List<WSContenidos>> getContenidosObs(@Path("id_asignatura") Integer id_asignatura, @Header("Authorization") String token);
    @GET("WSComentarios.php")
    Observable<List<WSComentarios>> getComentariosObservable();

    @GET("WSPedidos.php")
    Observable<List<WSPedidos>> getPedidosObservable();

    @GET("WSProductos.php")
    Observable<List<WSProductos>> getProductosObservable();

    @GET("WSUsuarios.php")
    Observable<List<WSUsuarios>> getUsuariosObservable();
}