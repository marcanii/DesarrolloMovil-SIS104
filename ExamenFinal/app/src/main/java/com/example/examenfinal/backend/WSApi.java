package com.example.examenfinal.backend;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WSApi {
    @GET("users")
    Call<WSUser> getUsers();
}
