package com.example.efmandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class Details extends AppCompatActivity {

    TextView t,d,b,c;
    ImageView pic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        t=findViewById(R.id.d_title);
        d=findViewById(R.id.d_desc);
        b=findViewById(R.id.d_brand);
        c=findViewById(R.id.d_cat);
        pic=findViewById(R.id.d_pic);
        Product p=(Product) getIntent().getExtras().get("product");
        t.setText(p.getTitle());
        d.setText(p.getDescription());
        b.setText(p.getBrand());
        c.setText(p.getCategory());
        Drawable[] ds={ LoadImageFromWebOperations(p.getPic1()),LoadImageFromWebOperations(p.getPic2()),LoadImageFromWebOperations(p.getPic3()) };
        pic.setImageDrawable(ds[0]);
        pic.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                float start=0,end=0;
                int pos=0;
                switch(motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:start=motionEvent.getX();break;
                    case MotionEvent.ACTION_UP:end=motionEvent.getX();break;
                }
                if(start>end){
                    if(pos==2)pos=0;
                    else pos++;
                }else{
                    if(pos==0)pos=2;
                    else pos--;
                }
                pic.setImageDrawable(ds[pos]);
                return true;
            }
        });
    }
    public static Drawable LoadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, null);
            return d;
        } catch (Exception e) {
            return null;
        }
    }
}