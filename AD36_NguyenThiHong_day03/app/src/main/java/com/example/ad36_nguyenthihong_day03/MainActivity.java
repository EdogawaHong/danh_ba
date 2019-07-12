package com.example.ad36_nguyenthihong_day03;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvContact;
    RelativeLayout btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvContact = findViewById(R.id.lvContact);

        ArrayList<Contact> arrayList = new ArrayList<>();

        Contact contact1 = new Contact(true, "Mr A", "0123456789");
        Contact contact2 = new Contact(false, "Mrs B", "0123453345");
        Contact contact3 = new Contact(true, "Mr C", "0126789234");
        Contact contact4 = new Contact(true, "Mr D", "0123123678");
        Contact contact5 = new Contact(false, "Mrs E", "0123452679");
        Contact contact6 = new Contact(true, "Mr F", "0123496432");
        Contact contact7 = new Contact(false, "Mrs G", "0123127643");

        arrayList.add(contact1);
        arrayList.add(contact2);
        arrayList.add(contact3);
        arrayList.add(contact4);
        arrayList.add(contact5);
        arrayList.add(contact6);
        arrayList.add(contact7);


        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), AddNewContact.class));
            }
        });

        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Do you want Call or Message?")
                        .setPositiveButton("CALL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getBaseContext(), "CALL", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("MESSAGE", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getBaseContext(), "MESSAGE", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create();
                dialog.show();
            }
        });

        Intent intent = getIntent();
        String ten = intent.getStringExtra("NAME");
        String sdt = intent.getStringExtra("NUMBER");
        int kt = intent.getIntExtra("KT", 0);

        if (kt == 0) {
            Contact contact = new Contact(true, ten, sdt);
            arrayList.add(contact);
        } else {
            Contact contact = new Contact(false, ten, sdt);
            arrayList.add(contact);
        }


        Adapter adapter = new Adapter(this, R.layout.item, arrayList);
        lvContact.setAdapter(adapter);
    }
}
