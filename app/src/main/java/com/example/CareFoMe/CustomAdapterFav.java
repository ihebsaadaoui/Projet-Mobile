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

public class CustomAdapterFav extends RecyclerView.Adapter<CustomAdapterFav.ListViewHolder> {
    Bundle bundle;

    Context context;
    List<DoctorData> dataList = new ArrayList<>();
    LayoutInflater inflater;
    Intent apt;
    String username,email;
    private static long idCounter = 0;
    DBHelper dbHelper;
    public static String mail ;
    public CustomAdapterFav(Context context, List dataList1,String u,String e) {
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

        View convertView = inflater.inflate(R.layout.custom_adapter_fav, parent, false);
        ListViewHolder viewHolder = new ListViewHolder(convertView);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(final ListViewHolder holder, @SuppressLint("RecyclerView") final int position) {


        final String doc_name = dataList.get(position).name_f;
        holder.iv_book.setTag(position);

        holder.tv_name.setText(doc_name);
        holder.mobile.setText(dataList.get(position).email);


        //bundle.putString("Name",dataList.get(position).name);

        holder.iv_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                apt = new Intent(context,Appointment.class);
                apt.putExtra("username",username);
                apt.putExtra("Email",email);
                apt.putExtra("Doc Name",doc_name);


                mail=email;

                context.startActivity(apt);

            }
        });







    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;
        TextView mobile;
        Button iv_book;
        ImageView iv_whitefav;


        public ListViewHolder(View itemView) {
            super(itemView);

            context = (Context)  itemView.getContext();
            tv_name = (TextView) itemView.findViewById(R.id.textViewTV);
            mobile = (TextView) itemView.findViewById(R.id.mobile);
            iv_book= (Button) itemView.findViewById(R.id.imageViewbook);


        }
    }


}
