package com.example.examenfinal;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.examenfinal.backend.BaseDatos;
import com.example.examenfinal.backend.Data;
import com.example.examenfinal.backend.WSApi;
import com.example.examenfinal.backend.WSUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GuardarActivity extends AppCompatActivity {
    private TextView textViewResultado;
    private BaseDatos db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_guardar);
        textViewResultado = findViewById(R.id.textViewResultado1);
        db = new BaseDatos(this);
        getUsers();

    }
    public void getUsers() {
        String URL_WS = "https://gorest.co.in/public-api/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_WS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WSApi webServiceApi = retrofit.create(WSApi.class);
        Call<WSUser> call = webServiceApi.getUsers();
        call.enqueue(new Callback<WSUser>() {
            @Override
            public void onResponse(Call<WSUser> call, Response<WSUser> response) {
                if (response.isSuccessful()) {
                    WSUser userResponse = response.body();
                    if (userResponse != null && userResponse.getData() != null && !userResponse.getData().isEmpty()) {
                        List<Data> listaUsers = userResponse.getData();
                        StringBuilder usersData = new StringBuilder();
                        for (Data user : listaUsers) {
                            boolean isInserted = db.addUser(user);
                            usersData.append("ID: ").append(user.getId()).append("\n");
                            usersData.append("Name: ").append(user.getName()).append("\n");
                            usersData.append("Email: ").append(user.getEmail()).append("\n");
                            usersData.append("Gender: ").append(user.getGender()).append("\n");
                            usersData.append("Status: ").append(user.getStatus()).append("\n");
                            usersData.append("Inserted: ").append(isInserted ? "Yes" : "No").append("\n\n");
                        }
                        textViewResultado.setText(usersData.toString());
                    } else {
                        Toast.makeText(GuardarActivity.this, "No se encontraron usuarios", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(GuardarActivity.this, "Algo pasó", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<WSUser> call, Throwable throwable) {
                Toast.makeText(GuardarActivity.this, "REVISE EL SERVICIO WEB DE INTERNET", Toast.LENGTH_SHORT).show();
            }
        });
    }
}