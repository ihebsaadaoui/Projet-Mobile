package com.example.CareFoMe;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import java.util.ArrayList;
import java.util.List;

public class Home extends Fragment
{
DBHelper dd;
    SQLiteDatabase db;
    Bundle bundle;
    String   username,email;
    StringBuilder outputText = new StringBuilder();
    DBHelper dbHelper;
    Context thiscontext;
    private static final String TAG = "NavigationDrawer";

    private static final int ERROR_DIALOG_REQUEST = 9001;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        thiscontext = container.getContext();
        return inflater.inflate(R.layout.home, container, false);

    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //setContentView(R.layout.home);
        Intent getlogindata = getActivity().getIntent();
        // Intent getlogindataFromhome=getIntent();
         username = getlogindata.getStringExtra("username");
        email = getlogindata.getStringExtra("Email");

        ImageButton btn_doc = getView().findViewById(R.id.imageButtonDoc);
        ImageButton btn_phar = getView().findViewById(R.id.imageButtonPharm);
        ImageButton btn_favoriteDoc = getView().findViewById(R.id.imageButtonDoc2);
        ImageButton imageButtonPharm2 = getView().findViewById(R.id.imageButtonPharm2);


        dbHelper = new DBHelper(thiscontext);
        imageButtonPharm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getActivity(),AppointementList.class);

                intent.putExtra("username", username);
                intent.putExtra("Email", email);



                startActivity(intent);


                //List<AppointementData> returnList = new ArrayList();
                //returnList= dbHelper.getAllAppointements();
                //System.out.println(returnList);





            }
        });

        btn_doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent=new Intent(getActivity(),DoctorsList.class);

                intent.putExtra("username", username);
                intent.putExtra("Email", email);



                startActivity(intent);




            }
        });
        btn_phar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent=new Intent(getActivity(),Pharmacy_MapsActivity.class);
                startActivity(intent);






            }
        });

        btn_favoriteDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent=new Intent(getActivity(),DocFavorite.class);

                intent.putExtra("username", username);
                intent.putExtra("Email", email);



                startActivity(intent);




            }
        });









    }




}
