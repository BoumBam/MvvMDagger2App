package com.example.daag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.daag.databinding.ActivityMainBinding;
import com.example.daag.model.RecyclerList;

public class MainActivity extends AppCompatActivity {

    RecyclerViewAdapter recyclerViewAdapter;
    private MainActivityViewModel viewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter = new RecyclerViewAdapter();
        binding.recyclerView.setAdapter(recyclerViewAdapter);

        getData();
    }

    private void getData() {
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.getRecyclerListObserver().observe(this, new Observer<RecyclerList>() {
            @Override
            public void onChanged(RecyclerList recyclerList) {
                if(recyclerList != null) {
                    Log.d("TAG", "onChanged: " + recyclerList.getItems());
                    recyclerViewAdapter.setListData(recyclerList.getItems());
                    recyclerViewAdapter.notifyDataSetChanged();
                    //Toast.makeText(MainActivity.this, ""+recyclerList.getItems(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Unable to fetch data", Toast.LENGTH_LONG).show();
                }
            }
        });
        viewModel.makeApiCall();
    }
}