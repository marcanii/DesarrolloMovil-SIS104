package com.example.holamundojava;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.holamundojava.backend.WSAlbums;
import com.example.holamundojava.backend.WSComentarios;
import com.example.holamundojava.backend.WSLugares;
import com.example.holamundojava.backend.WSPedidos;
import com.example.holamundojava.backend.WSPhotos;
import com.example.holamundojava.backend.WSProductos;
import com.example.holamundojava.backend.WSUsers;
import com.example.holamundojava.backend.WSUsuarios;
import com.example.holamundojava.backend.WebServiceAPI;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.android.schedulers.AndroidSchedulers;


public class WSActivity extends AppCompatActivity {
    List<WSAlbums> listData = new ArrayList<>();
    List<WSUsers> listaUsers = new ArrayList<>();
    List<WSPhotos> listaPhotos = new ArrayList<>();
    List<WSLugares> listaLugares = new ArrayList<>();
    List<WSUsuarios> listaUsuarios = new ArrayList<>();
    List<WSComentarios> listaComentarios = new ArrayList<>();
    List<WSPedidos> listaPedidos = new ArrayList<>();
    List<WSProductos> listaProductos = new ArrayList<>();

    Button buttonAlbums, buttonUsers, buttonPhotos, buttonMiWSLugares, buttonTiendaOnline, buttonTiendaOnline2;
    TextView textViewUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wsactivity);

        buttonAlbums = findViewById(R.id.buttonAlbums);
        buttonUsers = findViewById(R.id.buttonUsers);
        buttonPhotos = findViewById(R.id.buttonPhotos);
        buttonMiWSLugares = findViewById(R.id.buttonMiWSLugares);
        buttonTiendaOnline = findViewById(R.id.buttonTiendaOnline);
        buttonTiendaOnline2 = findViewById(R.id.buttonTiendaOnline2);
        textViewUsers = findViewById(R.id.textViewUsers);

        buttonAlbums.setOnClickListener(v -> {
            getData();
        });

        buttonUsers.setOnClickListener(v -> {
            getDataUsers();
        });
        buttonPhotos.setOnClickListener(v -> {
            getDataPhotos();
        });
        buttonMiWSLugares.setOnClickListener(v -> {
            getLugares();
        });
        buttonTiendaOnline.setOnClickListener(v -> {
            getTiendaOnline();
        });
        buttonTiendaOnline2.setOnClickListener(v -> {
            getTiendaOnline2();
        });
    }

    public void getData(){
        String URL_WS = "https://jsonplaceholder.typicode.com/";
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_WS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WebServiceAPI webServiceApi = retrofit.create(WebServiceAPI.class);
        final Call<List<WSAlbums>> call = webServiceApi.getAlbums();
        call.enqueue(new Callback<List<WSAlbums>>() {
            @Override
            public void onResponse(Call<List<WSAlbums>> call, Response<List<WSAlbums>> response) {
                if(response.isSuccessful()){
                    listData = response.body();
                    if (!listData.isEmpty()) {
                        WSAlbums album = listData.get(0);
                        StringBuilder albumData = new StringBuilder();
                        albumData.append("userId: ").append(album.getUserId()).append("\n");
                        albumData.append("ID: ").append(album.getId()).append("\n");
                        albumData.append("Title: ").append(album.getTitle()).append("\n");

                        textViewUsers.setText(albumData.toString());
                    } else {
                        Toast.makeText(WSActivity.this, "No se encontraron usuarios", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(WSActivity.this, "Algo paso", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<WSAlbums>> call, Throwable throwable) {
                Toast.makeText(WSActivity.this, "REVISE EL SERVICIO WEB DE INTERNET", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getDataUsers(){
        String URL_WS = "https://jsonplaceholder.typicode.com/";
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_WS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WebServiceAPI webServiceApi = retrofit.create(WebServiceAPI.class);
        final Call<List<WSUsers>> call = webServiceApi.getUsers();
        call.enqueue(new Callback<List<WSUsers>>() {
            @Override
            public void onResponse(Call<List<WSUsers>> call, Response<List<WSUsers>> response) {
                if(response.isSuccessful()) {
                    listaUsers = response.body();
                    if (!listaUsers.isEmpty()) {
                        WSUsers user = listaUsers.get(0); // Obtener el primer usuario
                        StringBuilder userData = new StringBuilder();
                        userData.append("ID: ").append(user.getId()).append("\n");
                        userData.append("Name: ").append(user.getName()).append("\n");
                        userData.append("Username: ").append(user.getUsername()).append("\n");
                        userData.append("Email: ").append(user.getEmail()).append("\n");
                        userData.append("Address: \n");
                        userData.append("   Street: ").append(user.getAddress().getStreet()).append("\n");
                        userData.append("   Suite: ").append(user.getAddress().getSuite()).append("\n");
                        userData.append("   City: ").append(user.getAddress().getCity()).append("\n");
                        userData.append("   ZipCode: ").append(user.getAddress().getZipcode()).append("\n");
                        userData.append("   Geo: \n");
                        userData.append("       Lat: ").append(user.getAddress().getGeo().getLat()).append("\n");
                        userData.append("       Lng: ").append(user.getAddress().getGeo().getLng()).append("\n");
                        userData.append("Phone: ").append(user.getPhone()).append("\n");
                        userData.append("Website: ").append(user.getWebsite()).append("\n");
                        userData.append("Company: \n");
                        userData.append("   Name: ").append(user.getCompany().getName()).append("\n");
                        userData.append("   CatchPhrase: ").append(user.getCompany().getCatchPhrase()).append("\n");
                        userData.append("   bs: ").append(user.getCompany().getBs()).append("\n\n");
                        // Mostrar la información en un TextView
                        textViewUsers.setText(userData.toString());
                    } else {
                        Toast.makeText(WSActivity.this, "No se encontraron usuarios", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(WSActivity.this, "Algo paso", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<List<WSUsers>> call, Throwable throwable) {
                Toast.makeText(WSActivity.this, "REVISE EL SERVICIO WEB DE INTERNET", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getDataPhotos(){
        String URL_WS = "https://jsonplaceholder.typicode.com/";
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_WS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WebServiceAPI webServiceApi = retrofit.create(WebServiceAPI.class);
        final Call<List<WSPhotos>> call = webServiceApi.getPhotos();
        call.enqueue(new Callback<List<WSPhotos>>() {
            @Override
            public void onResponse(Call<List<WSPhotos>> call, Response<List<WSPhotos>> response) {
                if(response.isSuccessful()) {
                    listaPhotos = response.body();
                    if (!listaPhotos.isEmpty()) {
                        WSPhotos photo = listaPhotos.get(0);
                        StringBuilder photoData = new StringBuilder();
                        photoData.append("AlbumID: ").append(photo.getAlbumId()).append("\n");
                        photoData.append("ID: ").append(photo.getId()).append("\n");
                        photoData.append("Title: ").append(photo.getTitle()).append("\n");
                        photoData.append("URL: ").append(photo.getUrl()).append("\n");
                        photoData.append("thumbnailURL: ").append(photo.getThumbnailUrl()).append("\n");

                        textViewUsers.setText(photoData.toString());
                    }else {
                        Toast.makeText(WSActivity.this, "No se encontraron usuarios", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(WSActivity.this, "Algo paso", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<WSPhotos>> call, Throwable throwable) {
                Toast.makeText(WSActivity.this, "REVISE EL SERVICIO WEB DE INTERNET", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getLugares(){
        String URL_WS = "http://192.168.13.122/WSMio/";
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_WS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WebServiceAPI webServiceApi = retrofit.create(WebServiceAPI.class);
        final Call<List<WSLugares>> call = webServiceApi.getLugares();
        call.enqueue(new Callback<List<WSLugares>>() {
            @Override
            public void onResponse(Call<List<WSLugares>> call, Response<List<WSLugares>> response) {
                if(response.isSuccessful()) {
                    listaLugares = response.body();
                    if (!listaLugares.isEmpty()) {
                        WSLugares lugar = listaLugares.get(0);
                        StringBuilder luagarData = new StringBuilder();
                        luagarData.append("ID: ").append(lugar.getId()).append("\n");
                        luagarData.append("Nombre: ").append(lugar.getNombre()).append("\n");
                        luagarData.append("Descripcion: ").append(lugar.getDescripcion()).append("\n");
                        luagarData.append("Latitud: ").append(lugar.getLatitud()).append("\n");
                        luagarData.append("Longitud: ").append(lugar.getLongitud()).append("\n");

                        textViewUsers.setText(luagarData.toString());
                    }else {
                        Toast.makeText(WSActivity.this, "No se encontraron usuarios", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(WSActivity.this, "Algo paso", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<WSLugares>> call, Throwable throwable) {
                Toast.makeText(WSActivity.this, "REVISE EL SERVICIO WEB DE INTERNET", Toast.LENGTH_SHORT).show();
                Log.e("Error", "Error en la llamada al servicio web", throwable);
            }
        });
    }

    public void getTiendaOnline(){
        String URL_WS = "http://192.168.13.122/WSMio/";
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_WS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WebServiceAPI webServiceApi = retrofit.create(WebServiceAPI.class);

        // Crear las llamadas a los servicios web
        final Call<List<WSUsuarios>> callUsuarios = webServiceApi.getUsuarios();
        final Call<List<WSComentarios>> callComentarios = webServiceApi.getComentarios();
        final Call<List<WSPedidos>> callPedidos = webServiceApi.getPedidos();
        final Call<List<WSProductos>> callProductos = webServiceApi.getProductos();
        textViewUsers.setText("");
        double inicio = System.currentTimeMillis();
        double tiempoTotal=0.f;
        callUsuarios.enqueue(new Callback<List<WSUsuarios>>() {
            @Override
            public void onResponse(Call<List<WSUsuarios>> call, Response<List<WSUsuarios>> response) {
                if(response.isSuccessful()) {
                    double inicioComentario = System.currentTimeMillis();
                    listaUsuarios = response.body();
                    if (!listaUsuarios.isEmpty()) {
                        WSUsuarios usuario = listaUsuarios.get(0);
                        StringBuilder usuarios = new StringBuilder();
                        usuarios.append("USUARIO: \n");
                        usuarios.append("ID: ").append(usuario.getId()).append("\n");
                        usuarios.append("Nombre: ").append(usuario.getNombre()).append("\n");
                        usuarios.append("Edad: ").append(usuario.getEdad()).append("\n");
                        usuarios.append("Email: ").append(usuario.getEmail()).append("\n");
                        usuarios.append("Direccion: ").append(usuario.getDireccion()).append("\n\n");
                        textViewUsers.append(usuarios.toString());
                    }else {
                        Toast.makeText(WSActivity.this, "No se encontraron usuarios", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(WSActivity.this, "Algo paso", Toast.LENGTH_SHORT).show();
                }
                double finalComentario = System.currentTimeMillis();
                double tiempoComentario = finalComentario - inicio;
                Log.d("Tiempo", "Tiempo de ejecución de Comentarios: " + tiempoComentario + " ms");
                //tiempoTotal += tiempoComentario;
            }

            @Override
            public void onFailure(Call<List<WSUsuarios>> call, Throwable throwable) {
                Toast.makeText(WSActivity.this, "REVISE EL SERVICIO WEB DE INTERNET", Toast.LENGTH_SHORT).show();
                Log.e("Error", "Error en la llamada al servicio web", throwable);
            }
        });

        callComentarios.enqueue(new Callback<List<WSComentarios>>() {
            @Override
            public void onResponse(Call<List<WSComentarios>> call, Response<List<WSComentarios>> response) {
                if(response.isSuccessful()) {
                    listaComentarios = response.body();
                    if (!listaComentarios.isEmpty()) {
                        WSComentarios comentario = listaComentarios.get(0);
                        StringBuilder Comentarios = new StringBuilder();
                        Comentarios.append("COMENTARIO: \n");
                        Comentarios.append("ID: ").append(comentario.getId()).append("\n");
                        Comentarios.append("Usuario ID: ").append(comentario.getUsuarioId()).append("\n");
                        Comentarios.append("Producto ID: ").append(comentario.getProductoId()).append("\n");
                        Comentarios.append("Comentario: ").append(comentario.getComentario()).append("\n");
                        Comentarios.append("Fecha Comentario: ").append(comentario.getFechaComentario()).append("\n\n");
                        textViewUsers.append(Comentarios.toString());
                    }else {
                        Toast.makeText(WSActivity.this, "No se encontraron Comentarios", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(WSActivity.this, "Algo paso", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<WSComentarios>> call, Throwable throwable) {
                Toast.makeText(WSActivity.this, "REVISE EL SERVICIO WEB DE INTERNET", Toast.LENGTH_SHORT).show();
                Log.e("Error", "Error en la llamada al servicio web", throwable);
            }
        });

        // Manejar la respuesta de Pedidos
        callPedidos.enqueue(new Callback<List<WSPedidos>>() {
            @Override
            public void onResponse(Call<List<WSPedidos>> call, Response<List<WSPedidos>> response) {
                if(response.isSuccessful()) {
                    listaPedidos = response.body();
                    if (!listaPedidos.isEmpty()) {
                        WSPedidos pedido = listaPedidos.get(0);
                        StringBuilder pedidos = new StringBuilder();
                        pedidos.append("PEDIDO: \n");
                        pedidos.append("ID: ").append(pedido.getId()).append("\n");
                        pedidos.append("Usuario ID: ").append(pedido.getUsuarioId()).append("\n");
                        pedidos.append("Producto ID: ").append(pedido.getProductoId()).append("\n");
                        pedidos.append("Cantidad: ").append(pedido.getCantidad()).append("\n");
                        pedidos.append("Fecha Comentario: ").append(pedido.getFechaPedido()).append("\n\n");
                        textViewUsers.append(pedidos.toString());
                    }else {
                        Toast.makeText(WSActivity.this, "No se encontraron Pedidos", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(WSActivity.this, "Algo paso", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<WSPedidos>> call, Throwable throwable) {
                Toast.makeText(WSActivity.this, "REVISE EL SERVICIO WEB DE INTERNET", Toast.LENGTH_SHORT).show();
                Log.e("Error", "Error en la llamada al servicio web", throwable);
            }
        });

        // Manejar la respuesta de Productos
        callProductos.enqueue(new Callback<List<WSProductos>>() {
            @Override
            public void onResponse(Call<List<WSProductos>> call, Response<List<WSProductos>> response) {
                if(response.isSuccessful()) {
                    listaProductos = response.body();
                    if (!listaProductos.isEmpty()) {
                        WSProductos producto = listaProductos.get(0);
                        StringBuilder productos = new StringBuilder();
                        productos.append("PRODUCTO: \n");
                        productos.append("ID: ").append(producto.getId()).append("\n");
                        productos.append("Nombre: ").append(producto.getNombre()).append("\n");
                        productos.append("Precio: ").append(producto.getPrecio()).append("\n");
                        productos.append("Descripcion: ").append(producto.getDescripcion()).append("\n");
                        productos.append("Categoria: ").append(producto.getCategoria()).append("\n\n");
                        textViewUsers.append(productos.toString());
                    }else {
                        Toast.makeText(WSActivity.this, "No se encontraron Pedidos", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(WSActivity.this, "Algo paso", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<WSProductos>> call, Throwable throwable) {
                Toast.makeText(WSActivity.this, "REVISE EL SERVICIO WEB DE INTERNET", Toast.LENGTH_SHORT).show();
                Log.e("Error", "Error en la llamada al servicio web", throwable);
            }
        });
        double finale = System.currentTimeMillis();
        double tiempo = finale - inicio;
        textViewUsers.append("Tiempo de ejecución: " + tiempo + " ms\n\n");
    }
    public void getTiendaOnline2() {
        String URL_WS = "http://192.168.0.6/WSMio/";
        Gson gson = new GsonBuilder().setLenient().create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit2 = new Retrofit.Builder()
                .baseUrl(URL_WS)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        WebServiceAPI webServiceApi = retrofit2.create(WebServiceAPI.class);
        List<Observable<?>> requests = new ArrayList<>();

        requests.add(webServiceApi.getUsuariosObservable());
        requests.add(webServiceApi.getComentariosObservable());
        requests.add(webServiceApi.getPedidosObservable());
        requests.add(webServiceApi.getProductosObservable());

        Disposable obs = Observable.zip(requests,
                        new Function<Object[], Object>() {
                            @Override
                            public Object apply(Object[] objects) throws Exception {
                                listaComentarios = (List<WSComentarios>) objects[1];
                                listaPedidos = (List<WSPedidos>) objects[2];
                                listaProductos = (List<WSProductos>) objects[3];
                                listaUsuarios = (List<WSUsuarios>) objects[0];
                                return new Object();
                            }
                        })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<Object>() {
                    @Override
                    public void onNext(Object o) {
                        // Método requerido pero no necesitamos hacer nada aquí
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("Datos", "OnError ");
                    }

                    @Override
                    public void onComplete() {
                        Log.d("Datos", "Finalizado con éxito onComplete ");

                        WSUsuarios usuario = listaUsuarios.get(2);
                        WSProductos producto = listaProductos.get(2);
                        WSComentarios comentario = listaComentarios.get(2);
                        WSPedidos pedido = listaPedidos.get(2);

                        StringBuilder dato = new StringBuilder();
                        dato.append("USUARIO: \n");
                        dato.append("ID: ").append(usuario.getId()).append("\n");
                        dato.append("Nombre: ").append(usuario.getNombre()).append("\n");
                        dato.append("Edad: ").append(usuario.getEdad()).append("\n");
                        dato.append("Email: ").append(usuario.getEmail()).append("\n");
                        dato.append("Direccion: ").append(usuario.getDireccion()).append("\n\n");

                        dato.append("PRODUCTO: \n");
                        dato.append("ID: ").append(producto.getId()).append("\n");
                        dato.append("Nombre: ").append(producto.getNombre()).append("\n");
                        dato.append("Precio: ").append(producto.getPrecio()).append("\n");
                        dato.append("Descripcion: ").append(producto.getDescripcion()).append("\n");
                        dato.append("Categoria: ").append(producto.getCategoria()).append("\n\n");

                        dato.append("COMENTARIO: \n");
                        dato.append("ID: ").append(comentario.getId()).append("\n");
                        dato.append("Usuario ID: ").append(comentario.getUsuarioId()).append("\n");
                        dato.append("Producto ID: ").append(comentario.getProductoId()).append("\n");
                        dato.append("Comentario: ").append(comentario.getComentario()).append("\n");
                        dato.append("Fecha Comentario: ").append(comentario.getFechaComentario()).append("\n\n");

                        dato.append("PEDIDO: \n");
                        dato.append("ID: ").append(pedido.getId()).append("\n");
                        dato.append("Usuario ID: ").append(pedido.getUsuarioId()).append("\n");
                        dato.append("Producto ID: ").append(pedido.getProductoId()).append("\n");
                        dato.append("Cantidad: ").append(pedido.getCantidad()).append("\n");
                        dato.append("Fecha pedido: ").append(pedido.getFechaPedido()).append("\n\n");

                        textViewUsers.setText(dato.toString());
                    }
                });
    }
}