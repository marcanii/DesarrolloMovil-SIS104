package com.example.primerparcial.backend;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseDatos extends SQLiteOpenHelper {
    String SQL_CREATE = "CREATE TABLE productos(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nombre VARCHAR(40)," +
            "descripcion VARCHAR(40)," +
            "stock INTEGER," +
            "precio_unitario DECIMAL(10, 2));";
    String SQL_DROP = "DROP TABLE IF EXISTS productos;";
    public BaseDatos(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP);
        db.execSQL(SQL_CREATE);
    }
}
