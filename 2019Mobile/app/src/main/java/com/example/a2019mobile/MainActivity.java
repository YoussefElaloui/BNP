package com.example.a2019mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText txt_dis,txt_poids;
    Button btn_calcule,btn_initializes;
    TextView txt_res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_dis=findViewById(R.id.distance);
        txt_poids=findViewById(R.id.poids);
        txt_res=findViewById(R.id.res);
        btn_calcule=findViewById(R.id.calcule);
        btn_initializes=findViewById(R.id.initializer);
        btn_calcule.setOnClickListener(this);
        btn_initializes.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.calcule:{
                ArrayList<Double> prices=new ArrayList<Double>();
                if(Double.valueOf(txt_dis.getText().toString())<=100) {
                    prices.add(5.0);
                    prices.add(7.5);
                    prices.add(10.0);
                }else {
                    prices.add(8.0);
                    prices.add(9.5);
                    prices.add(11.0);
                }
                Double result;
                if(Double.valueOf(txt_poids.getText().toString()) <=15)
                    result=prices.get(0)*Double.valueOf(txt_poids.getText().toString());
                else if (Double.valueOf(txt_poids.getText().toString()) <=30)
                    result=prices.get(1)*Double.valueOf(txt_poids.getText().toString());
                else
                    result=prices.get(2)*Double.valueOf(txt_poids.getText().toString());
                txt_res.setText(String.valueOf(result));
            }break;
            case R.id.initializer:{
                txt_dis.setText("");
                txt_poids.setText("");
                txt_res.setText("");
                txt_dis.requestFocus();
            }break;
        }
    }
}