package com.example.segundoparcial.Backend

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import kotlin.math.sqrt

data class Puntos1(val id: Int, val x1: Float, val y1: Float, val x2: Float, val y2: Float, val distancia: Float)

class BaseDatos(context: Context): SQLiteOpenHelper(context, BaseDatos.NOMBRE_BASE_DATOS, null, BaseDatos.VERSION_BASE_DATOS) {

    companion object {
        const val NOMBRE_BASE_DATOS = "puntos.db"
        const val VERSION_BASE_DATOS = 1
        const val NOMBRE_TABLA = "puntos"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREAR_TABLA = """
            CREATE TABLE $NOMBRE_TABLA (
                id INTEGER PRIMARY KEY AUTOINCREMENT, 
                x1 FLOAT, 
                y1 FLOAT, 
                x2 FLOAT, 
                y2 FLOAT, 
                distancia FLOAT
            );
        """
        db?.execSQL(CREAR_TABLA)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val BORRAR_TABLA = "DROP TABLE IF EXISTS $NOMBRE_TABLA"
        db?.execSQL(BORRAR_TABLA)
        onCreate(db)
    }

    fun addPuntos(puntos: Puntos1): Boolean {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put("x1", puntos.x1)
            put("y1", puntos.y1)
            put("x2", puntos.x2)
            put("y2", puntos.y2)
            put("distancia", calcularDistancia(puntos.x1, puntos.y1, puntos.x2, puntos.y2))
        }
        val result = db.insert(NOMBRE_TABLA, null, values)
        db.close()
        return result != -1L
    }

    private fun calcularDistancia(x1: Float, y1: Float, x2: Float, y2: Float): Float {
        return sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1))
    }

    fun obtenerPuntos(): List<Puntos1> {
        val listaPuntos = mutableListOf<Puntos1>()
        val db = this.readableDatabase
        val query = "SELECT * FROM $NOMBRE_TABLA ORDER BY id DESC"
        val cursor: Cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                val x1 = cursor.getFloat(cursor.getColumnIndexOrThrow("x1"))
                val y1 = cursor.getFloat(cursor.getColumnIndexOrThrow("y1"))
                val x2 = cursor.getFloat(cursor.getColumnIndexOrThrow("x2"))
                val y2 = cursor.getFloat(cursor.getColumnIndexOrThrow("y2"))
                val distancia = cursor.getFloat(cursor.getColumnIndexOrThrow("distancia"))
                val punto = Puntos1(id, x1, y1, x2, y2, distancia)
                listaPuntos.add(punto)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()
        return listaPuntos
    }
}