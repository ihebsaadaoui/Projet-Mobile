package com.example.CareFoMe;


import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
DBHelper dr;
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Cursor cursor;
    SharedPreferences mSharedPref ;
public static String eee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

      // openHelper=new dataBaseClass(this);

      // db=openHelper.getReadableDatabase();
        final EditText EmailLogin=findViewById(R.id.EmailLogin);
        final EditText PassLogin=findViewById(R.id.PasswordLogin);
        final TextView DispUser= findViewById(R.id.textViewLogin);

        final Intent NavDrawer=new Intent(LoginActivity.this,NavigationDrawer.class);
        final Intent Home=new Intent(LoginActivity.this,Home.class);


        final DBHelper d2=new DBHelper(this);




        Button LoginButton=findViewById(R.id.buttonLogin);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Email=EmailLogin.getText().toString();
                String Password=PassLogin.getText().toString();






                if(d2.checkUser(Email,Password)==true){

                    Toast.makeText(getApplicationContext(),"Login succesful ",Toast.LENGTH_LONG).show();
                   Bundle bundle = new Bundle();
                    SharedPreferences sharedPreferences = getSharedPreferences("UserPref",MODE_PRIVATE);




                   // Intent intent = new Intent(LoginActivity.this, TimeSlots.class);
                    String Name="";
                    String email="";
                    db=d2.getReadableDatabase();
                    cursor=d2.UserData(EmailLogin.getText().toString(),db);
                    if(cursor.moveToFirst()){


                        Name=cursor.getString(0);

                        email=cursor.getString(1);
                       // Toast.makeText(getApplicationContext(),Name,Toast.LENGTH_LONG).show();



                    eee=email;



                    }
                    NavDrawer.putExtra("username",Name);
                    NavDrawer.putExtra("Email",email);
                    SharedPreferences.Editor myEdit = sharedPreferences.edit();
                    myEdit.putString("Email", Email);
                    myEdit.putString("Password", Password);
                    myEdit.putString("Name", Name);
                    myEdit.commit();

                    startActivity(NavDrawer);

                }else{

                    Toast.makeText(getApplicationContext(),"Login Unsuccesful ",Toast.LENGTH_LONG).show();
                }


           //  String username = d2.getusername(Email,Password);

            }
        });



    }

}
