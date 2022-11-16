package com.example.CareFoMe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class splash_actitvity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_actitvity);
        final Intent Home=new Intent(splash_actitvity.this,NavigationDrawer.class);
        SharedPreferences sharedPreferences = getSharedPreferences("UserPref",MODE_PRIVATE);
       String email = sharedPreferences.getString("Email","default");
        String password = sharedPreferences.getString("Password","default");
        System.out.println(email);
        System.out.println(password);
        if(email != "default"  && password != "default"){

            startActivity(Home);
            finish();

        } else {
            TimerTask timerTask = new TimerTask()
            {
                @Override
                public void run() {
                    startActivity(new Intent(splash_actitvity.this, MainPage.class));


                }
            };
            Timer timer = new Timer();
            timer.schedule(timerTask,5000);
        }


    }
    }

