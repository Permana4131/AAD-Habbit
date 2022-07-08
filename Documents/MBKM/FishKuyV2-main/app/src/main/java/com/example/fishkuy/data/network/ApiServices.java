package com.example.fishkuy.data.network;

import com.example.fishkuy.data.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiServices {

    @FormUrlEncoded
    @POST("login")
    Call<UserResponse> login(
            @Field("email")String email,
            @Field("password")String password
    );

    @FormUrlEncoded
    @POST("register")
    Call<UserResponse> register(
            @Field("email") String email,
            @Field("password")String password,
            @Field("phone")String phone,
            @Field("name")String name
    );
}
