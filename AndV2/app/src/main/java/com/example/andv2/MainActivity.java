package com.example.andv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<CheckBox> lst=new ArrayList<>();
    Button btn;
    ImageView pic;
    RadioGroup rdg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lst.add(findViewById(R.id.i));
        lst.add(findViewById(R.id.a));
        lst.add(findViewById(R.id.w));
        btn=findViewById(R.id.btn);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s="";
                for(CheckBox cb : lst) {
                    s+= String.format("%s : %s",cb.getText().toString(),cb.isChecked()) + "\n";
                }
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
            }
        });

        pic=findViewById(R.id.pic);
        rdg=findViewById(R.id.rdg);
        rdg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (rdg.getCheckedRadioButtonId()){
                    case R.id.rd1:pic.setImageResource(R.drawable.i1);break;
                    case R.id.rd2:pic.setImageResource(R.drawable.i2);break;
                    case R.id.rd3:pic.setImageResource(R.drawable.i3);break;
                    case R.id.rd4:pic.setImageResource(R.drawable.i4);break;
                }
            }
        });
    }
}