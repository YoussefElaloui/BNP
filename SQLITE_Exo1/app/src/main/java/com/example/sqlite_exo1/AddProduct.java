package com.example.sqlite_exo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddProduct extends AppCompatActivity {

    EditText txt_libelle,txt_famille,txt_achat,txt_vente;
    Button btn;
    MyDBProduit db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        db=new MyDBProduit(this);
        txt_libelle=findViewById(R.id.txt_libelle);
        txt_famille=findViewById(R.id.txt_famille);
        txt_achat=findViewById(R.id.txt_prixAchat);
        txt_vente=findViewById(R.id.txt_prixVente);
        btn=findViewById(R.id.btn_addProduit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txt_libelle.getText().toString().isEmpty()||
                        txt_vente.getText().toString().isEmpty()||
                        txt_achat.getText().toString().isEmpty()||
                        txt_famille.getText().toString().isEmpty()){
                    Toast.makeText(AddProduct.this, "Some TextZone is Empty", Toast.LENGTH_LONG).show();
                    return;
                }
                if(MyDBProduit.insertProduct(db.getWritableDatabase(),new Produit(txt_libelle.getText().toString(),
                        txt_famille.getText().toString(),
                        Double.valueOf(txt_achat.getText().toString()),Double.valueOf(txt_vente.getText().toString())))!=-1)
                    Toast.makeText(AddProduct.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                else Toast.makeText(AddProduct.this, "Cannot add this Product", Toast.LENGTH_SHORT).show();
            }
        });
    }
}