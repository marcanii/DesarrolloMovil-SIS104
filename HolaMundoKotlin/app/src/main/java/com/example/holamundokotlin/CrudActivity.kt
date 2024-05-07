package com.example.holamundokotlin

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.holamundokotlin.backend.BaseDatos
import com.example.holamundokotlin.backend.Lugares

class CrudActivity : AppCompatActivity() {
    var dbHandler: BaseDatos? = null
    var listTasks: List<Lugares> = ArrayList<Lugares>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud)

        val buttonSalirCrud = findViewById<Button>(R.id.buttonSalirCrud)
        val buttonGuardar = findViewById<Button>(R.id.buttonGuardar)
        val buttonActualizar = findViewById<Button>(R.id.buttonActualizar)
        val buttonEliminar = findViewById<Button>(R.id.buttonEliminar)
        val buttonListar = findViewById<Button>(R.id.buttonListar)
        val buttonLimpiarCrud = findViewById<Button>(R.id.buttonLimpiarCrud)
        val editTextNombre = findViewById<EditText>(R.id.editTextNombre)
        val editTextDescripcion = findViewById<EditText>(R.id.editTextDescripcion)
        val editTextLatitud = findViewById<EditText>(R.id.editTextLatitud)
        val editTextLongitud = findViewById<EditText>(R.id.editTextLongitud)
        val editTextId = findViewById<EditText>(R.id.editTextId)
        dbHandler = BaseDatos(this)
        buttonSalirCrud.setOnClickListener {
            finish()
        }

        buttonLimpiarCrud.setOnClickListener {
            editTextId.setText("")
            editTextNombre.setText("")
            editTextDescripcion.setText("")
            editTextLatitud.setText("")
            editTextLongitud.setText("")
        }

        buttonGuardar.setOnClickListener {
            var success: Boolean = false
            val lugares: Lugares = Lugares()
            lugares.nombre = editTextNombre.getText().toString()
            lugares.descripcion = editTextDescripcion.getText().toString()
            lugares.latitud = editTextLatitud.getText().toString().toFloat();
            lugares.longitud = editTextLongitud.getText().toString().toFloat();
            success = dbHandler?.addLugar(lugares) as Boolean
            Log.d("Datos","Datos Guardatos ---> " + success.toString())
        }

        buttonListar.setOnClickListener {
            listTasks = (dbHandler as BaseDatos).lugar
            Log.d("Datos","------ Lista ------")
            for(lugares in listTasks){
                Log.d("Datos","Nombre: " + lugares.nombre + " --- ID: "+ lugares.id)
            }
        }

        buttonActualizar.setOnClickListener {
            var success: Boolean = false
            val lugares: Lugares = Lugares()
            lugares.id = editTextId.getText().toString().toInt()
            lugares.nombre = editTextNombre.getText().toString()
            lugares.descripcion = editTextDescripcion.getText().toString()
            lugares.latitud = editTextLatitud.getText().toString().toFloat();
            lugares.longitud = editTextLongitud.getText().toString().toFloat();
            success = dbHandler?.updateLugar(lugares) as Boolean
            Log.d("Datos","Datos Actualizados ---> " + success.toString())
        }

        buttonEliminar.setOnClickListener {
            var success: Boolean = false
            success = false
            success = dbHandler?.deleteLugar(editTextId.getText().toString().toInt()) as Boolean
            Log.d("Datos","Datos Eliminados ---> " + success.toString())
        }
        //listTasks = (dbHandler as BaseDatos).lugar
        //Log.d("Datos","--->"+listTasks)
    }
}