package com.example.sqlite_exo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class updateProduct extends AppCompatActivity {
    MyDBProduit db;
    EditText txt_libelle,txt_famille,txt_achat,txt_vente;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_product);
        txt_libelle=findViewById(R.id.txt_Updatedlibelle);
        txt_famille=findViewById(R.id.txt_Updatedfamille);
        txt_achat=findViewById(R.id.txt_UpdatedprixAchat);
        txt_vente=findViewById(R.id.txt_UpdatedprixVente);
        btn=findViewById(R.id.btn_updateProduct);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}