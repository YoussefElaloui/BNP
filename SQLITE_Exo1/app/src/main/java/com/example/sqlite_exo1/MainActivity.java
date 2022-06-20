package com.example.sqlite_exo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void navigate(View view) {
        Intent i=null;
        switch (view.getId()){
            case R.id.btn_listPrds:i=new Intent(MainActivity.this,ListeDesProduits.class);break;
            case R.id.btn_newPrd:i=new Intent(MainActivity.this,AddProduct.class);break;
        }
        startActivity(i);
    }
}