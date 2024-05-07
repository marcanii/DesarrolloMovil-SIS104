package com.example.primerparcial;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.primerparcial.backend.BaseDatos;

public class Ejercicio3Activity extends AppCompatActivity {
    BaseDatos baseDatos;
    SQLiteDatabase db;
    String nombre, descripcion;
    int stock;
    float precio_unitario;
    Button buttonGuardar, buttonSalir, buttonListarRegistros;
    EditText editTextNombre, editTextDescripcion, editTextStock, editTextPrecioUnitario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3);

        buttonGuardar = findViewById(R.id.buttonGuardar);
        buttonSalir = findViewById(R.id.buttonSalirEjericio3);
        buttonListarRegistros = findViewById(R.id.buttonListarRegistros);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextDescripcion = findViewById(R.id.editTextDescripcion);
        editTextStock = findViewById(R.id.editTextStock);
        editTextPrecioUnitario = findViewById(R.id.editTextPrecioUnitario);

        baseDatos = new BaseDatos(Ejercicio3Activity.this, "bd_productos", null, 1);

        buttonGuardar.setOnClickListener(v -> {
            nombre = editTextNombre.getText().toString();
            descripcion = editTextDescripcion.getText().toString();
            stock = Integer.parseInt(editTextStock.getText().toString());
            precio_unitario = Float.parseFloat(editTextPrecioUnitario.getText().toString());

            db = baseDatos.getWritableDatabase();
            String SQL = "INSERT INTO productos(nombre, descripcion, stock, precio_unitario) VALUES (?, ?, ?, ?)";
            Object[] args = {nombre, descripcion, stock, precio_unitario};
            db.execSQL(SQL, args);
            Toast.makeText(Ejercicio3Activity.this, "Se Registro Corectamente.", Toast.LENGTH_SHORT).show();
        });
        buttonListarRegistros.setOnClickListener(v -> {
            String SQL = "SELECT * FROM productos;";
            db = baseDatos.getReadableDatabase();
            Cursor cursor = db.rawQuery(SQL, null);

            if(cursor.moveToFirst()){
                do {
                    // Recuperar los datos de cada campo del registro
                    int id = cursor.getInt(0);
                    String nombre = cursor.getString(1);
                    String descripcion = cursor.getString(2);
                    int stock = cursor.getInt(3);
                    float precio_unitario = cursor.getFloat(4);

                    // Mostrar los datos en un Toast o en cualquier otro componente de la interfaz de usuario
                    String mensaje = "ID: " + id + "\nNombre: " + nombre + "\nDescripción: " + descripcion + "\nStock: " + stock + "\nPrecio unitario: " + precio_unitario;
                    Toast.makeText(Ejercicio3Activity.this, mensaje, Toast.LENGTH_SHORT).show();
                } while(cursor.moveToNext());
            } else {
                Toast.makeText(Ejercicio3Activity.this, "No existen registros", Toast.LENGTH_SHORT).show();
            }

            cursor.close();
            db.close();
        });
    }
}