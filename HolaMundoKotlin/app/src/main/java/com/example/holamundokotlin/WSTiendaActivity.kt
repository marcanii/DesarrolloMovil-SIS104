package com.example.holamundokotlin

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.holamundokotlin.backend.WSComentarios
import com.example.holamundokotlin.backend.WSPedidos
import com.example.holamundokotlin.backend.WSProductos
import com.example.holamundokotlin.backend.WSUsuarios
import com.example.holamundokotlin.backend.WebServiceAPI
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class WSTiendaActivity : AppCompatActivity() {

    var listaUsuarios: List<WSUsuarios> = java.util.ArrayList<WSUsuarios>()
    var listaComentarios: List<WSComentarios> = java.util.ArrayList<WSComentarios>()
    var listaPedidos: List<WSPedidos> = java.util.ArrayList<WSPedidos>()
    var listaProductos: List<WSProductos> = java.util.ArrayList<WSProductos>()

    var textViewResultado: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_wstienda)
        textViewResultado = findViewById(R.id.textViewResultado)

        getTiendaOnline2()
    }

    fun getTiendaOnline2() {
        val URL_WS = "http://192.168.97.122/WSMio/"
        val gson = GsonBuilder().setLenient().create()
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
        val retrofit2 = Retrofit.Builder()
            .baseUrl(URL_WS)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        val webServiceApi: WebServiceAPI = retrofit2.create(WebServiceAPI::class.java)
        val requests: MutableList<Observable<*>> = ArrayList()
        requests.add(webServiceApi.getUsuariosObservable())
        requests.add(webServiceApi.getComentariosObservable())
        requests.add(webServiceApi.getPedidosObservable())
        requests.add(webServiceApi.getProductosObservable())
        val obs: Disposable = Observable.zip<Any, Any>(
            requests
        ) { objects ->
            listaComentarios = objects[1] as List<WSComentarios>
            listaPedidos = objects[2] as List<WSPedidos>
            listaProductos = objects[3] as List<WSProductos>
            listaUsuarios = objects[0] as List<WSUsuarios>
            Any()
        }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<Any?>() {
                override fun onNext(o: Any) {
                    // Método requerido pero no necesitamos hacer nada aquí
                }

                override fun onError(e: Throwable) {
                    Log.d("Datos", "OnError ")
                }

                override fun onComplete() {
                    Log.d("Datos", "Finalizado con éxito onComplete ")
                    val usuario: WSUsuarios = listaUsuarios.get(2)
                    val producto: WSProductos = listaProductos.get(2)
                    val comentario: WSComentarios = listaComentarios.get(2)
                    val pedido: WSPedidos = listaPedidos.get(2)
                    val dato = StringBuilder()
                    dato.append("USUARIO: \n")
                    dato.append("ID: ").append(usuario.id).append("\n")
                    dato.append("Nombre: ").append(usuario.nombre).append("\n")
                    dato.append("Edad: ").append(usuario.edad).append("\n")
                    dato.append("Email: ").append(usuario.email).append("\n")
                    dato.append("Direccion: ").append(usuario.direccion).append("\n\n")
                    dato.append("PRODUCTO: \n")
                    dato.append("ID: ").append(producto.id).append("\n")
                    dato.append("Nombre: ").append(producto.nombre).append("\n")
                    dato.append("Precio: ").append(producto.precio).append("\n")
                    dato.append("Descripcion: ").append(producto.descripcion).append("\n")
                    dato.append("Categoria: ").append(producto.categoria).append("\n\n")
                    dato.append("COMENTARIO: \n")
                    dato.append("ID: ").append(comentario.id).append("\n")
                    dato.append("Usuario ID: ").append(comentario.usuarioId).append("\n")
                    dato.append("Producto ID: ").append(comentario.productoId).append("\n")
                    dato.append("Comentario: ").append(comentario.comentario).append("\n")
                    dato.append("Fecha Comentario: ").append(comentario.fechaComentario)
                        .append("\n\n")
                    dato.append("PEDIDO: \n")
                    dato.append("ID: ").append(pedido.id).append("\n")
                    dato.append("Usuario ID: ").append(pedido.usuarioId).append("\n")
                    dato.append("Producto ID: ").append(pedido.productoId).append("\n")
                    dato.append("Cantidad: ").append(pedido.cantidad).append("\n")
                    dato.append("Fecha pedido: ").append(pedido.fechaPedido).append("\n\n")
                    textViewResultado?.setText(dato.toString())
                }
            })
    }
}