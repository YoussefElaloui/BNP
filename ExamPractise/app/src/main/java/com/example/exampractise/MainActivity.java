package com.example.exampractise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txt_poids,txt_age,txt_taille;
    RadioGroup rg_sex,rg_level;
    Button btn_c,btn_i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_poids=findViewById(R.id.txt_poids);
        txt_age=findViewById(R.id.txt_age);
        txt_taille=findViewById(R.id.txt_taille);
        rg_sex=findViewById(R.id.rg_sex);
        rg_level=findViewById(R.id.rg_level);
        btn_c=findViewById(R.id.btn_calculer);
        btn_i=findViewById(R.id.btn_initialisez);

        btn_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rg_sex.check(R.id.rb_male);
                rg_level.check(R.id.rb_ps);
                txt_poids.setText("");
                txt_taille.setText("");
                txt_age.setText("");
                txt_poids.requestFocus();
            }
        });
        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txt_poids.getText().toString().isEmpty()||txt_age.getText().toString().isEmpty()||txt_taille.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Some text zone is empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                double res=0;
                if(rg_sex.getCheckedRadioButtonId()==R.id.rb_male)res=13.76*Double.valueOf(txt_poids.getText().toString())+500.33*Double.valueOf(txt_taille.getText().toString())-6.76*Double.valueOf(txt_age.getText().toString())+66.48;
                else res=9.74*Double.valueOf(txt_poids.getText().toString())+185*Double.valueOf(txt_taille.getText().toString())-4.7*Double.valueOf(txt_age.getText().toString())+655.1;
                
                switch (rg_level.getCheckedRadioButtonId()){
                    case R.id.rb_ps:res*=1.36;break;
                    case R.id.rb_pla:res*=1.56;break;
                    case R.id.rb_pa:res*=1.64;break;
                    case R.id.rb_pta:res*=1.82;break;
                }
                Toast.makeText(MainActivity.this, String.format("Le nombre des calorres est : %8.2f",res), Toast.LENGTH_SHORT).show();
            }
        });
    }
}