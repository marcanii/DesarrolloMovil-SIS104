package com.example.segundoparcial

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.segundoparcial.Backend.BaseDatos
import com.example.segundoparcial.Backend.Puntos
import com.example.segundoparcial.Backend.Puntos1
import com.example.segundoparcial.Backend.WebServiceAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WSPuntosActivity : AppCompatActivity() {
    var dbHandler: BaseDatos? = null
    var listaPuntos: List<Puntos> = ArrayList<Puntos>()
    var listSQL: List<Puntos1> = ArrayList<Puntos1>()
    var textViewResultado: TextView? = null
    var punto1: Puntos1? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_wspuntos)
        val buttonListar = findViewById<Button>(R.id.buttonListar)
        textViewResultado =findViewById(R.id.textViewResultado)
        dbHandler = BaseDatos(this)
        getPuntos()

        buttonListar.setOnClickListener {
            listSQL = (dbHandler as BaseDatos).obtenerPuntos()
            Log.d("Datos", "------ Lista ------")
            for (puntos in listSQL) {
                Log.d(
                    "Datos",
                    "X1: " + puntos.x1 + " Y1: " + puntos.y1 + " X2: " + puntos.x2 + " Y2: " + puntos.y2 + " Distancia: " + puntos.distancia
                )
            }
        }
    }
    fun getPuntos() {
        val URL_WS = "http://192.168.56.122/WS2doParcial/"
        val retrofit = Retrofit.Builder()
            .baseUrl(URL_WS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val webServiceApi: WebServiceAPI = retrofit.create(WebServiceAPI::class.java)
        val call: Call<List<Puntos>> = webServiceApi.getPuntos()
        call.enqueue(object : Callback<List<Puntos>> {
            override fun onResponse(call: Call<List<Puntos>>, response: Response<List<Puntos>>) {
                if (response.isSuccessful) {
                    listaPuntos = response.body()!!
                    if (!listaPuntos.isEmpty()) {
                        val punto: Puntos = listaPuntos.get(0)
                        val id = punto.id!!.toInt()
                        val x1 = punto.x1!!.toFloat()
                        val y1 = punto.y1!!.toFloat()
                        val x2 = punto.x2!!.toFloat()
                        val y2 = punto.y2!!.toFloat()
                        punto1 = Puntos1(id = id, x1 = x1, y1 = y1, x2 = x2, y2 = y2, distancia = 0.0f)
                        dbHandler!!.addPuntos(punto1!!)
                        val luagarData = StringBuilder()
                        luagarData.append("ID: ").append(punto.id).append("\n")
                        luagarData.append("X1: ").append(punto.x1).append("\n")
                        luagarData.append("Y1: ").append(punto.y1)
                            .append("\n")
                        luagarData.append("X2: ").append(punto.x2).append("\n")
                        luagarData.append("Y2: ").append(punto.y2).append("\n")
                        textViewResultado?.setText(luagarData.toString())
                    } else {
                        Toast.makeText(
                            this@WSPuntosActivity,
                            "No se encontraron datos",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Toast.makeText(this@WSPuntosActivity, "Algo paso", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Puntos>>, throwable: Throwable) {
                Toast.makeText(
                    this@WSPuntosActivity,
                    "REVISE EL SERVICIO WEB DE INTERNET",
                    Toast.LENGTH_SHORT
                ).show()
                Log.e("Error", "Error en la llamada al servicio web", throwable)
            }
        })
    }
}