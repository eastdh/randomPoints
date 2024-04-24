package com.eastdh.apitest;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

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
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        
        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);
        
        retrofitAPI.getData("1").enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {
                    Post data = response.body();
                    Log.d("getData", "success");
                    Log.d("getData", "\ndata: " + data.toString());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.d("getData", "Failed");

                t.printStackTrace();
            }
        });
    }
}