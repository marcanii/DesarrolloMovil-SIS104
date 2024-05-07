package com.example.holamundojava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttonCalculadora, buttonGrafico, buttonCrud, buttonSalir, buttonCalculadoraBasica, buttonWS;

    // Método onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCalculadora = findViewById(R.id.buttonCalculadora);
        buttonGrafico = findViewById(R.id.buttonGrafico);
        buttonCrud = findViewById(R.id.buttonCrud);
        buttonSalir = findViewById(R.id.buttonSalir);
        buttonCalculadoraBasica = findViewById(R.id.buttonCalculadoraBasica);
        buttonWS = findViewById(R.id.buttonWS);

        buttonCalculadoraBasica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculadoraBasicaActivity.class);
                startActivity(intent);
            }
        });

        buttonCalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CalculadoraActivity.class);
                startActivity(intent);
            }
        });

        buttonGrafico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GraficoActivity.class);
                startActivity(intent);
            }
        });

        buttonCrud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CrudActivity.class);
                startActivity(intent);
            }
        });

        buttonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonWS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WSActivity.class);
                startActivity(intent);
            }
        });
    }
}