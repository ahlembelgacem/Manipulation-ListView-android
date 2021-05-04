package com.example.listview_manipulation_donnes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText nom,ville,latitude,longitude;
Button add;
Helper h =new Helper(MainActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nom=findViewById(R.id.nom);
        ville=findViewById(R.id.ville);
        latitude=findViewById(R.id.latitude);
        longitude=findViewById(R.id.longitude);
        add=findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Centre centre= new Centre(nom.getText().toString(),ville.getText().toString(),latitude.getText().toString(),longitude.getText().toString());
        h.addCentre(centre);
        Intent intent= new Intent(MainActivity.this,ListCenter.class);
        startActivity(intent);
    }
});


    }
}