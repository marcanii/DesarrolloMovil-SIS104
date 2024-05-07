package com.example.primerparcial;

import android.os.Bundle;
import com.example.primerparcial.backend.Grafico;
import androidx.appcompat.app.AppCompatActivity;

public class Ejercicio2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);

        Grafico grafico = new Grafico(this);
        setContentView(grafico);

    }
}