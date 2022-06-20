package com.example.pa5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,TextWatcher {

    EditText txt_poids,txt_taille;
    Button btn_calculer,raz;
    RadioGroup rdg;
    CheckBox chb;
    TextView txt_res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_poids=findViewById(R.id.txt_poids);
        txt_taille=findViewById(R.id.txt_taille);
        btn_calculer=findViewById(R.id.btn_calculer);
        raz=findViewById(R.id.btn_rac);
        rdg=findViewById(R.id.rdg_unite);
        chb=findViewById(R.id.chb_afficher);
        txt_res=findViewById(R.id.res);

        btn_calculer.setOnClickListener(this);
        raz.setOnClickListener(this);
        txt_taille.addTextChangedListener(this);
        txt_poids.addTextChangedListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_calculer: {
                float taille;
                if(rdg.getCheckedRadioButtonId()==R.id.rd_metre)
                    taille=Float.valueOf(txt_taille.getText().toString());
                else taille=Float.valueOf(txt_taille.getText().toString())/100;
                txt_res.setText(String.valueOf(Float.parseFloat(txt_poids.getText().toString())/taille));
                if(chb.isChecked()){
                    float imc= Float.valueOf(txt_res.getText().toString());
                    String adding="\n";
                    if(imc<=18.5) adding+="insuffisance pondérale";
                    else if (imc<=24.9) adding+="poids normal";
                    else if (imc<=29.9) adding+="surpoids";
                    else adding+="obésité";
                    txt_res.setText(txt_res.getText().toString()+adding);
                }
            }break;
            case R.id.btn_rac:
                txt_poids.setText("");
                txt_res.setText("");
                txt_taille.setText("");
                txt_poids.requestFocus();break;
        }
        }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        txt_res.setText("");
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}