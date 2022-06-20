package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn,btn_login,btn_sum,btn_mines,btn_multi,btn_devi;
    EditText txt_prix,txt_tva,txt_user,txt_pass;
    TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);
        btn_login=findViewById(R.id.btn_login);
        btn_sum=findViewById(R.id.btn_sum);
        btn_devi=findViewById(R.id.btn_divijion);
        btn_mines=findViewById(R.id.btn_mines);
        btn_multi=findViewById(R.id.btn_multi);
        res=findViewById(R.id.res);
        txt_prix=findViewById(R.id.txt_prix);
        txt_tva=findViewById(R.id.txt_tva);
        txt_user=findViewById(R.id.txt_username);
        txt_pass=findViewById(R.id.pass);
        btn.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        btn_sum.setOnClickListener(this);
        btn_mines.setOnClickListener(this);
        btn_multi.setOnClickListener(this);
        btn_devi.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Button b=(Button) view;
        switch (b.getId()){
            case R.id.btn : {
                double prix =Double.valueOf(txt_prix.getText().toString()),tva=Double.valueOf(txt_tva.getText().toString());
                double ttc=prix + prix *tva/100;
                res.setText(String.valueOf(ttc));
                res.setTextSize(50);
            }break;
            case R.id.btn_login:{
                if(txt_user.getText().toString().equalsIgnoreCase("toto") && txt_pass.getText().toString().equalsIgnoreCase("toto"))
                    Toast.makeText(this, "Connection ok", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "Connection ko", Toast.LENGTH_SHORT).show();
            }break;
            case R.id.btn_sum:{
                double num1=Double.valueOf(txt_prix.getText().toString()),num2=Double.valueOf(txt_tva.getText().toString());
                res.setText("The sum is "+(num1+num2));
            }break;
            case R.id.btn_mines:{
                double num1=Double.valueOf(txt_prix.getText().toString()),num2=Double.valueOf(txt_tva.getText().toString());
                res.setText("The Mines is "+(num1-num2));
            }break;
            case R.id.btn_multi:{
                double num1=Double.valueOf(txt_prix.getText().toString()),num2=Double.valueOf(txt_tva.getText().toString());
                res.setText("The multiplay is "+(num1*num2));
            }break;
            case R.id.btn_divijion:{
                double num1=Double.valueOf(txt_prix.getText().toString()),num2=Double.valueOf(txt_tva.getText().toString());
                res.setText("The devision is "+(num1/num2));
            }break;
        }
    }
}