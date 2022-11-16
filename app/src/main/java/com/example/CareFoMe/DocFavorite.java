package com.example.CareFoMe;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DocFavorite extends AppCompatActivity {
    RecyclerView recyclerView;
    DBHelper dbHelper;
    CustomAdapterFav adapter;
    String username,email;
    int iduser;
    public static int idd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
        //System.out.println("el liste"+dbHelper.getAllFavDoc().size());
        List<DoctorData> returnList = new ArrayList();
        Intent getlogindata = getIntent();
        username =getlogindata.getStringExtra("username");
        email =getlogindata.getStringExtra("Email");
        dbHelper = new DBHelper(this);

        returnList= dbHelper.getAllFavDoc();
        System.out.println("el liste"+returnList.size());
        this.recyclerView = findViewById(R.id.RecyclerViewDocFavList);
        adapter = new CustomAdapterFav(this, returnList,username,email);
        this.recyclerView.setAdapter(adapter);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
