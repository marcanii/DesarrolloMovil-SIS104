package com.example.examenfinal;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.examenfinal.backend.BaseDatos;

public class ListarActivity extends AppCompatActivity {
    TextView textViewListar;
    BaseDatos db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_listar);

        textViewListar = findViewById(R.id.textViewListar);
        db = new BaseDatos(this);
        displayUsers();
    }

    private void displayUsers() {
        Cursor cursor = db.getAllUsers();
        StringBuilder usersData = new StringBuilder();

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                String email = cursor.getString(cursor.getColumnIndexOrThrow("email"));
                String gender = cursor.getString(cursor.getColumnIndexOrThrow("gender"));
                String status = cursor.getString(cursor.getColumnIndexOrThrow("status"));

                usersData.append("ID: ").append(id).append("\n");
                usersData.append("Name: ").append(name).append("\n");
                usersData.append("Email: ").append(email).append("\n");
                usersData.append("Gender: ").append(gender).append("\n");
                usersData.append("Status: ").append(status).append("\n\n");
            } while (cursor.moveToNext());
        }
        cursor.close();

        textViewListar.setText(usersData.toString());
    }
}