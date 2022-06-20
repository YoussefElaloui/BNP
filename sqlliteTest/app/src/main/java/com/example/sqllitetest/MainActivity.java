package com.example.sqllitetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText txt_last,txt_first;
    Button btn;
    ListView lst;
    ArrayAdapter<String> ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_first=findViewById(R.id.txt_first);
        txt_last=findViewById(R.id.txt_last);
        btn=findViewById(R.id.btn_insert);
        lst=findViewById(R.id.lst);
        Db db=new Db(this);
        ArrayList<Student> lista=db.getAllStudents(db.getReadableDatabase());
        ArrayList<String> ss=new ArrayList<>();
        for(Student s:lista){
            ss.add(s.getLast_name()+" "+s.getFirst_name());
        }
        ad=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,ss);
        lst.setAdapter(ad);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(db.insertStudent(db.getWritableDatabase(),new Student(txt_last.getText().toString(),txt_first.getText().toString()))==-1) {
                    {
                        Toast.makeText(MainActivity.this, "Cannot insert new student", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                Toast.makeText(MainActivity.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                ad.add(txt_last.getText().toString()+" "+txt_first.getText().toString());
            }
        });




        
    }
}