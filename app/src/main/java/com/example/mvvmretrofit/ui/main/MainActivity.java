package com.example.mvvmretrofit.ui.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmretrofit.R;
import com.example.mvvmretrofit.pojo.PostModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewModel viewModel;
    RecyclerView recycleview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(ViewModel.class);
        recycleview = findViewById(R.id.recycleview);
        viewModel.getPosts();

        final PostsAdapter adapter = new PostsAdapter();
        recycleview.setLayoutManager(new LinearLayoutManager(this));
        recycleview.setAdapter(adapter);
        viewModel.stringMutableLiveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                adapter.setList(postModels);
            }
        });
    }
}
