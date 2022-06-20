package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Pays> pays_list=new ArrayList<>();
    Spinner sp;
    TextView txt_capital,txt_contain,txt_population;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pays_list.add(new Pays("Maroc","Rabat","Afric",676767,R.drawable.ma));
        pays_list.add(new Pays("Egypt","Cairo","Afric",767676,R.drawable.eg));
        pays_list.add(new Pays("Espagne","Madrid","Europe",3434343,R.drawable.es));
        pays_list.add(new Pays("Argentine","Buenos Aires","Amerique",3444343,R.drawable.ar));
        pays_list.add(new Pays("Belgique","Bruxelle","Europe",232323,R.drawable.be));
        pays_list.add(new Pays("Japan","Tokyo","Asie",32323,R.drawable.jp));
        pays_list.add(new Pays("France","Paris","Europe",232323,R.drawable.fr));
        pays_list.add(new Pays("Portugal","Lesbon","Europe",23232,R.drawable.pt));

        sp=findViewById(R.id.cmb);
        txt_capital=findViewById(R.id.txt_capital);
        txt_contain=findViewById(R.id.txt_contain);
        txt_population=findViewById(R.id.txt_population);
        img=findViewById(R.id.img);

        ArrayList<String> paysNames=new ArrayList<>();

        for (Pays p : pays_list) {
            paysNames.add(p.getNom());
        }

        ArrayAdapter<String> ad=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,paysNames);
        sp.setAdapter(ad);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Pays p=pays_list.get(i);
                img.setImageResource(p.getImage());
                txt_capital.setText(p.getCapital());
                txt_contain.setText(p.getContinent());
                txt_population.setText(String.valueOf(p.getPopulation()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void goToDetails(View view) {
        Intent i=new Intent(MainActivity.this,Details.class);
        startActivity(i);
    }

    public void goToContact(View view) {
        Intent i =new Intent(MainActivity.this,Contact.class);
        startActivity(i);
    }
}