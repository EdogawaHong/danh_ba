package com.example.ad36_nguyenthihong_day03;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddNewContact extends AppCompatActivity {

    Spinner spinner;
    Button btnGender,btnSave;
    TextView tvGender;
    EditText etName,etNumber;
    int kiemtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);

        spinner=findViewById(R.id.spPhoneTypeContact);
        btnGender=findViewById(R.id.btnGender);
        tvGender=findViewById(R.id.tvGender);
        btnSave=findViewById(R.id.btnSave);
        etName=findViewById(R.id.etName);
        etNumber=findViewById(R.id.etNumber);

        ArrayList<String> PhoneType=new ArrayList<>();
        PhoneType.add("Gia đình");
        PhoneType.add("Công việc");
        PhoneType.add("Cá nhân");

        ArrayAdapter arrayAdapter=new ArrayAdapter<>(getBaseContext(),android.R.layout.simple_list_item_1,PhoneType);

        spinner.setAdapter(arrayAdapter);

        btnGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] chon={"Male","Female"};
                AlertDialog dialog=new AlertDialog.Builder(AddNewContact.this)
                        .setTitle("Chọn")
                        .setSingleChoiceItems(chon, 1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                tvGender.setText(chon[i]);
                                if(i==0) kiemtra=0;
                                else kiemtra=1;
                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getBaseContext(),"OK",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getBaseContext(),"CANCEL",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create();
                dialog.show();
            }
        });
    btnSave.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog dialog1=new AlertDialog.Builder(AddNewContact.this)
                    .setTitle("Do you want to save?")
                    .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getBaseContext(),"CANCEL",Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setPositiveButton("SAVE", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getBaseContext(),"SAVE",Toast.LENGTH_SHORT).show();

                            Intent intent =new Intent(getBaseContext(),MainActivity.class);

                            String name=etName.getText().toString();
                            String number=etNumber.getText().toString();
                            int kiemtra = AddNewContact.this.kiemtra;

                            if(TextUtils.isEmpty(name)||TextUtils.isEmpty(number)){
                                Toast.makeText(getBaseContext(),"Please input name or number!",Toast.LENGTH_SHORT).show();
                            }else{
                                intent.putExtra("NAME",name);
                                intent.putExtra("NUMBER",number);
                                intent.putExtra("KT",89);

                                startActivity(intent);
                            }
                        }
                    })
                    .create();
            dialog1.show();
        }
    });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
