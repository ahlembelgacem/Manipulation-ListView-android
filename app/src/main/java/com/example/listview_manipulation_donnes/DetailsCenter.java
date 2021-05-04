package com.example.listview_manipulation_donnes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.concurrent.Callable;

public class DetailsCenter extends AppCompatActivity {
EditText nom,ville,latitude,longitude;
Button mod,supp;
int id;
Helper h =new Helper(DetailsCenter.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_center);
        nom=findViewById(R.id.nom);
        ville=findViewById(R.id.ville);
        latitude=findViewById(R.id.latitude);
        longitude=findViewById(R.id.longitude);
        supp=findViewById(R.id.supp);
        mod=findViewById(R.id.mod);
        id= Integer.parseInt(getIntent().getStringExtra("id"));
        Centre centre=h.getCentre(Integer.parseInt("id"));
        nom.setText(centre.getNom());
        ville.setText(centre.getVille());
        latitude.setText(centre.getLatitude());
        longitude.setText(centre.getLongitude());
        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Centre centre =new Centre(Integer.parseInt(String.valueOf(id)),nom.getText().toString(),ville.getText().toString(),latitude.getText().toString(),longitude.getText().toString());
               h.updateCenter(id,centre);
                Intent intent= new Intent(DetailsCenter.this,ListCenter.class);
                startActivity(intent);
            }
        });
        supp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                h.deleteCenter(id);
                Intent intent= new Intent(DetailsCenter.this,ListCenter.class);
                startActivity(intent);
            }
        });


    }
}