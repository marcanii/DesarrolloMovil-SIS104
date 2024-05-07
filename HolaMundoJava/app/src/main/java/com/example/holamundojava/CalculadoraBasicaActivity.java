package com.example.holamundojava;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.holamundojava.backend.OperacionesBasicas;

public class CalculadoraBasicaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button buttonUno, buttonDos, buttonTres, buttonCuatro, buttonCinco, buttonSeis, buttonSiete, buttonOcho, buttonNueve, buttonCero, buttonSuma, buttonResta, buttonMultiplicacion, buttonDivision, buttonIgual, buttonPunto, buttonBorrar;
        EditText editTextNumbers;
        Button buttonSalir;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_basica);

        buttonUno = findViewById(R.id.buttonUno);
        buttonDos = findViewById(R.id.buttonDos);
        buttonTres = findViewById(R.id.buttonTres);
        buttonCuatro = findViewById(R.id.buttonCuatro);
        buttonCinco = findViewById(R.id.buttonCinco);
        buttonSeis = findViewById(R.id.buttonSeis);
        buttonSiete = findViewById(R.id.buttonSiete);
        buttonOcho = findViewById(R.id.buttonOcho);
        buttonNueve = findViewById(R.id.buttonNueve);
        buttonCero = findViewById(R.id.buttonCero);
        buttonSuma = findViewById(R.id.buttonSumar);
        buttonResta = findViewById(R.id.buttonRestar);
        buttonMultiplicacion = findViewById(R.id.buttonMultiplicar);
        buttonDivision = findViewById(R.id.buttonDividir);
        buttonIgual = findViewById(R.id.buttonIgual);
        buttonBorrar = findViewById(R.id.buttonLimpiar);
        editTextNumbers = findViewById(R.id.editTextNumbers);
        buttonSalir = findViewById(R.id.buttonSalirCalculadoraBasica);
        buttonUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNumbers.setText(editTextNumbers.getText() + "1");
            }
        });
        buttonDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNumbers.setText(editTextNumbers.getText() + "2");
            }
        });
        buttonTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNumbers.setText(editTextNumbers.getText() + "3");
            }
        });
        buttonCuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNumbers.setText(editTextNumbers.getText() + "4");
            }
        });
        buttonCinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNumbers.setText(editTextNumbers.getText() + "5");
            }
        });
        buttonSeis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNumbers.setText(editTextNumbers.getText() + "6");
            }
        });
        buttonSiete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNumbers.setText(editTextNumbers.getText() + "7");
            }
        });
        buttonOcho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNumbers.setText(editTextNumbers.getText() + "8");
            }
        });
        buttonNueve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNumbers.setText(editTextNumbers.getText() + "9");
            }
        });
        buttonCero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNumbers.setText(editTextNumbers.getText() + "0");
            }
        });
        buttonSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNumbers.setText(editTextNumbers.getText() + "+");
            }
        });
        buttonResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNumbers.setText(editTextNumbers.getText() + "-");
            }
        });
        buttonMultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNumbers.setText(editTextNumbers.getText() + "*");
            }
        });
        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNumbers.setText(editTextNumbers.getText() + "/");
            }
        });
        buttonIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OperacionesBasicas operacionesBasicas = new OperacionesBasicas();
                String cadena = editTextNumbers.getText().toString();
                String[] elementos = cadena.split("[-+*/]");

                if (elementos.length == 2) {
                    int num1 = Integer.parseInt(elementos[0]);
                    int num2 = Integer.parseInt(elementos[1]);

                    if (cadena.contains("+")) {
                        editTextNumbers.setText(String.valueOf(operacionesBasicas.suma(num1, num2)));
                    } else if (cadena.contains("-")) {
                        editTextNumbers.setText(String.valueOf(operacionesBasicas.resta(num1, num2)));
                    } else if (cadena.contains("*")) {
                        editTextNumbers.setText(String.valueOf(operacionesBasicas.multiplicacion(num1, num2)));
                    } else if (cadena.contains("/")) {
                        if (num2 != 0) {
                            editTextNumbers.setText(String.valueOf(operacionesBasicas.division(num1, num2)));
                        } else {
                            editTextNumbers.setText("No se puede dividir por cero");
                        }
                    }
                }
            }
        });

        buttonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNumbers.setText("");
            }
        });
        buttonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}