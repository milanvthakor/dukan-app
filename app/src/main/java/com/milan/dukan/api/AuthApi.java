package com.milan.dukan.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AuthApi {

    String BASE_URL = "http://192.168.202.229:8000/api/user/";

    @POST("login")
    @FormUrlEncoded
    Call<AuthResponse> login(
            @Field("email") String email,
            @Field("password") String password
    );
}