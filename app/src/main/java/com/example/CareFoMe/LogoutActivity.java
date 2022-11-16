package com.example.CareFoMe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class LogoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);


        startActivity(new Intent(LogoutActivity.this, MainPage.class));
        SharedPreferences sharedPreferences = getSharedPreferences("UserPref",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.clear();
        myEdit.commit();
        Toast.makeText(LogoutActivity.this, "See You Soon", Toast.LENGTH_SHORT).show();
    }
}
