package com.example.api1;

import android.util.Log;

import com.example.api1.part3.ArrayDesignClass;
import com.example.api1.part3.TeamPlayer;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OurRetrofitClient {

//    @GET("continents")
//    Call<OurMainDataClass> getData(@Query("api_token") String token);
// @GET("continents/{id}")
// Call<CallById> getData(@Path ("id") int id,@Query("api_token") String token);
   @GET("teams/{id}")
   Call<TeamPlayer> getData(@Path ("id") int id, @Query("api_token") String token);

   @GET("players")
    Call<ArrayDesignClass> getPlayerData(@Query("api_token") String token
     , @Query("country_id") int cid
    );

}
