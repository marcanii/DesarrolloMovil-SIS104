package com.example.holamundojava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.holamundojava.backend.Grafico;

public class GraficoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico);

        Button buttonCirculo = findViewById(R.id.buttonCirculo);
        Button buttonLinea = findViewById(R.id.buttonLinea);
        Button buttonRamdonCirculo = findViewById(R.id.buttonRamdonCirculo);
        Button buttonArbol = findViewById(R.id.buttonArbol);
        Button button2D = findViewById(R.id.button2D);
        Button button3D = findViewById(R.id.button3D);

        buttonLinea.setOnClickListener(v -> {
            Grafico grafico = new Grafico(this, "linea");
            setContentView(grafico);
        });

        buttonCirculo.setOnClickListener(v -> {
            Grafico grafico = new Grafico(this, "circulo");
            setContentView(grafico);
        });

        buttonRamdonCirculo.setOnClickListener(v -> {
            Grafico grafico = new Grafico(this, "ramdonCirculo");
            setContentView(grafico);
        });

        buttonArbol.setOnClickListener(v -> {
            Grafico grafico = new Grafico(this, "arbol");
            setContentView(grafico);
        });

        button2D.setOnClickListener(v -> {
            Grafico grafico = new Grafico(this, "2D");
            setContentView(grafico);
        });
        button3D.setOnClickListener(v -> {
            Grafico grafico = new Grafico(this, "3D");
            setContentView(grafico);
        });
    }
}