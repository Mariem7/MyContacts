package com.example.mycontacts.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycontacts.R;
import com.example.mycontacts.entities.Contact;

import java.util.ArrayList;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

    Context context;
    ArrayList<Contact> data;

    public MyRecyclerAdapter(Context context, ArrayList<Contact> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //create the view
        LayoutInflater inf = LayoutInflater.from(context);
        View v =View.inflate(context, R.layout.view_contact,null);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerAdapter.MyViewHolder holder, int position) {
        //get the contact based on the id i
        Contact c = data.get(position);
        //set the values of textView to be displayed
        holder.tv_nom.setText(c.getFirst_name());
        holder.tv_prenom.setText(c.getLast_name());
        holder.tv_telephone.setText(c.getPhone_number());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        //retrieve holders (content of the view)
        public TextView tv_nom,tv_prenom, tv_telephone;
        public ImageView img_call,img_delete;
        public MyViewHolder(@NonNull View v) {
            super(v);
            //retrieve holders (content of the view)
            tv_nom = v.findViewById(R.id.tv_nom_contact);
            tv_prenom = v.findViewById(R.id.tv_prenom_contact);
            tv_telephone = v.findViewById(R.id.tv_telephone_contact);
            img_call = v.findViewById(R.id.image_view_appel_contact);
            img_delete = v.findViewById(R.id.image_view_delete_contact);


            //Event for delete
            //listener for delete button
            img_delete.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    //get the id of the selected item
                    int i = getAdapterPosition();
                    data.remove(i);
                    notifyDataSetChanged();
                }
            });

            //listener for update button
            img_call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //get the id of the selected item
                    int i = getAdapterPosition();
                    //to make a call
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:"+data.get(getAdapterPosition()).getPhone_number()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
