package com.example.holamundokotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.holamundokotlin.backend.OperacionesBasicas

class CalculadoraBasicaActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora_basica)

        val buttonUno: Button = findViewById(R.id.buttonUno)
        val buttonDos: Button = findViewById(R.id.buttonDos)
        val buttonTres: Button = findViewById(R.id.buttonTres)
        val buttonCuatro: Button = findViewById(R.id.buttonCuatro)
        val buttonCinco: Button = findViewById(R.id.buttonCinco)
        val buttonSeis: Button = findViewById(R.id.buttonSeis)
        val buttonSiete: Button = findViewById(R.id.buttonSiete)
        val buttonOcho: Button = findViewById(R.id.buttonOcho)
        val buttonNueve: Button = findViewById(R.id.buttonNueve)
        val buttonCero: Button = findViewById(R.id.buttonCero)
        val buttonSuma: Button = findViewById(R.id.buttonSumar)
        val buttonResta: Button = findViewById(R.id.buttonRestar)
        val buttonMultiplicacion: Button = findViewById(R.id.buttonMultiplicar)
        val buttonDivision: Button = findViewById(R.id.buttonDividir)
        val buttonIgual: Button = findViewById(R.id.buttonIgual)
        val buttonBorrar: Button = findViewById(R.id.buttonLimpiar)
        val editTextNumbers: EditText = findViewById(R.id.editTextNumbers)
        val buttonSalir: Button = findViewById(R.id.buttonSalirCalculadoraBasica)
        buttonUno.setOnClickListener {
            editTextNumbers.setText(
                editTextNumbers.getText().toString() + "1"
            )
        }
        buttonDos.setOnClickListener {
            editTextNumbers.setText(
                editTextNumbers.getText().toString() + "2"
            )
        }
        buttonTres.setOnClickListener {
            editTextNumbers.setText(
                editTextNumbers.getText().toString() + "3"
            )
        }
        buttonCuatro.setOnClickListener {
            editTextNumbers.setText(
                editTextNumbers.getText().toString() + "4"
            )
        }
        buttonCinco.setOnClickListener {
            editTextNumbers.setText(
                editTextNumbers.getText().toString() + "5"
            )
        }
        buttonSeis.setOnClickListener {
            editTextNumbers.setText(
                editTextNumbers.getText().toString() + "6"
            )
        }
        buttonSiete.setOnClickListener {
            editTextNumbers.setText(
                editTextNumbers.getText().toString() + "7"
            )
        }
        buttonOcho.setOnClickListener {
            editTextNumbers.setText(
                editTextNumbers.getText().toString() + "8"
            )
        }
        buttonNueve.setOnClickListener {
            editTextNumbers.setText(
                editTextNumbers.getText().toString() + "9"
            )
        }
        buttonCero.setOnClickListener {
            editTextNumbers.setText(
                editTextNumbers.getText().toString() + "0"
            )
        }
        buttonSuma.setOnClickListener {
            editTextNumbers.setText(
                editTextNumbers.getText().toString() + "+"
            )
        }
        buttonResta.setOnClickListener {
            editTextNumbers.setText(
                editTextNumbers.getText().toString() + "-"
            )
        }
        buttonMultiplicacion.setOnClickListener {
            editTextNumbers.setText(
                editTextNumbers.getText().toString() + "*"
            )
        }
        buttonDivision.setOnClickListener {
            editTextNumbers.setText(
                editTextNumbers.getText().toString() + "/"
            )
        }
        buttonIgual.setOnClickListener {
            val operacionesBasicas = OperacionesBasicas()
            val cadena = editTextNumbers.text.toString()
            val elementos = cadena.split("[-+*/]".toRegex())

            if (elementos.size == 2) {
                val num1 = elementos[0].toInt()
                val num2 = elementos[1].toInt()
                if(cadena.contains('+')){
                    editTextNumbers.setText(operacionesBasicas.suma(num1, num2).toString())
                } else if(cadena.contains('-')){
                    editTextNumbers.setText(operacionesBasicas.resta(num1, num2).toString())
                } else if(cadena.contains('*')){
                    editTextNumbers.setText(operacionesBasicas.multiplicacion(num1, num2).toString())
                } else if(cadena.contains('/')){
                    if (num2 != 0) {
                        editTextNumbers.setText(operacionesBasicas.division(num1, num2))
                    } else {
                        editTextNumbers.setText("No se puede dividir por cero")
                    }
                }
            }
        }

        buttonBorrar.setOnClickListener { editTextNumbers.setText("") }
        buttonSalir.setOnClickListener { finish() }
    }
}