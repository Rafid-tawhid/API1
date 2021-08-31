package com.example.api1;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OurRetrofitClient {

    @GET("continents")
    Call<OurMainDataClass> getData(@Query("api_token") String token);

}
