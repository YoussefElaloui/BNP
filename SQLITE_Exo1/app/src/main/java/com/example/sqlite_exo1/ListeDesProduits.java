package com.example.sqlite_exo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListeDesProduits extends AppCompatActivity {
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_des_produits);
        lst=findViewById(R.id.lst);
        MyDBProduit db=new MyDBProduit(this);
        ArrayList<Produit> prds=MyDBProduit.getAllProducts(db.getReadableDatabase());
        ArrayList<String> ss=new ArrayList<>();
        for(Produit p :prds)ss.add(p.getId()+"--"+p.getLibelle());
        ArrayAdapter ad=new ArrayAdapter(this, android.R.layout.simple_list_item_1,ss);
        lst.setAdapter(ad);
    }
}