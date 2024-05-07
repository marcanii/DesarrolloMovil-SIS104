package com.example.holamundojava;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CrudActivity extends AppCompatActivity {
    BaseDatos baseDatos;
    SQLiteDatabase db;
    String nombre, paterno, materno;
    Button buttonGuardar, buttonSalir;
    EditText editTextNombre, editTextPaterno, editTextMaterno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);

        buttonGuardar = findViewById(R.id.buttonGuardar);
        buttonSalir = findViewById(R.id.buttonSalirResgistro);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextPaterno = findViewById(R.id.editTextPaterno);
        editTextMaterno = findViewById(R.id.editTextMaterno);

        baseDatos = new BaseDatos(CrudActivity.this, "bd_academico", null, 1);
        db = baseDatos.getWritableDatabase();

        buttonGuardar.setOnClickListener(v -> {
            nombre = editTextNombre.getText().toString();
            paterno = editTextPaterno.getText().toString();
            materno = editTextMaterno.getText().toString();
            String SQL = "INSERT INTO personas(paterno, materno, nombre)VALUES('"+paterno+"', '"+materno+"', '"+nombre+"');";
            db.execSQL(SQL);
        });

        buttonSalir.setOnClickListener(v -> {
            finish();
        });
    }
}