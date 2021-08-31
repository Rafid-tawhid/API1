package com.example.api1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://cricket.sportmonks.com/api/v2.0/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        OurRetrofitClient ourRetrofitClient=retrofit.create(OurRetrofitClient.class);

       Call<OurMainDataClass> call= ourRetrofitClient.getData("BvI7ZMd5UxW8Xl1thH6pbKJdbXWSUBJxEbSuze8PjxgA9y0wvHEkPv26Pqz1");


        call.enqueue(new Callback<OurMainDataClass>() {
            @Override
            public void onResponse(Call<OurMainDataClass> call, Response<OurMainDataClass> response) {

                if (response.isSuccessful())
                {

                    List<ObjectDataClass> list=response.body().getData();

                    for (ObjectDataClass objectDataClass:list)
                    {
                        Log.d("aa",objectDataClass.getName());
                        Log.d("aa",String.valueOf(objectDataClass.getId()));

                    }

                }
                else
                {
                    Log.d("response","failed");
                }
            }

            @Override
            public void onFailure(Call<OurMainDataClass> call, Throwable t) {

                Log.d("response","failed");
            }
        });


    }
}