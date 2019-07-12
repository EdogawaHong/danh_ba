package com.example.ad36_nguyenthihong_day03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends ArrayAdapter<Contact> {

    Context context;
    int resource;
     private ArrayList<Contact> arrayContact;

    public Adapter(Context context, int resource, ArrayList<Contact> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.arrayContact=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView= LayoutInflater.from(context).inflate(R.layout.item,parent,false);

        ImageView imAvatar=convertView.findViewById(R.id.imAvatar);
        TextView tvName=convertView.findViewById(R.id.tvName);
        TextView tvNumber=convertView.findViewById(R.id.tvNumber);

        Contact contact=arrayContact.get(position);

        if(contact.isMale){
            imAvatar.setBackgroundResource(R.drawable.nam);
        }else{
            imAvatar.setBackgroundResource(R.drawable.nu);
        }
        tvName.setText(contact.getName());
        tvNumber.setText(contact.getNumber());
        return convertView;
    }


}
