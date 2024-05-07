package com.example.holamundokotlin

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.holamundokotlin.backend.Grafico

class GraficoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grafico)
        val buttonCuadrado = findViewById<Button>(R.id.buttonCuadrado)
        val buttonCubo = findViewById<Button>(R.id.buttonCubo)
        val button2D = findViewById<Button>(R.id.button2D)
        val button3D = findViewById<Button>(R.id.button3D)
        val buttonCaratula = findViewById<Button>(R.id.buttonCaratula)

        buttonCuadrado.setOnClickListener { v: View? ->
            val grafico = Grafico(this, "cuadrado")
            setContentView(grafico)
        }
        buttonCubo.setOnClickListener { v: View? ->
            val grafico = Grafico(this, "cubo")
            setContentView(grafico)
        }
        button2D.setOnClickListener(View.OnClickListener { v: View? ->
            val grafico = Grafico(this, "2D")
            setContentView(grafico)
        })
        button3D.setOnClickListener(View.OnClickListener { v: View? ->
            val grafico = Grafico(this, "3D")
            setContentView(grafico)
        })
        buttonCaratula.setOnClickListener(View.OnClickListener { v: View? ->
            val grafico = Grafico(this, "caratula")
            setContentView(grafico)
        })
    }
}