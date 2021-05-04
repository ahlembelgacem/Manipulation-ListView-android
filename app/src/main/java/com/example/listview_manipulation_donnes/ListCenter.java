package com.example.listview_manipulation_donnes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class ListCenter extends AppCompatActivity {
    ListView ls;
    Helper h=new Helper(ListCenter.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_center);

            ls=findViewById(R.id.lst);

            Cursor c=h.fetchAllCenter();

            SimpleCursorAdapter adapter = new SimpleCursorAdapter(ListCenter.this,
                    R.layout.item,c,new String[]{
                    c.getColumnName(1),c.getColumnName(2),
                    c.getColumnName(0),},
                    new int[]{R.id.nom,R.id.ville,R.id.latitude,R.id.longitude},1);

            ls.setAdapter(adapter);

            ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    TextView t=view.findViewById(R.id.id);


                    Intent i =new Intent(getApplicationContext(), ListCenter.class);
                    i.putExtra("id",t.getText().toString());
                    startActivity(i);

                }
            });

        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu)
        {
            menu.add(0,1,0,"AJOUTER Center");
            return super.onCreateOptionsMenu(menu);
        }


        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId())
            {
                case 1 :
                    Intent i=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
            }

            return super.onOptionsItemSelected(item);
        }
    }
