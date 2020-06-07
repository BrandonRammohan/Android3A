package com.example.myapplication;


import retrofit2.Call;
import retrofit2.http.GET;

public interface FootAPI {
    @GET("teams.json")
    Call<RestTeamsResponse> getTeamsResponse();

    @GET("/api/v2/ability")
    Call<RestTeamsResponse> getAbility();

    //public String teamA = null;
    //public String teamB = null;


    
}


