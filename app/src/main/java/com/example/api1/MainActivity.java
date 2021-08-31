package com.example.api1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.api1.part3.ArrayDesignClass;
import com.example.api1.part3.ObjectDesignClass;
import com.example.api1.part3.PositionClass;
import com.example.api1.part3.TeamPlayer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    OurRetrofitClient ourRetrofitClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://cricket.sportmonks.com/api/v2.0/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        ourRetrofitClient=retrofit.create(OurRetrofitClient.class);

//       Call<OurMainDataClass> call= ourRetrofitClient.getData("BvI7ZMd5UxW8Xl1thH6pbKJdbXWSUBJxEbSuze8PjxgA9y0wvHEkPv26Pqz1");
//
//
//        call.enqueue(new Callback<OurMainDataClass>() {
//            @Override
//            public void onResponse(Call<OurMainDataClass> call, Response<OurMainDataClass> response) {
//
//                if (response.isSuccessful())
//                {
//
//                    Log.d("aa",response.toString());
//                    List<ObjectDataClass> list=response.body().getData();
//
//                    for (ObjectDataClass objectDataClass:list)
//                    {
//                        Log.d("aa",objectDataClass.getName());
//                        Log.d("aa",String.valueOf(objectDataClass.getId()));
//
//                    }
//
//                }
//                else
//                {
//                    Log.d("response","failed");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<OurMainDataClass> call, Throwable t) {
//
//                Log.d("response","failed");
//            }
//        });

        //call by id



//        call.enqueue(new Callback<CallById>() {
//            @Override
//            public void onResponse(Call<CallById> call, Response<CallById> response) {
//                if (response.isSuccessful()) {
//
//                    ObjectDataClass objectDataClass = response.body().getData();
//
//                    Log.d("aa",objectDataClass.getName());
//                    Log.d("aa",objectDataClass.getResource());
//                    Log.d("aa",String.valueOf(objectDataClass.getId()));
//                    Log.d("aa",objectDataClass.getUpdated_at());
//
//
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<CallById> call, Throwable t) {
//
//            }
//        });

        Call<TeamPlayer> call= ourRetrofitClient.getData(10,"BvI7ZMd5UxW8Xl1thH6pbKJdbXWSUBJxEbSuze8PjxgA9y0wvHEkPv26Pqz1");


        call.enqueue(new Callback<TeamPlayer>() {
            @Override
            public void onResponse(Call<TeamPlayer> call, Response<TeamPlayer> response) {

                Log.d("bb",String.valueOf(response.isSuccessful()));

                Log.d("bb",String.valueOf(response.body().toString()));
                int cid=190324;

                String name=response.body().getName();
                Log.d("bb",String.valueOf(response.body().getCountry_id()));

                Call<ArrayDesignClass> playerCall= ourRetrofitClient.getPlayerData("BvI7ZMd5UxW8Xl1thH6pbKJdbXWSUBJxEbSuze8PjxgA9y0wvHEkPv26Pqz1",cid);

                playerCall.enqueue(new Callback<ArrayDesignClass>() {
                    @Override
                    public void onResponse(Call<ArrayDesignClass> call, Response<ArrayDesignClass> response) {

                        Log.d("bbb",String.valueOf(response.isSuccessful()));

                        List<ObjectDesignClass> list=response.body().getData();

                        for (ObjectDesignClass obj:list)
                        {
                            String dob=obj.getDateofbirth();
                            String fullname=obj.getFullname();
                            String gender=obj.getGender();
                            PositionClass positionClass=obj.getPositionClass();
                            String name=positionClass.getName();
                            Log.d("aaa",String.valueOf(cid));
                            Log.d("aaa",String.valueOf(dob));
                            Log.d("aaa",String.valueOf(fullname));
                            Log.d("aaa",String.valueOf(gender));
                            Log.d("aaa",String.valueOf(name));

                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayDesignClass> call, Throwable t) {

                    }
                });
            }

            @Override
            public void onFailure(Call<TeamPlayer> call, Throwable t) {

            }
        });

    }
}