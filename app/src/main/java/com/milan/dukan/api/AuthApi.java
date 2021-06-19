package com.milan.dukan.api;

import com.milan.dukan.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AuthApi {

    String BASE_URL = "http://192.168.156.229:8000/api/user/";

    @POST("register")
    Call<AuthResponse> register(@Body User user);

    @POST("login")
    @FormUrlEncoded
    Call<AuthResponse> login(
        @Field("email") String email,
        @Field("password") String password
    );
}