package com.example.getdatafaromdatabase;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Interface {

    @GET("phpFolder/connect_server.php")
    Call<List<MyGuest>> getPosts();

//    @POST("/api/users")
//    Call<List<MyGuest>> createUser(@Body MyGuest posts);
}
