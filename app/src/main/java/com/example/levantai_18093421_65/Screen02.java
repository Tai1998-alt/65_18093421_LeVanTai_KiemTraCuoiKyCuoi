package com.example.levantai_18093421_65;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Screen02 extends AppCompatActivity {

    RecyclerView recyclerView;
    List<User> list;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen02);
        recyclerView = findViewById(R.id.recyclerView);
        list = new ArrayList<>();
        list.add(new User("Shadow Plants","230 types", R.drawable.removebgpreview));
        list.add(new User("Green Plants","260 types", R.drawable.removebg_plants));
        list.add(new User("Black Plants","290 types", R.drawable.anh2));
        myAdapter = new MyAdapter(list, Screen02.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(Screen02.this, recyclerView.HORIZONTAL,false));
        recyclerView.setAdapter(myAdapter);
    }
}