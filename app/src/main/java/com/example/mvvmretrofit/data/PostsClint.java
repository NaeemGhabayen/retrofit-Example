package com.example.mvvmretrofit.data;

import com.example.mvvmretrofit.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClint {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static PostsClint INESTANCE;
    private PostIntrfacedata postIntrfacedata;

    public PostsClint() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postIntrfacedata = retrofit.create(PostIntrfacedata.class);
    }

    public static PostsClint getINESTANCE() {
        if (null == INESTANCE) {
            INESTANCE = new PostsClint();
        }
        return INESTANCE;
    }

    public Call<List<PostModel>> getAllposts() {
        return postIntrfacedata.allposts();
    }
}
