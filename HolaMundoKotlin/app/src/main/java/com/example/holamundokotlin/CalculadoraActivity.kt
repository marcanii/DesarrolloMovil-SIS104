package com.example.holamundokotlin

import android.R.integer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalculadoraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        val buttonSumar = findViewById<Button>(R.id.buttonSumar)
        val buttonSalirCalculadora = findViewById<Button>(R.id.buttonSalirCalculadora)

        buttonSalirCalculadora.setOnClickListener {
            finish()
        }

    }
}