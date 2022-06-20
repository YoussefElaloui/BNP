package com.example.efmandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class animation extends AppCompatActivity {

    ImageView pic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        pic=findViewById(R.id.a_pic);
        RotateAnimation ra=new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
            ra.setDuration(1000);
            ra.setRepeatCount(1000);
            pic.startAnimation(ra);
    }
}