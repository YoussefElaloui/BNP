package com.example.efmandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView lst;
    MyDb db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new MyDb(this);
        lst=findViewById(R.id.lst);
        // code to delete later
        try {
            JSONArray ja=new JSONArray(getJsonFromRaw(R.raw.data));
            for(int i=0;i<ja.length();i++){
                JSONObject jo=ja.getJSONObject(i);
                JSONArray ja2=jo.getJSONArray("images");
                MyDb.insertProduct(db.getWritableDatabase(),new Product(
                        jo.getString("title"),
                        jo.getString("description"),
                        jo.getString("brand"),
                        jo.getString("category"),
                        ja2.getString(0),
                        ja2.getString(1),
                        ja2.getString(2)
                ));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ArrayList<HashMap<String,Object>> list=new ArrayList<>();
        ArrayList<Product> ps=MyDb.getAll(db.getReadableDatabase());
        for(Product p : ps){
            HashMap<String,Object> hm=new HashMap<>();
            hm.put("title",p.getTitle());
            hm.put("description",p.getDescription());
            list.add(hm);
        }
        String[] from={ "title","description" };
        int[] to={R.id.lbl_title,R.id.lbl_desc};
        SimpleAdapter ad=new SimpleAdapter(this,list,R.layout.product,from,to);
        lst.setAdapter(ad);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent in=new Intent(MainActivity.this,Details.class);
                in.putExtra("product",ps.get(i));
                startActivity(in);
            }
        });
        lst.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==3){
                    Intent in=new Intent(MainActivity.this,animation.class);
                    startActivity(in);
                }
                return false;
            }
        });
    }
    public String getJsonFromRaw(int id){
        InputStream in=getResources().openRawResource(id);
        String json=null;
        try {
            byte[] size=new byte[in.available()];
            in.read(size);
            json=new String(size);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
    public static Drawable LoadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        } catch (Exception e) {
            return null;
        }
    }
}