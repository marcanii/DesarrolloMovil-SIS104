package com.example.holamundokotlin
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    /*
    var buttonCalculadora = Button(this)
    var buttonGrafico = Button(this)
    var buttonCrud = Button(this)
    var buttonSalir = Button(this)
    */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonSalir = findViewById<Button>(R.id.buttonSalir)
        val buttonCalculadora = findViewById<Button>(R.id.buttonCalculadora)
        val buttonGrafico = findViewById<Button>(R.id.buttonGrafico)
        val buttonCrud = findViewById<Button>(R.id.buttonCrud)
        val buttonCalculadoraBasica = findViewById<Button>(R.id.buttonCalculadoraBasica)
        val buttonWSTienda = findViewById<Button>(R.id.buttonWSTienda)

        buttonSalir.setOnClickListener{
            finish()
        }

        buttonCalculadora.setOnClickListener {
            val intent = Intent(this@MainActivity, CalculadoraActivity::class.java)
            startActivity(intent)
        }

        buttonGrafico.setOnClickListener {
            val intent = Intent(this@MainActivity, GraficoActivity::class.java)
            startActivity(intent)
        }

        buttonCrud.setOnClickListener {
            val intent = Intent(this@MainActivity, CrudActivity::class.java)
            startActivity(intent)
        }

        buttonCalculadoraBasica.setOnClickListener {
            val intent = Intent(this@MainActivity, CalculadoraBasicaActivity::class.java)
            startActivity(intent)
        }
        buttonWSTienda.setOnClickListener {
            val intent = Intent(this@MainActivity, WSTiendaActivity::class.java)
            startActivity(intent)
        }
    }
}