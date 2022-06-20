package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleContact extends AppCompatActivity {
    ImageView img;
    TextView nom,prenom,email,tele,date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_contact);

        Utilisateur u=(Utilisateur) getIntent().getExtras().get("user");
        nom=findViewById(R.id.lbl_singleC_lastname);
        prenom=findViewById(R.id.lbl_singleC_firstname);
        img=findViewById(R.id.pic_singleC);
        email=findViewById(R.id.lbl_singleC_email);
        tele=findViewById(R.id.lbl_singleC_tele);
        date=findViewById(R.id.lbl_singleC_date);

        nom.setText(u.getNom());
        prenom.setText(u.getPrenom());
        img.setImageResource(u.getImage());
        email.setText(u.getEmail());
        tele.setText(u.getTel());
        date.setText(u.getDatenaissance().toString());
    }
}