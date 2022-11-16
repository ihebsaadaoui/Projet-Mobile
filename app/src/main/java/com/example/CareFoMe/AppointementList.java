package com.example.CareFoMe;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AppointementList extends AppCompatActivity {
    RecyclerView recyclerView;
    DBHelper dbHelper;
    CustomAdapterAppointement adapter;
    String username,email;
    int iduser;
    public static int idd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointement_list);

        List<AppointementData> returnList = new ArrayList();
        Intent getlogindata = getIntent();
        username =getlogindata.getStringExtra("username");
        email =getlogindata.getStringExtra("Email");
        dbHelper = new DBHelper(this);

        returnList= dbHelper.getAllAppointements();
        System.out.println("el liste"+returnList.size());
        this.recyclerView = findViewById(R.id.RecyclerViewAppList);
        adapter = new CustomAdapterAppointement(this, returnList,username,email);
        this.recyclerView.setAdapter(adapter);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
