package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Details extends AppCompatActivity {

    ArrayList<Pays> pays_list=new ArrayList<>();
    ListView lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        pays_list.add(new Pays("Maroc","Rabat","Afric",676767,R.drawable.ma));
        pays_list.add(new Pays("Egypt","Cairo","Afric",767676,R.drawable.eg));
        pays_list.add(new Pays("Espagne","Madrid","Europe",3434343,R.drawable.es));
        pays_list.add(new Pays("Argentine","Buenos Aires","Amerique",3444343,R.drawable.ar));
        pays_list.add(new Pays("Belgique","Bruxelle","Europe",232323,R.drawable.be));
        pays_list.add(new Pays("Japan","Tokyo","Asie",32323,R.drawable.jp));
        pays_list.add(new Pays("France","Paris","Europe",232323,R.drawable.fr));
        pays_list.add(new Pays("Portugal","Lesbon","Europe",23232,R.drawable.pt));

        lst=findViewById(R.id.lst);
        ArrayList<HashMap<String,Object>> lista=new ArrayList<>();
        for(Pays p : pays_list){
            HashMap<String,Object> hm=new HashMap<>();
            hm.put("image",p.getImage());
            hm.put("nom",p.getNom());
            hm.put("capital",p.getCapital());
            hm.put("contein",p.getContinent());
            hm.put("population",p.getPopulation());
            lista.add(hm);
        }
        String[] from={"image","nom","capital","contein","population"};
        int[] to={R.id.pic,R.id.lbl_nom,R.id.lbl_capital,R.id.lbl_contein,R.id.lbl_population};
        SimpleAdapter ad=new SimpleAdapter(this,lista,R.layout.pays_item,from,to);
        lst.setAdapter(ad);
    }
}