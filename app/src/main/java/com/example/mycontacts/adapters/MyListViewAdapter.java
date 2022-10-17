package com.example.mycontacts.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mycontacts.R;
import com.example.mycontacts.entities.Contact;

import java.util.ArrayList;

public class MyListViewAdapter extends BaseAdapter{

    Context context;
    ArrayList<Contact> data;

    public MyListViewAdapter(Context context, ArrayList<Contact> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        //return number of views to be created
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        //return the item (data of the view) with i position
        return null;
    }

    @Override
    public long getItemId(int i) {
        //return the id of the item
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //return the view to be displayed
        //create the view
        LayoutInflater inf = LayoutInflater.from(context);
        View v =View.inflate(context, R.layout.view_contact,null);

        //retrieve holders (content of the view)
        TextView tv_nom = v.findViewById(R.id.tv_nom_contact);
        TextView tv_prenom = v.findViewById(R.id.tv_prenom_contact);
        TextView tv_telephone = v.findViewById(R.id.tv_telephone_contact);
        ImageView  img_call = v.findViewById(R.id.image_view_appel_contact);
        ImageView  img_delete = v.findViewById(R.id.image_view_delete_contact);

        //get the contact based on the id i
        Contact c = data.get(i);
        //set the values of textView to be displayed
        tv_nom.setText(c.getFirst_name());
        tv_prenom.setText(c.getLast_name());
        tv_telephone.setText(c.getPhone_number());

        //Event for delete
        //listener for delete button
        img_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.remove(i);
                notifyDataSetChanged();
            }
        });

        //listener for update button
        img_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //to make a call
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+c.getPhone_number()));
                context.startActivity(i);
            }
        });
        return v;
    }
}
