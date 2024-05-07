package com.example.primerparcial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button buttonEjercicio1, buttonEjercicio2, buttonEjercicio3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonEjercicio1 =findViewById(R.id.buttonEjercicio1);
        buttonEjercicio2 =findViewById(R.id.buttonEjercicio2);
        buttonEjercicio3 =findViewById(R.id.buttonEjercicio3);

        buttonEjercicio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ejercicio1Activity.class);
                startActivity(intent);
            }
        });
        buttonEjercicio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ejercicio2Activity.class);
                startActivity(intent);
            }
        });
        buttonEjercicio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ejercicio3Activity.class);
                startActivity(intent);
            }
        });
    }
}