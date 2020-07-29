package com.example.mvvmretrofit.ui.main;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmretrofit.data.PostsClint;
import com.example.mvvmretrofit.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewModel extends androidx.lifecycle.ViewModel {
    MutableLiveData<List<PostModel>> stringMutableLiveData =
            new MutableLiveData<>();

    public void getPosts() {
        PostsClint.getINESTANCE().getAllposts().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                stringMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {

            }
        });
    }


}
