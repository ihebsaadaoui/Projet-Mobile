package com.example.CareFoMe;




import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapterAppointement extends RecyclerView.Adapter<CustomAdapterAppointement.ListViewHolder> {
    Bundle bundle;

    Context context;
    List<AppointementData> dataList = new ArrayList<>();
    LayoutInflater inflater;
    Intent apt;
    String username,email;
    private static long idCounter = 0;
    DBHelper dbHelper;
    public static String mail ;
    public CustomAdapterAppointement(Context context, List dataList1,String u,String e) {
        this.dbHelper= new DBHelper(context);
        this.context = context;
        this.dataList = dataList1;
        inflater = LayoutInflater.from(context);
        username=u;
        email=e;




    }


    public static synchronized String createID()
    {
        return String.valueOf(idCounter++);
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View convertView = inflater.inflate(R.layout.activity_custom_adapter_appointement, parent, false);
        ListViewHolder viewHolder = new ListViewHolder(convertView);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(final ListViewHolder holder, @SuppressLint("RecyclerView") final int position) {


        final String doc_name = dataList.get(position).Dname;


        holder.tv_name.setText(doc_name);
        holder.mobile.setText(dataList.get(position).phNumber);
        String full_date = dataList.get(position).date+"  "+ dataList.get(position).time;
        holder.date.setText(full_date);


        //bundle.putString("Name",dataList.get(position).name);









    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;
        TextView mobile;
        TextView date;


        public ListViewHolder(View itemView) {
            super(itemView);

            context = (Context)  itemView.getContext();
            tv_name = (TextView) itemView.findViewById(R.id.textViewTV);
            mobile = (TextView) itemView.findViewById(R.id.mobile);
            date= (TextView) itemView.findViewById(R.id.date);


        }
    }


}
