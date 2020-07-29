package com.example.mvvmretrofit.data;

import com.example.mvvmretrofit.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostIntrfacedata {
    @GET("posts")
    public Call<List<PostModel>> allposts();


}
