package com.example.holamundojava;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.holamundojava.backend.Operaciones;

public class CalculadoraActivity extends AppCompatActivity {

    EditText editTextA, editTextB;
    Button buttonCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        buttonCalcular = findViewById(R.id.buttonOperaciones);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(editTextA.getText().toString());
                int b = Integer.parseInt(editTextB.getText().toString());
                Operaciones operaciones = new Operaciones(a, b);
                Toast.makeText(CalculadoraActivity.this, "Suma: "+ operaciones.suma()+"\n"+
                                "Resta: "+ operaciones.resta()+"\n"+
                                "Multiplicacion: "+ operaciones.multiplicacion()+"\n"+
                                "Division: "+ operaciones.division(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}