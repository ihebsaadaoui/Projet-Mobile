package com.example.CareFoMe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DBHelper dbHelper;
    CustomAdapter adapter;
    String username,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent getlogindata = getIntent();

        username =getlogindata.getStringExtra("username");
        email =getlogindata.getStringExtra("Email");



        dbHelper = new DBHelper(this);





        RecyclerView recyclerView = findViewById(R.id.aa);

        adapter = new CustomAdapter(this, dbHelper.getAllDoc(),username,email);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));








    }









}