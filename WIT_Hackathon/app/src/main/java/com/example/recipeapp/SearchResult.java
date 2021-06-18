package com.example.recipeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class SearchResult extends AppCompatActivity {


    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    List<DataClass> dc;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        initData();
        initRecyclerView();
    }

    private void initData() {
        dc = new ArrayList<>();
        //maybe bind all data to this dc class object
        dc.add(new DataClass(R.drawable.food1,"Sabudana Thalipeeth","Breakfast","4h30m", 1));
        dc.add(new DataClass(R.drawable.food1,"Jalebi","Breakfast","1h20m", 2));
        dc.add(new DataClass(R.drawable.food1,"Poha","Breakfast","30m", 3));
        dc.add(new DataClass(R.drawable.food1,"Biryani","Lunch","60m", 4));
        dc.add(new DataClass(R.drawable.food1,"Rice Kheer","Sweets","60m", 5));
        dc.add(new DataClass(R.drawable.food1,"Kadhai Makahni","Lunch","60m", 6));
        dc.add(new DataClass(R.drawable.food1,"Paneer Makahni","Lunch","60m", 7));
        dc.add(new DataClass(R.drawable.food1,"Jalebi","Breakfast","1h20m", 8));
        dc.add(new DataClass(R.drawable.food1,"Poha","Breakfast","30m", 9));
        dc.add(new DataClass(R.drawable.food1,"Biryani","Lunch","60m", 10));
        dc.add(new DataClass(R.drawable.food1,"Rice Kheer","Sweets","60m", 11));
        dc.add(new DataClass(R.drawable.food1,"Kadhai Makahni","Lunch","60m", 12));

    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView1);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new Adapter(dc);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}