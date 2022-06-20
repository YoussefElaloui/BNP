package com.example.pa4;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.icu.util.MeasureUnit;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener  {

    RadioGroup rdgColor,rdgSize;
    CheckBox ckb_bold,ckb_italic;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rdgColor=findViewById(R.id.rdGColor);
        rdgSize=findViewById(R.id.rdGSize);
        ckb_bold=findViewById(R.id.bold);
        ckb_italic=findViewById(R.id.italic);
        txt=findViewById(R.id.text);

        rdgColor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.black:txt.setTextColor(Color.BLACK);break;
                    case  R.id.yellow:txt.setTextColor(Color.YELLOW);break;
                    case  R.id.blue:txt.setTextColor(Color.BLUE);break;
                    case  R.id.red:txt.setTextColor(Color.RED);break;
                }
            }
        });
        rdgSize.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.size30:txt.setTextSize(3,30);break;
                    case R.id.size40:txt.setTextSize(3,40);break;
                    case R.id.size50:txt.setTextSize(3,50);break;
                    case R.id.size60:txt.setTextSize(3,60);break;
                }
            }
        });
        ckb_bold.setOnCheckedChangeListener(this);
        ckb_italic.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(ckb_bold.isChecked() && ckb_italic.isChecked())
            txt.setTypeface(null, Typeface.BOLD_ITALIC);
        else if(ckb_bold.isChecked())
            txt.setTypeface(null,Typeface.BOLD);
        else if (ckb_italic.isChecked())
            txt.setTypeface(null,Typeface.ITALIC);
        else txt.setTypeface(null, Typeface.NORMAL);
    }
}