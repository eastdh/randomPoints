package com.eastdh.apitest;



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitAPI {
    @GET("posts/{post}")
    Call<Post> getData(@Path("post") String post);
}
