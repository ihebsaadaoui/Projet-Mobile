package com.example.CareFoMe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FormDisplay extends AppCompatActivity {
    Button btnNotification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_display);

        btnNotification = findViewById(R.id.btn_notify_main);
        SharedPreferences sharedPreferences = getSharedPreferences("UserPref",MODE_PRIVATE);
        String emailPatient = sharedPreferences.getString("Email","default");
        String namePatient = sharedPreferences.getString("Name","default");
        final EditText PName=findViewById(R.id.Name);
        final EditText ApTime=findViewById(R.id.AptTime);
        final EditText PEmail=findViewById(R.id.EmailId);
        final TextView AppointmentDate= findViewById(R.id.textViewDateDisplay);
        final TextView DName=findViewById(R.id.FormDoctorName);

       final Bundle bundle = getIntent().getExtras();
     //  final Bundle bundleAppointment=getIntent().getExtras();


            final String NameP = bundle.getString("username");
            //String EmailP = bundle.getString("Email");

            String dname = bundle.getString("Doctor");
            final String DateA = bundle.getString("AppointmentDate");
            final String AptTime = bundle.getString("AppointmentTime");
            PName.setText(namePatient);
            PEmail.setText(emailPatient);
            ApTime.setText(AptTime);
            AppointmentDate.setText(DateA);
            DName.setText(dname);

        Button home = findViewById(R.id.buttonHome);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FormDisplay.this, NavigationDrawer.class));
                Toast.makeText(FormDisplay.this, "Thank you", Toast.LENGTH_SHORT).show();
            }
        });


        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel ch =new NotificationChannel("notification","notification",NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(ch);

        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Choisir une action").setTitle("Attention !");
        builder.setPositiveButton("confirmier", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(FormDisplay.this,"confirmée",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(FormDisplay.this,"annulée",Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNeutralButton("Fermer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(FormDisplay.this,"fermée",Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();

        btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(NotificationID.getID());
                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
                        FormDisplay.this,"notification");
                mBuilder.setSmallIcon(R.drawable.ic_launcher_background);
                mBuilder.setContentTitle("HEllo MR/MRS: "+NameP);
                mBuilder.setContentText("Your appointment will be "+DateA+" at "+AptTime);
                mBuilder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                mBuilder.setAutoCancel(true);
                NotificationManagerCompat notificationManager =
                        NotificationManagerCompat.from(FormDisplay.this);
                notificationManager.notify(NotificationID.getID(),mBuilder.build());

            }
        });



    }
}
