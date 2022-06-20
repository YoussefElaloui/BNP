package com.example.json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView lbl_nom,lbl_adresse,lbl_tel;
    ListView lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lbl_nom=findViewById(R.id.lbl_nom);
        lbl_adresse=findViewById(R.id.lbl_adresse);
        lbl_tel=findViewById(R.id.lbl_tel);
        lst=findViewById(R.id.lst);


        try {
            JSONObject o=new JSONObject(getJsonStringFromRaw(R.raw.etablissement));
            lbl_nom.setText(o.getString("nom"));
            lbl_adresse.setText(o.getString("adresse"));
            lbl_tel.setText(o.getString("tel"));
            JSONArray array=o.getJSONArray("filieres");
            ArrayList<String> list=new ArrayList<>();
            for(int i=0;i<array.length();i++){
                JSONObject ob=array.getJSONObject(i);
                list.add(ob.getString("code")+" - "+ob.getString("nomComplet")+" - "+ob.getDouble("duree"));
            }
            ArrayAdapter<String> ad=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);
            lst.setAdapter(ad);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public String getJsonStringFromRaw(int Rid){
        InputStream input=getResources().openRawResource(Rid);
        String s="";
        try {
            int size=input.available();
            byte[] data=new byte[size];
            input.read(data);
            input.close();
            s= new String(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }



}